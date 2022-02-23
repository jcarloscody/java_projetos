package com.conquistandoavaga.winner.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conquistandoavaga.winner.domain.Estado;
import com.conquistandoavaga.winner.services.EstadoService;

@RestController
@RequestMapping(value = "/stats")
public class EstadoResource {
	
	@Autowired
	EstadoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Estado Estado = service.buscar(id);
		return ResponseEntity.ok().body(Estado);
	}
	
	 
}
