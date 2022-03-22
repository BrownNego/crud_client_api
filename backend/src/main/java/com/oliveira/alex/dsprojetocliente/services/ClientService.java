package com.oliveira.alex.dsprojetocliente.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oliveira.alex.dsprojetocliente.dto.ClientDTO;
import com.oliveira.alex.dsprojetocliente.entities.Client;
import com.oliveira.alex.dsprojetocliente.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		
		//Método Lambda
		List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		return listDto;
		
		//Método utilizando For
//		List<ClientDTO> listDto = new ArrayList<>();
//			
//		for(Client cli : list) {
//				
//			listDto.add(new ClientDTO(cli));
//		}
//		
//		return listDto;
}
	

}
