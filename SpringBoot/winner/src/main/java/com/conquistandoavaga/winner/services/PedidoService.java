package com.conquistandoavaga.winner.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conquistandoavaga.winner.domain.Pedido;
import com.conquistandoavaga.winner.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	public Pedido buscar(Integer id) {
		//Optional<Pedido> obj = repository.findById(id);
		//return obj.orElse(null); 
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName(), null));
	}
}
