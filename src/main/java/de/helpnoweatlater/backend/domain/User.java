package de.helpnoweatlater.backend.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User extends AbstractDocument{


    private final String firstName;

    private final String lastName;

    private final String email;


    public static User of(final String firstName, final String lastName, final String email){
        return new User(firstName, lastName, email);
    }

    private User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
