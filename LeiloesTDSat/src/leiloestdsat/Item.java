package leiloestdsat;

public class Item {
    private String nome;
    private String descricao;
    private double valor;

    public Item(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
}
