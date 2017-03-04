package com.pios.web.dto;

import com.pios.validation.PasswordMatches;
import com.pios.validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Matija on 3/4/2017.
 */

@PasswordMatches
public class UserRegistrationDTO {

    @NotNull
    @NotEmpty
    @Size(max=45)
    private String username;

    @NotNull
    @NotEmpty
    @Size(max=254)
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    @Size(max=60)
    private String password;

    @NotNull
    @NotEmpty
    @Size(max=60)
    private String matchingPassword;




    public UserRegistrationDTO() {
        super();
    }

    public UserRegistrationDTO(String username, String email, String password, String confirmedPassword) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.matchingPassword = confirmedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }


}