package de.helpnoweatlater.backend.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Store extends AbstractEntity {

    private String name;

    @OneToOne
    private User owner;

    private Address address;

    @CreationTimestamp
    private Date createdAt;

    private StoreType storeType;


}
