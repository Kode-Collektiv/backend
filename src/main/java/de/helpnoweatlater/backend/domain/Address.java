package de.helpnoweatlater.backend.domain;

import javax.persistence.Embeddable;
import java.util.Locale;

@Embeddable
public class Address {

    private String city;
    private Locale country;
    private String zipCode;
    private String street;
    private String streetNumber;

}
