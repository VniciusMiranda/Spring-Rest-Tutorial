package com.Miranda.osworks.osworksapi.api.model;

import com.Miranda.osworks.osworksapi.domain.model.ServiceOrderStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ServiceOrderModel {

    private Long id;
    private ClientModel client;
    private String description;
    private BigDecimal price;
    private ServiceOrderStatus status;
    private OffsetDateTime openingDate;
    private OffsetDateTime finishingDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ServiceOrderStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }

    public OffsetDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(OffsetDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public OffsetDateTime getFinishingDate() {
        return finishingDate;
    }

    public void setFinishingDate(OffsetDateTime finishingDate) {
        this.finishingDate = finishingDate;
    }
}
