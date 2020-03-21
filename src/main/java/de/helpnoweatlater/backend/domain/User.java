package de.helpnoweatlater.backend.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;

@Document
public class User {


    private final String firstName;

    private final String lastName;

    @Email
    private final String email;



    public User(String firstName, String lastName, @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
