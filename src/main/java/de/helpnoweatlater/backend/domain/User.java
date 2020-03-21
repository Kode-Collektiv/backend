package de.helpnoweatlater.backend.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Entity
public class User extends AbstractEntity {

    private String firstName;
    private String lastName;

    @Email
    private String email;

}
