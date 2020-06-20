package com.Miranda.osworks.osworksapi.controller;

import com.Miranda.osworks.osworksapi.domain.model.Client;
import com.Miranda.osworks.osworksapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public ResponseEntity<List<Client>> list(){
        List<Client> client = clientRepository.findAll();
        
        return !client.isEmpty() ? ResponseEntity.ok(client) : ResponseEntity.notFound().build() ;
    }


    @GetMapping("{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId){
        Optional<Client> client = clientRepository.findById(clientId);

        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
