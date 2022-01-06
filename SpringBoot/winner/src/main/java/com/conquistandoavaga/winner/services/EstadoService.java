package com.conquistandoavaga.winner.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.conquistandoavaga.winner.domain.Estado;
import com.conquistandoavaga.winner.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository repository;
	
	public Estado buscar(Integer id) {
		//Optional<Categoria> obj = repository.findById(id);
		//return obj.orElse(null); 
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName(), null));
	}
}
