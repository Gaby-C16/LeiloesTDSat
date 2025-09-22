package dto;

public class ProdutosDTO {
    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private String status; // <-- esse campo estava faltando

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {   // <-- getter criado
        return status;
    }
    public void setStatus(String status) {  // <-- setter criado
        this.status = status;
    }
}