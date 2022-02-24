package com.github.jcarloscody;


import com.github.jcarloscody.domain.entity.Cliente;
import com.github.jcarloscody.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            clientes.salvar(new Cliente("josue"));
            clientes.salvar(new Cliente("marcos"));
            clientes.salvar(new Cliente("silveira"));

            clientes.buscarNome("os").forEach(System.out::println);

            System.out.println("DELETANDO TODOS");

            clientes.obterTodos().forEach(c -> {
                clientes.deletar(c);
            });
            System.out.println("RESULTADO APOS DELECAO");
            clientes.obterTodos().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }


}
