package edu.bcm.api.taleo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String loginName = null;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("FirstName: ").append(this.getFirstName());
        builder.append(" | LastName: ").append(this.getLastName());
        builder.append(" | Email: ").append(this.getEmail());
        builder.append(" | LoginName: ").append(this.getLoginName());
        builder.append(" ]\n");

        return builder.toString();
    }
}
