package com.oliveira.alex.dsprojetocliente.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		
		//Method Lambda
		Page<ClientDTO> listDto = list.map(x -> new ClientDTO(x));
		return listDto;
		
		//Method using For
//		List<ClientDTO> listDto = new ArrayList<>();
//			
//		for(Client cli : list) {
//				
//			listDto.add(new ClientDTO(cli));
//		}
//		
//		return listDto;
}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.get();
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
		entity = repository.save(entity);
		
		return new ClientDTO(entity);
	}

	

}
