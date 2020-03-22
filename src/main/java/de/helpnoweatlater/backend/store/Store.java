package de.helpnoweatlater.backend.store;

import de.helpnoweatlater.backend.payment.Offer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;

@Document
public class Store {

    @Id
    private final String id;

    private final String name;

    private final StoreContact storeContact;

    @CreatedDate
    private final Date createdAt;

    private final Collection<Offer> offers;

    private final StoreType storeType;


    public static Store of(final String id, final String name, final StoreContact storeContact, final Date createdAt, final StoreType storeType, final Collection<Offer> offers){
        return new Store(id, name, storeContact, createdAt, offers, storeType);
    }

    private Store(String id, String name, StoreContact storeContact, Date createdAt, Collection<Offer> offers, StoreType storeType) {
        this.id = id;
        this.name = name;
        this.storeContact = storeContact;
        this.createdAt = createdAt;
        this.offers = offers;
        this.storeType = storeType;
    }

    public String getId() {
        return id;
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
