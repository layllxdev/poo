package Lista05.delivery;

public class ItemPedido {
    String nomePrato;
    double preco;
    int quantidade;

    public ItemPedido(String nomePrato, double preco, int quantidade) {
        this.nomePrato = nomePrato;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String linha() {
        return quantidade + "x " + nomePrato + " — R$" + preco;
    }
}