package de.helpnoweatlater.backend.domain;

public class StoreContact {

    private final String email;
    private final String telephone;
    private final Address address;


    public static StoreContact of(final String email, final String telephone, final Address address){
        return new StoreContact(email, telephone, address);
    }

    private StoreContact(String email, String telephone, Address address) {
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }
}
