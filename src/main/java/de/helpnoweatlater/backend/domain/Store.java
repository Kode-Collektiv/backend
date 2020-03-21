package de.helpnoweatlater.backend.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Store extends AbstractDocument  {

    private final String name;

    private final StoreContact storeContact;

    @CreatedDate
    private final Date createdAt;

    private final StoreType storeType;


    public static Store of(final String name, final StoreContact storeContact, final Date createdAt, final StoreType storeType){
        return new Store(name, storeContact, createdAt, storeType);
    }

    private Store(String name, StoreContact storeContact, Date createdAt, StoreType storeType) {
        this.name = name;
        this.storeContact = storeContact;
        this.createdAt = createdAt;
        this.storeType = storeType;
    }

    public String getName() {
        return name;
    }

    public StoreContact getStoreContact() {
        return storeContact;
    }

    public StoreType getStoreType() {
        return storeType;
    }
}
