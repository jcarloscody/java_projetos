package com.conquistandoavaga.winner.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conquistandoavaga.winner.domain.Endereco;
import com.conquistandoavaga.winner.services.EnderecoService;

@RestController
@RequestMapping(value = "/address")
public class EnderecoResource {
	
	@Autowired
	EnderecoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Endereco Endereco = service.buscar(id);
		return ResponseEntity.ok().body(Endereco);
	}
	
	 
}
