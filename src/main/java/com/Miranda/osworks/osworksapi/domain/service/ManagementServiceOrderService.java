package com.Miranda.osworks.osworksapi.domain.service;


import com.Miranda.osworks.osworksapi.domain.exception.DomainException;
import com.Miranda.osworks.osworksapi.domain.model.Client;
import com.Miranda.osworks.osworksapi.domain.model.ServiceOrder;
import com.Miranda.osworks.osworksapi.domain.model.ServiceOrderStatus;
import com.Miranda.osworks.osworksapi.domain.repository.ClientRepository;
import com.Miranda.osworks.osworksapi.domain.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ManagementServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    public ServiceOrder create(ServiceOrder serviceOrder){
        Client client = clientRepository.findById(serviceOrder.getClient().getId())
                .orElseThrow(() -> new DomainException("client not found"));


        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setOpeningDate(LocalDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }
}