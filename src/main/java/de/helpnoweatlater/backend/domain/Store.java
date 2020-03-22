package de.helpnoweatlater.backend.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;

@Document
public class Store extends AbstractDocument  {

    private final String name;

    private final StoreContact storeContact;

    @CreatedDate
    private final Date createdAt;

    private final Collection<Offer> offers;

    private final StoreType storeType;


    public static Store of(final String name, final StoreContact storeContact, final Date createdAt, final StoreType storeType, final Collection<Offer> offers){
        return new Store(name, storeContact, createdAt, offers, storeType);
    }

    private Store(String name, StoreContact storeContact, Date createdAt, Collection<Offer> offers, StoreType storeType) {
        this.name = name;
        this.storeContact = storeContact;
        this.createdAt = createdAt;
        this.offers = offers;
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

    public Collection<Offer> getOffers() {
        return offers;
    }
}
