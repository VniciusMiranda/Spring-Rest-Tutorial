package com.Miranda.osworks.osworksapi.api.controller;


import com.Miranda.osworks.osworksapi.domain.model.ServiceOrder;
import com.Miranda.osworks.osworksapi.domain.repository.ServiceOrderRepository;
import com.Miranda.osworks.osworksapi.domain.service.ManagementServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ManagementServiceOrderService managementService;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrder create(@Valid @RequestBody ServiceOrder serviceOrder) {
        return managementService.create(serviceOrder);
    }

    @GetMapping("{serviceOrderId}")
    public ResponseEntity<ServiceOrder> search(@PathVariable Long serviceOrderId){
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(serviceOrderId);


        return serviceOrder.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
