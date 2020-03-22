package de.helpnoweatlater.backend.domain;

import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class Offer {

    private String summary;

    private String details;

    @CreatedDate
    private Date createdAt;


}
