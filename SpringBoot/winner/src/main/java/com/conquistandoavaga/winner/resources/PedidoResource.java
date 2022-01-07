package com.conquistandoavaga.winner.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conquistandoavaga.winner.domain.Pedido;
import com.conquistandoavaga.winner.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {
	
	@Autowired
	PedidoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido categoria = service.buscar(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	 
}
