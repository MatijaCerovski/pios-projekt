package com.pios.web.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Matija on 3/7/2017.
 */
public class AccommodationDTO {

    @NotNull
    @NotEmpty
    @Size(max = 254)
    private String name;

    @NotEmpty
    @NotNull
    private MultipartFile images[];


    public AccommodationDTO() {
    }

    public AccommodationDTO(String name, MultipartFile[] images) {
        this.name = name;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile[] getImages() {
        return images;
    }

    public void setImages(MultipartFile[] images) {
        this.images = images;
    }

}
