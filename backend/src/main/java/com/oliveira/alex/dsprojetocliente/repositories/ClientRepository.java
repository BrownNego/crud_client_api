package com.oliveira.alex.dsprojetocliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliveira.alex.dsprojetocliente.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
