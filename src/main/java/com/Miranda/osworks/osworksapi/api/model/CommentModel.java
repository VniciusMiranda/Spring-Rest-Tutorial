package com.Miranda.osworks.osworksapi.api.model;

import java.time.OffsetDateTime;

public class CommentModel {
    private Long id;
    private String description;
    private OffsetDateTime sentTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(OffsetDateTime sentTime) {
        this.sentTime = sentTime;
    }
}
