package com.Miranda.osworks.osworksapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ServiceOrderStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime openingDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime finishingDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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

    public void setStatus(ServiceOrderStatus serviceOrderStatus) {
        this.status = serviceOrderStatus;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDateTime getFinishingDate() {
        return finishingDate;
    }

    public void setFinishingDate(LocalDateTime finishDate) {
        this.finishingDate = finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return id.equals(that.id) &&
                client.equals(that.client) &&
                description.equals(that.description) &&
                price.equals(that.price) &&
                status == that.status &&
                openingDate.equals(that.openingDate) &&
                finishingDate.equals(that.finishingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, description, price, status, openingDate, finishingDate);
    }
}
