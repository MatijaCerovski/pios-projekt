package com.pios.persistence.model;

import javax.persistence.*;

/**
 * Created by Matija on 3/6/2017.
 */
@Entity
@Table(name = "images", catalog = "pios_baza")
public class Image {
    private int imageId;
    private int accommodationId;
    private Accommodation accommodation;

    @Id
    @Column(name = "image_id")
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (imageId != image.imageId) return false;
        if (accommodationId != image.accommodationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId;
        result = 31 * result + accommodationId;
        return result;
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
