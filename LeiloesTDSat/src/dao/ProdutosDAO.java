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
    public void venderProduto(int id) {
        String sql = "UPDATE itens SET status = 'Vendido' WHERE id = ?";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao vender: " + e.getMessage());
        }
    }

    // Listar TODOS os produtos
    public ArrayList<ProdutosDTO> listarProdutos() {
        String sql = "SELECT id, nome, descricao, valor, status FROM itens";
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
                produto.setStatus(rs.getString("status"));

                lista.add(produto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
    

    // Listar apenas produtos VENDIDOS
    public ResultSet listarProdutosVendidos() {
        String sql = "SELECT id, nome, descricao, valor, status FROM itens WHERE status = 'Vendido'";
        try {
            Connection conn = new conectaDAO().connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeQuery(); // retorna ResultSet direto
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendidos: " + e.getMessage());
            return null;
        }
    }
}