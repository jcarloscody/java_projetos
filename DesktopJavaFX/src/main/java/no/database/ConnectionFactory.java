package no.database;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private String user;
    private String password;
    private String path;

    private Connection con;

    public ConnectionFactory() {
        path = "jdbc:mysql://localhost:3306/trocaoleo";
        user = "root";
        password = "1234";
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(path, user, password);
            System.out.println("Connection OK");
        }catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Connection BAD");
        }
    }

    public void disconnect() {
        try {
            con.close();
            System.out.println("Connection closed");
        }catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("BAD closed");
        }
    }

    public Connection getConnection() {
        return con;
    }
}
