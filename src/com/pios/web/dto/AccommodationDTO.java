package com.pios.web.dto;

import org.hibernate.validator.constraints.NotEmpty;

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

    public AccommodationDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
