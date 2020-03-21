package de.helpnoweatlater.backend.domain;

import org.springframework.data.annotation.Id;

public abstract class AbstractDocument {

    @Id
    private String id;

    public AbstractDocument(String id) {
        this.id = id;
    }

    public AbstractDocument(){}


    public String getId() {
        return id;
    }


}
