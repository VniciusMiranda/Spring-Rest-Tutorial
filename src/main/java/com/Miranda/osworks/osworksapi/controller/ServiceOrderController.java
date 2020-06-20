package com.Miranda.osworks.osworksapi.controller;


import com.Miranda.osworks.osworksapi.domain.model.ServiceOrder;
import com.Miranda.osworks.osworksapi.domain.service.ManagementServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ManagementServiceOrderService managementService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrder create(@Valid @RequestBody ServiceOrder serviceOrder) {
        return managementService.create(serviceOrder);
    }


}
