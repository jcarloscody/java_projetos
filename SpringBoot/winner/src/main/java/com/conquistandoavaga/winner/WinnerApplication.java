package com.conquistandoavaga.winner;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.conquistandoavaga.winner.domain.Categoria;
import com.conquistandoavaga.winner.domain.Cidade;
import com.conquistandoavaga.winner.domain.Estado;
import com.conquistandoavaga.winner.domain.Produto;
import com.conquistandoavaga.winner.repositories.CategoriaRepository;
import com.conquistandoavaga.winner.repositories.CidadeRepository;
import com.conquistandoavaga.winner.repositories.EstadoRepository;
import com.conquistandoavaga.winner.repositories.ProdutoRepository;

@SpringBootApplication
public class WinnerApplication implements CommandLineRunner{
	
	@Autowired
	 private CategoriaRepository categoriaRepository;
	
	@Autowired
	 private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
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
		
		Estado estado1 = new Estado(null, "minas gerais");
		Estado estado2 = new Estado (null, "sp");
		
		Cidade cidade1 = new Cidade(null, "uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "sao paulo", estado2);
		Cidade cidade3 = new Cidade(null, "campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
	}

}
