package com.Miranda.osworks.osworksapi.api.controller;


import com.Miranda.osworks.osworksapi.api.model.CommentInput;
import com.Miranda.osworks.osworksapi.api.model.CommentModel;
import com.Miranda.osworks.osworksapi.api.model.ServiceOrderModel;
import com.Miranda.osworks.osworksapi.domain.exception.EntityNotFoundException;
import com.Miranda.osworks.osworksapi.domain.model.Comment;
import com.Miranda.osworks.osworksapi.domain.model.ServiceOrder;
import com.Miranda.osworks.osworksapi.domain.repository.ServiceOrderRepository;
import com.Miranda.osworks.osworksapi.domain.service.ManagementServiceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service-order/{serviceOrderId}/comments")
public class CommentController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ManagementServiceOrderService management;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private CommentModel add(@PathVariable Long serviceOrderId, @Valid @RequestBody CommentInput commentInput){


        Comment comment = management.addComment(commentInput.getDescription(),
                                                serviceOrderId);

        return toModel(comment);
    }

    @GetMapping
    private List<CommentModel> list(@PathVariable Long serviceOrderId){
        ServiceOrder serviceOrder = serviceOrderRepository.findById(serviceOrderId)
                .orElseThrow(() -> new EntityNotFoundException("entity not found"));


        return toCollectionModel(serviceOrder.getComments());
    }

    private CommentModel toModel(Comment comment){
        return modelMapper.map(comment, CommentModel.class);
    }

    private List<CommentModel> toCollectionModel(List<Comment> comments){
        return comments.stream()
                .map(comment -> toModel(comment))
                .collect(Collectors.toList());
    }
}
