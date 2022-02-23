package com.conquistandoavaga.winner.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.conquistandoavaga.winner.domain.Cidade;
import com.conquistandoavaga.winner.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository repository;
	
	public Cidade buscar(Integer id) {
		//Optional<Categoria> obj = repository.findById(id);
		//return obj.orElse(null); 
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName(), null));
	}
}
