package com.Miranda.osworks.osworksapi.domain.service;

import com.Miranda.osworks.osworksapi.domain.exception.DomainException;
import com.Miranda.osworks.osworksapi.domain.model.Client;
import com.Miranda.osworks.osworksapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SignUpClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client){
        if(clientRepository.findAll().isEmpty())
            return clientRepository.save(client);


        Client existingClient = clientRepository.findClientByEmailAddress(client.getEmailAddress());

        if(existingClient != null && !existingClient.equals(client)){
            throw new DomainException("There is already an user sign up with this email!!");
        }

        return clientRepository.save(client);
    }

    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }
}
