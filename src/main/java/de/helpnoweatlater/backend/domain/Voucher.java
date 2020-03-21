package de.helpnoweatlater.backend.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Voucher {


    private final Store store;

    private final User issuedFor;

    private final Date createdAt;

    private final boolean verified;

    public static Voucher of(final Store store, final User issuedFor, final Date createdAt, final boolean verified){
        return new Voucher(store, issuedFor, createdAt, verified);
    }

    private Voucher(Store store, User issuedFor, Date createdAt, boolean verified) {
        this.store = store;
        this.issuedFor = issuedFor;
        this.createdAt = createdAt;

        this.verified = verified;
    }

    public Store getStore() {
        return store;
    }

    public User getIssuedFor() {
        return issuedFor;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isVerified() {
        return verified;
    }
}
