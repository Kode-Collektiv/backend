package de.helpnoweatlater.backend.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Voucher {


    private final Store store;

    private final User issuedFor;

    private final Date createdAt;

    private final Date expiresAt;

    private final boolean verified;

    public Voucher(Store store, User issuedFor, Date createdAt, Date expiresAt, boolean verified) {
        this.store = store;
        this.issuedFor = issuedFor;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
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

    public Date getExpiresAt() {
        return expiresAt;
    }

    public boolean isVerified() {
        return verified;
    }
}
