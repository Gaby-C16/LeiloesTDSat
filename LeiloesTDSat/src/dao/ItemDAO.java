package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import leiloestdsat.Item;
import dao.conectaDAO;

public class ItemDAO {
    public boolean salvar(Item item) {
        String sql = "INSERT INTO itens (nome, descricao, valor) VALUES (?, ?, ?)";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setDouble(3, item.getValor());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar item: " + e.getMessage());
            return false;
        }
    }
}