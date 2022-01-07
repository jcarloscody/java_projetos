package com.conquistandoavaga.winner.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conquistandoavaga.winner.domain.Cliente;
import com.conquistandoavaga.winner.services.ClienteService;

@RestController
@RequestMapping(value = "/client")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente Cliente = service.buscar(id);
		return ResponseEntity.ok().body(Cliente);
	}
	
	 
}
