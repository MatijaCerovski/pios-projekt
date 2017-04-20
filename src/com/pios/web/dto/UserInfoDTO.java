package com.pios.web.dto;

import com.pios.persistence.model.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Created by Matija on 19.4.2017..
 */
public class UserInfoDTO {

    @NotNull
    @NotEmpty
    @Size(max = 35)
    private String name;

    @NotNull
    @NotEmpty
    @Size(max = 35)
    private String surname;

    @NotNull
    private Date birthDate;

    @NotNull
    @NotEmpty
    @Size(max = 254)
    private String cityTown;

    @NotNull
    private String postalCode;

    @NotNull
    @NotEmpty
    @Size(max = 254)
    private String streetName;

    @NotNull
    private Integer streetNumber;

    private Integer phone;

    @NotNull
    private Integer cellPhone;

    @NotNull
    private Integer userInfoId;

    @NotNull
    @NotEmpty
    @Size(max = 45)
    private String username;

    public UserInfoDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(String cityTown) {
        this.cityTown = cityTown;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Integer cellPhone) {
        this.cellPhone = cellPhone;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
