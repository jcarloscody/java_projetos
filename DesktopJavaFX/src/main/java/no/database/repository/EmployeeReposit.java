package no.database.repository;

import no.database.ConnectionFactory;
import no.entities.Employee;

import java.lang.constant.Constable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReposit {

    static ConnectionFactory connectionFactory = new ConnectionFactory();

    public static void insertEmployee(Employee e) throws SQLException {
        connectionFactory.connect();
        PreparedStatement statement = connectionFactory.getConnection().prepareStatement(
                "INSERT INTO employee "
                        + "(nome, cpf, salario) "
                        + "VALUES "
                        + "(?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, e.getNome());//tipo string, posicao 1
        statement.setString(2, e.getCpf());
        statement.setDouble(3, e.getSalario());

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("Done! Id: " + id);
            }
        }
        else {
            System.out.println("No rows affected!");
        }

        connectionFactory.disconnect();
    }

    public static void updateEmployee(Employee e) throws SQLException {
         connectionFactory.connect();
        /*Connection connection = connectionFactory.getConnection();
        connection.setAutoCommit(false);

        Statement st = connection.createStatement();

       int rows1 = st.executeUpdate("UPDATE employee SET nome = "+ e.getNome() +" cpf = " + e.getCpf() +
                " salario = " + e.getSalario() + " WHERE id = " + e.getId());*/

        String sql = "UPDATE employee SET nome = ?,cpf = ?, salario = ? WHERE id = ?;";

        PreparedStatement stm = connectionFactory.getConnection().prepareStatement(sql);

        //System.out.println(e.getId());

       // System.out.println(e.getNome());

        stm.setString(1, e.getNome());
        stm.setString(2, e.getCpf());
        stm.setDouble(3, e.getSalario());
        stm.setLong(4, e.getId());

        stm.execute();

        connectionFactory.disconnect();


    }

    public List<Employee> lista(){
        List<Employee> lista = new ArrayList<>();
        try{
            connectionFactory.connect();
            PreparedStatement stm = connectionFactory.getConnection().prepareStatement("select * from employee");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setNome(rs.getString("nome"));
                e.setSalario(rs.getDouble("salario"));
                e.setCpf(rs.getString("cpf"));
                lista.add(e);
            }
            stm.close();
            rs.close();

            connectionFactory.disconnect();
        }catch(SQLException e){
            System.out.println("Erro no relat�rio: "+e.getMessage());
        }
        return lista;
    }



    public void delete(Employee e){
        try{
            connectionFactory.connect();
            PreparedStatement instrucao =
                    connectionFactory.getConnection().prepareStatement("delete from employee where id = ?");
            instrucao.setInt(1, Math.toIntExact(e.getId()));
            instrucao.execute();
            connectionFactory.disconnect();
        }catch(Exception ee){
            System.out.println("Erro na exclus�o: "+ee.getMessage());
        }
    }
}
