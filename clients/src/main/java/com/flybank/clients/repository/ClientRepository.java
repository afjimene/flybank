package com.flybank.clients.repository;

import com.flybank.clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByIdTypeAndIdNumber(String idType, Integer idNumber);
}
