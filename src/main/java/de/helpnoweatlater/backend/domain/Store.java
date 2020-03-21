package de.helpnoweatlater.backend.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Store extends AbstractDocument  {

    private final String name;

    private final User owner;

    private final Address address;

    private final Date createdAt;

    private final StoreType storeType;

    public Store(String id, String name, User owner, Address address, Date createdAt, StoreType storeType) {
        super(id);
        this.name = name;
        this.owner = owner;
        this.address = address;
        this.createdAt = createdAt;
        this.storeType = storeType;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public Address getAddress() {
        return address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public StoreType getStoreType() {
        return storeType;
    }
}
