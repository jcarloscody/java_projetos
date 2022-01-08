package com.conquistandoavaga.winner.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquistandoavaga.winner.domain.Cliente;
import com.conquistandoavaga.winner.dto.ClienteDTO;
import com.conquistandoavaga.winner.services.ClienteService;

@RestController
@RequestMapping(value = "/client")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente Cliente = service.find(id);
		return ResponseEntity.ok().body(Cliente);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id){
		Cliente obj = service.update(service.fromDTO(objDTO));
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	 
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		 List<Cliente> cliente = service.findAll();
		 
		 //usando o DTO 
		List<ClienteDTO> clienteDTO = cliente.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(clienteDTO);
	}
	
	
	///categories/page?linesPerPage=1&page1
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPage(
		@RequestParam(value = "page", defaultValue = "0") Integer page, 
		@RequestParam(value = "linesPerPage", defaultValue = "2")  Integer linesPerPage, 
		@RequestParam(value = "orderBy", defaultValue = "nome")  String orderBy, 
		@RequestParam(value = "direction", defaultValue = "ASC")  String direction) {
		
		Page<Cliente> cliente = service.findPage(page, linesPerPage, orderBy, direction);
		 
		 //usando o DTO 
		Page<ClienteDTO> clienteDTO = cliente.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(clienteDTO);
	}
	
	 
}
