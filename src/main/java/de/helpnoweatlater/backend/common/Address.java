package de.helpnoweatlater.backend.common;

import java.util.Locale;


public class Address {

    private final String city;
    private final Locale country;
    private final String zipCode;
    private final String street;
    private final String streetNumber;


    public Address of(final String city,
                      final Locale country,
                      final String zipCode,
                      final String street,
                      final String streetNumber){
        return new Address(city, country, zipCode,street, streetNumber);
    }

    private Address(String city, Locale country, String zipCode, String street, String streetNumber) {
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public Locale getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }
}
