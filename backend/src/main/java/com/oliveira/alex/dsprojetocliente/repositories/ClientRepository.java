package com.oliveira.alex.dsprojetocliente.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.oliveira.alex.dsprojetocliente.entities.Client;

public interface ClientRepository extends JpaRepositoryImplementation<Client, Long> {

}
