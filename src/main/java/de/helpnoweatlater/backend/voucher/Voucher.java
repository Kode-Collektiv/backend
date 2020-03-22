package de.helpnoweatlater.backend.voucher;

import de.helpnoweatlater.backend.store.Store;
import de.helpnoweatlater.backend.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Voucher {


    @Id
    private final String id;
    @DBRef
    private final Store store;

    @DBRef
    private final User issuedFor;

    private final Date createdAt;

    private final boolean verified;

    public static Voucher of(final String id, final Store store, final User issuedFor, final Date createdAt, final boolean verified){
        return new Voucher(id, store, issuedFor, createdAt, verified);
    }

    private Voucher(String id, Store store, User issuedFor, Date createdAt, boolean verified) {
        this.id = id;
        this.store = store;
        this.issuedFor = issuedFor;
        this.createdAt = createdAt;
        this.verified = verified;
    }

    public String getId() {
        return id;
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
