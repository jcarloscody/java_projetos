package no.services;

import no.database.ConnectionFactory;
import no.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServices {

    public static ResultSet autenticationLogin(User user)  {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.connect();

        String sql = "select * from user where username = ? and senha = ?";

        try {
            PreparedStatement pstm = connectionFactory.getConnection().prepareStatement(sql);
            pstm.setString(1,user.getUserName());
            pstm.setString(2,user.getPassword());

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
