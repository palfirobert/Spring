package com.webusermanagement.entity;

import com.webusermanagement.validation.FieldMatch;
import org.hibernate.validator.constraints.NotEmpty;

@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class ChangePassword {
    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    public ChangePassword(){}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
