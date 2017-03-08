package com.pios.persistence.model;

import javax.persistence.*;

/**
 * Created by Matija on 3/7/2017.
 */
@Entity
@Table(name = "images", catalog = "pios_baza")
public class Image {
    private int imageId;
    private int accommodationId;
    private String name;
    private Accommodation accommodation;

    @Id
    @Column(name = "image_id")
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
