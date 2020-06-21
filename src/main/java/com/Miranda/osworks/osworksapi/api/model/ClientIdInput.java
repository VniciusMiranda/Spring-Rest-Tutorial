package com.Miranda.osworks.osworksapi.api.model;

import javax.validation.constraints.NotNull;

public class ClientIdInput {

    @NotNull
    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
