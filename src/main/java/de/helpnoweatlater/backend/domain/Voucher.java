package de.helpnoweatlater.backend.domain;

import jdk.jfr.Enabled;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Voucher extends AbstractEntity {

    @ManyToOne
    private Store store;

    @ManyToOne
    private User issuedFor;

    @CreationTimestamp
    private Date createdAt;

    private Date expiresAt;

    private boolean verified;

}
