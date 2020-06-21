package com.Miranda.osworks.osworksapi.domain.service;


import com.Miranda.osworks.osworksapi.domain.exception.DomainException;
import com.Miranda.osworks.osworksapi.domain.exception.EntityNotFoundException;
import com.Miranda.osworks.osworksapi.domain.model.Client;
import com.Miranda.osworks.osworksapi.domain.model.Comment;
import com.Miranda.osworks.osworksapi.domain.model.ServiceOrder;
import com.Miranda.osworks.osworksapi.domain.model.ServiceOrderStatus;
import com.Miranda.osworks.osworksapi.domain.repository.ClientRepository;
import com.Miranda.osworks.osworksapi.domain.repository.CommentRepository;
import com.Miranda.osworks.osworksapi.domain.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class ManagementServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommentRepository commentRepository;

    public ServiceOrder create(ServiceOrder serviceOrder){
        Client client = clientRepository.findById(serviceOrder.getClient().getId())
                .orElseThrow(() -> new DomainException("client not found"));


        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setOpeningDate(OffsetDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }

    public Comment addComment(String description, Long serviceOrderId){
        ServiceOrder serviceOrder = serviceOrderRepository.findById(serviceOrderId)
                .orElseThrow(() -> new EntityNotFoundException("entity not found"));


        Comment comment = new Comment();

        comment.setDescription(description);
        comment.setSentTime(OffsetDateTime.now());
        comment.setServiceOrder(serviceOrder);

        return commentRepository.save(comment);
    }
}
