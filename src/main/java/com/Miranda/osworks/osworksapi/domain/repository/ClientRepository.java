package com.Miranda.osworks.osworksapi.domain.repository;

import com.Miranda.osworks.osworksapi.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findClientByName(String nome);

    List<Client> findClientByNameContaining(String name);

}
