package com.Miranda.osworks.osworksapi.api.controller;


import com.Miranda.osworks.osworksapi.api.model.CommentInput;
import com.Miranda.osworks.osworksapi.api.model.CommentModel;
import com.Miranda.osworks.osworksapi.domain.model.Comment;
import com.Miranda.osworks.osworksapi.domain.service.ManagementServiceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/service-order/{serviceOrderId}/comments")
public class CommentController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ManagementServiceOrderService management;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private CommentModel add(@PathVariable Long serviceOrderId, @Valid @RequestBody CommentInput commentInput){


        Comment comment = management.addComment(commentInput.getDescription(),
                                                serviceOrderId);

        return toModel(comment);
    }

    private CommentModel toModel(Comment comment){
        return modelMapper.map(comment, CommentModel.class);
    }

}
