package com.oliveira.alex.dsprojetocliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.alex.dsprojetocliente.dto.ClientDTO;
import com.oliveira.alex.dsprojetocliente.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public List<ClientDTO> findAll(){		
		return service.findAll();
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findaById(@PathVariable Long id){
		ClientDTO cli = service.findById(id);
		return ResponseEntity.ok().body(cli);
	}
	
}
