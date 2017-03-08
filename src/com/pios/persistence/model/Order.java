package com.pios.persistence.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Matija on 3/7/2017.
 */
@Entity
@Table(name = "orders", catalog = "pios_baza")
public class Order {
    private int orderId;
    private int accommodationId;
    private Date startDate;
    private Date endDate;
    private Accommodation accommodation;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @ManyToOne
    @JoinColumn(name = "accommodation_id", referencedColumnName = "accommodation_id", nullable = false)
    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
