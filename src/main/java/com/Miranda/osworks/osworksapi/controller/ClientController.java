package com.Miranda.osworks.osworksapi.controller;

import com.Miranda.osworks.osworksapi.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ClientController {

    @GetMapping("/clients")
    public String list(){

        return "test";
    }
}
