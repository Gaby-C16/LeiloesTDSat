package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class conectaDAO {
    public Connection connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/leiloes_db?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "16082006";

        return DriverManager.getConnection(url, user, password);
    }
}
