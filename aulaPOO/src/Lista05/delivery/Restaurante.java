package Lista05.delivery;

public class Restaurante {
    String nome;
    String categoria;
    double notaAvaliacao;

    public Restaurante(String nome, String categoria, double notaAvaliacao) {
        this.nome = nome;
        this.categoria = categoria;
        this.notaAvaliacao = notaAvaliacao;
    }

    public String info() {
        return nome + " | " + categoria + " | ★ " + notaAvaliacao;
    }
}