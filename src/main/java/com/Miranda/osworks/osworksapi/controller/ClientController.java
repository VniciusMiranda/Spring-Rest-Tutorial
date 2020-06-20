package com.Miranda.osworks.osworksapi.controller;

import com.Miranda.osworks.osworksapi.domain.model.Client;
import com.Miranda.osworks.osworksapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public ResponseEntity<List<Client>> list() {
        List<Client> client = clientRepository.findAll();

        return !client.isEmpty() ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }


    @GetMapping("{clientId}")
    public ResponseEntity<Client> search(@Valid @PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@RequestBody Client client) {

        return clientRepository.save(client);
    }

    @PutMapping("{clientId}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody Client client) {

        client.setClientId(clientId);
        return !clientRepository.existsById(clientId) ? ResponseEntity.notFound().build() :
                ResponseEntity.ok(clientRepository.save(client));
    }


    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long clientId){

        clientRepository.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }
}