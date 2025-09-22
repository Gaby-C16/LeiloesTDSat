package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import dto.ProdutosDTO;

public class ProdutosDAO {

    // Cadastrar Produto
    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO itens (nome, descricao, valor) VALUES (?, ?, ?)";

        try (Connection conn = new conectaDAO().connectDB();
     PreparedStatement stmt = conn.prepareStatement(sql)) {

    stmt.setString(1, produto.getNome());
    stmt.setString(2, produto.getDescricao());
    stmt.setDouble(3, produto.getValor());

    stmt.executeUpdate();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
        }
    }

    // Listar Produtos
public ArrayList<ProdutosDTO> listarProdutos() {
    String sql = "SELECT id, nome, descricao, valor FROM itens";
    ArrayList<ProdutosDTO> lista = new ArrayList<>();

    try (Connection conn = new conectaDAO().connectDB();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValor(rs.getDouble("valor"));

            lista.add(produto);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
    }

    return lista;
}
}