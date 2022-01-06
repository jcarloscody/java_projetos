package com.conquistandoavaga.winner;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.conquistandoavaga.winner.domain.Categoria;
import com.conquistandoavaga.winner.repositories.CategoriaRepository;

@SpringBootApplication
public class WinnerApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository repositorie;
	
	public static void main(String[] args) {
		SpringApplication.run(WinnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "materiais escolares");
		Categoria cat2 = new Categoria(null, "escritorio");
		repositorie.saveAll(Arrays.asList(cat1, cat2));
	}

}
