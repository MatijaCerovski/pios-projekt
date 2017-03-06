package com.pios.persistence.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Matija on 3/6/2017.
 */
@Entity
@Table(name = "accommodations", catalog = "pios_baza")
public class Accommodation {
    private int accommodationId;
    private String name;
    private Set<Image> images;
    private Set<Order> orders;

    @Id
    @Column(name = "accommodation_id")
    public int getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(int accommodationId) {
        this.accommodationId = accommodationId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accommodation that = (Accommodation) o;

        if (accommodationId != that.accommodationId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accommodationId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "accommodation")
    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @OneToMany(mappedBy = "accommodation")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
