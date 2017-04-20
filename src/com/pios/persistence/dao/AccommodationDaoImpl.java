package com.pios.persistence.dao;

import com.pios.persistence.model.Accommodation;
import com.pios.persistence.model.Image;
import com.pios.persistence.model.Order;
import com.pios.web.dto.AccommodationDTO;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Matija on 3/8/2017.
 */
@Repository
public class AccommodationDaoImpl implements AccommodationDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Accommodation addAccommodation(AccommodationDTO accommodationDTO, String username) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(accommodationDTO.getName());
        accommodation.setUsername(username);

        sessionFactory.getCurrentSession().save(accommodation);

        return accommodation;
    }

    @Override
    public Accommodation getAccommodation(int accommodationId) {
        Accommodation accommodation = sessionFactory.getCurrentSession().get(Accommodation.class, accommodationId);
        Hibernate.initialize(accommodation.getImages());
        Hibernate.initialize(accommodation.getOrders());
        return accommodation;
    }

    @Override
    public List<Accommodation> getAllAccommodations() {

        List<Accommodation> accommodations = sessionFactory.getCurrentSession().createCriteria(Accommodation.class).list();

        return accommodations;
    }

    @Override
    public Image addImage(Image image) {

        sessionFactory.getCurrentSession().save(image);


        return image;
    }

    @Override
    public List<Accommodation> fetchUserAccommodation(String username) {
       return sessionFactory.getCurrentSession().createCriteria(Accommodation.class).add(Restrictions.eq("username", username)).list();
    }

    @Override
    public void setAccommodationOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order getOrderById(Integer orderId) {
       List<Order> orders = sessionFactory.getCurrentSession().createQuery("from Order where orderId=?").setParameter(0, orderId)
                .list();

       //vrati jedini order jer je samo jedan s tim ID-em ako nije onda nekaj nevalja ili ga nema uopce(nullpointer alert)
        return orders.get(0);
    }

    @Override
    public void updateOrderStatus(Order order) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("update Order set username = :username, reserved = :reserved" +
                " where orderId = :orderId");
        query.setParameter("username", order.getUsername());
        query.setParameter("reserved", order.getReserved());
        query.setParameter("orderId", order.getOrderId());
        int result = query.executeUpdate();


    }


}
