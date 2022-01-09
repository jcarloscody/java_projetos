package com.conquistandoavaga.winner.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquistandoavaga.winner.domain.Produto;
import com.conquistandoavaga.winner.dto.ProdutoDTO;
import com.conquistandoavaga.winner.resources.utils.URL;
import com.conquistandoavaga.winner.services.ProdutoService;

@RestController
@RequestMapping(value = "/products")
public class ProdutoResource {
	
	@Autowired
	ProdutoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Produto produto = service.buscar(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
		@RequestParam(value = "nome", defaultValue = "") String nome,
		@RequestParam(value = "categorias", defaultValue = "") String categorias,
		@RequestParam(value = "page", defaultValue = "0") Integer page, 
		@RequestParam(value = "linesPerPage", defaultValue = "2")  Integer linesPerPage, 
		@RequestParam(value = "orderBy", defaultValue = "nome")  String orderBy, 
		@RequestParam(value = "direction", defaultValue = "ASC")  String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> list = service.search(nomeDecoded,ids,page, linesPerPage, orderBy, direction);
		 
		 //usando o DTO 
		Page<ProdutoDTO> produtoDTO = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(produtoDTO);
	}
}
