package com.Miranda.osworks.osworksapi.controller;

import com.Miranda.osworks.osworksapi.domain.model.Client;
import com.Miranda.osworks.osworksapi.domain.repository.ClientRepository;
import com.Miranda.osworks.osworksapi.domain.service.SignUpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SignUpClientService signUpClientService;


    @GetMapping
    public ResponseEntity<List<Client>> list() {
        List<Client> client = clientRepository.findAll();

        return !client.isEmpty() ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }


    @GetMapping("{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@Valid @RequestBody Client client) {

        return signUpClientService.save(client);
    }

    @PutMapping("{clientId}")
    public ResponseEntity<Client> update(@Valid @RequestBody Client client,
                                         @PathVariable Long clientId) {

        client.setId(clientId);
        return !clientRepository.existsById(clientId) ? ResponseEntity.notFound().build() :
                ResponseEntity.ok(signUpClientService.save(client));
    }


    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId){

        signUpClientService.delete(clientId);
        return ResponseEntity.noContent().build();
    }
}