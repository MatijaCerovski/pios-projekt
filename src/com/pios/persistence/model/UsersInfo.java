package com.pios.persistence.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Matija on 19.4.2017..
 */
@Entity
@Table(name = "users_info", schema = "pios_baza", catalog = "pios_baza")
public class UsersInfo {
    private String name;
    private String surname;
    private Date birthDate;
    private String cityTown;
    private String postalCode;
    private String streetName;
    private Integer streetNumber;
    private Integer phone;
    private Integer cellPhone;
    private int userInfoId;
    private User user;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "city_town")
    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(String cityTown) {
        this.cityTown = cityTown;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "street_name")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Basic
    @Column(name = "street_number")
    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "cell_phone")
    public Integer getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Integer cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Id
    @Column(name = "user_info_id")
    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersInfo usersInfo = (UsersInfo) o;

        if (userInfoId != usersInfo.userInfoId) return false;
        if (name != null ? !name.equals(usersInfo.name) : usersInfo.name != null) return false;
        if (surname != null ? !surname.equals(usersInfo.surname) : usersInfo.surname != null) return false;
        if (birthDate != null ? !birthDate.equals(usersInfo.birthDate) : usersInfo.birthDate != null) return false;
        if (cityTown != null ? !cityTown.equals(usersInfo.cityTown) : usersInfo.cityTown != null) return false;
        if (postalCode != null ? !postalCode.equals(usersInfo.postalCode) : usersInfo.postalCode != null) return false;
        if (streetName != null ? !streetName.equals(usersInfo.streetName) : usersInfo.streetName != null) return false;
        if (streetNumber != null ? !streetNumber.equals(usersInfo.streetNumber) : usersInfo.streetNumber != null)
            return false;
        if (phone != null ? !phone.equals(usersInfo.phone) : usersInfo.phone != null) return false;
        if (cellPhone != null ? !cellPhone.equals(usersInfo.cellPhone) : usersInfo.cellPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (cityTown != null ? cityTown.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        result = 31 * result + userInfoId;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
