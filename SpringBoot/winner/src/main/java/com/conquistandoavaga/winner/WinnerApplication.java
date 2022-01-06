package com.conquistandoavaga.winner;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.conquistandoavaga.winner.domain.Categoria;
import com.conquistandoavaga.winner.domain.Produto;
import com.conquistandoavaga.winner.repositories.CategoriaRepository;
import com.conquistandoavaga.winner.repositories.ProdutoRepository;

@SpringBootApplication
public class WinnerApplication implements CommandLineRunner{
	
	@Autowired
	 private CategoriaRepository categoriaRepository;
	
	@Autowired
	 private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WinnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "materiais escolares");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null, "cp", 2000.00);
		Produto p2 = new Produto(null, "caderno", 15.25);
		Produto p3 = new Produto(null, "lapis", 56.56);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
