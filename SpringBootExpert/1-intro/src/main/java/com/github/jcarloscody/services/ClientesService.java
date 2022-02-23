package com.github.jcarloscody.services;

import com.github.jcarloscody.model.Cliente;
import com.github.jcarloscody.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired  //outra forma de injecao de dependencia.
    private ClientesRepository clientesRepository2;

    private ClientesRepository clientesRepository;

    @Autowired //injeção de dependencia via construtor.  se for pelo construtor pode omitir essa anotacao
    public ClientesService(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    public void salvarCliente(Cliente cliente){
        this.clientesRepository.persistir(cliente);
    }

    @Autowired
    //injeção de dependencia via metodo set
    public void setClientesRepository(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }
}
