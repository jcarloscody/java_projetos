package com.github.jcarloscody.domain.repositorio;

import com.github.jcarloscody.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private  static  String INSERT = "INSERT INTO cliente (nome) VALUES (?)";
    private static String SELECT_ALL = "SELECT * FROM cliente";
    private static String UPDATE = "UPDATE cliente SET nome = ? WHERE id = ?";
    private static String DELETE = "DELETE FROM cliente WHERE id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Cliente salvar(Cliente client){
        jdbcTemplate.update(INSERT, new Object[]{client.getNome()});  //update serve para insert, update delete
        return client;
    }

    //RowMapper vai mapear o resultado do bd para uma classe, no caso Cliente
    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, getRowMapperCliente());
    }

    private RowMapper<Cliente> getRowMapperCliente() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente){
        deletar(cliente.getId());
    }

    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<Cliente> buscarNome(String nome){
        return jdbcTemplate.query(SELECT_ALL.concat(" WHERE nome LIKE ?"), new Object[]{"%" + nome + "%"} ,getRowMapperCliente() );
    }
}
