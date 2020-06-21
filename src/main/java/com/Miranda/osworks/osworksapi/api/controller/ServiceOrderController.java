package com.Miranda.osworks.osworksapi.api.controller;


import com.Miranda.osworks.osworksapi.api.model.ServiceOrderInput;
import com.Miranda.osworks.osworksapi.api.model.ServiceOrderModel;
import com.Miranda.osworks.osworksapi.domain.model.ServiceOrder;
import com.Miranda.osworks.osworksapi.domain.repository.ServiceOrderRepository;
import com.Miranda.osworks.osworksapi.domain.service.ManagementServiceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ManagementServiceOrderService managementService;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    private List<ServiceOrderModel> list(){
        return toCollectionModel(serviceOrderRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceOrderModel create(@Valid @RequestBody ServiceOrderInput serviceOrderInput) {
        ServiceOrder serviceOrder = toEntity(serviceOrderInput);
        return toModel(managementService.create(serviceOrder));
    }

    @GetMapping("{serviceOrderId}")
    public ResponseEntity<ServiceOrderModel> search(@PathVariable Long serviceOrderId){
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(serviceOrderId);


        return serviceOrder.map(order -> ResponseEntity.ok(toModel(order)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    private ServiceOrderModel toModel(ServiceOrder serviceOrder){
        return modelMapper.map(serviceOrder, ServiceOrderModel.class);
    }

    private ServiceOrder toEntity(ServiceOrderInput serviceOrderInput){
        return modelMapper.map(serviceOrderInput, ServiceOrder.class);
    }

    private List<ServiceOrderModel> toCollectionModel(List<ServiceOrder> serviceOrders){
        return serviceOrders.stream()
                .map(serviceOrder -> toModel(serviceOrder))
                .collect(Collectors.toList());
    }
}
