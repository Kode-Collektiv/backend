package de.helpnoweatlater.backend.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {


    @Id
    private final String id;

    private final String firstName;

    private final String lastName;

    private final String email;


    public static User of(final String id, final String firstName, final String lastName, final String email){
        return new User(id, firstName, lastName, email);
    }

    private User(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
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
