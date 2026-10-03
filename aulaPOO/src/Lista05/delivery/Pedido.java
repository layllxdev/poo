package Lista05.delivery;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    String nomeCliente;
    Restaurante restaurante;
    double distanciaKm;
    List<ItemPedido> itens;

    public Pedido(String nomeCliente, Restaurante restaurante, double distanciaKm) {
        this.nomeCliente = nomeCliente;
        this.restaurante = restaurante;
        this.distanciaKm = distanciaKm;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void adicionarItem(String nomePrato, double preco, int quantidade) {
        itens.add(new ItemPedido(nomePrato, preco, quantidade));
    }

    public double calcularSubtotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.preco * item.quantidade;
        }
        return total;
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        double taxa = 2.0 + (1.5 * distanciaKm);
        return subtotal + taxa;
    }

    public double calcularTotal(String tipoEntrega) {
        double subtotal = calcularSubtotal();

        if (tipoEntrega.equals("retirada")) {
            return subtotal;
        }

        double taxa = 2.0 + (1.5 * distanciaKm);

        if (tipoEntrega.equals("expressa")) {
            taxa *= 2;
        }

        return subtotal + taxa;
    }

    public double calcularTotal(String tipoEntrega, double cupomDesconto) {
        double total = calcularTotal(tipoEntrega);
        total -= cupomDesconto;

        if (total < 0) {
            return 0;
        }

        return total;
    }

    public String resumoPedido() {
        StringBuilder sb = new StringBuilder();

        sb.append("Cliente: ").append(nomeCliente).append("\n");
        sb.append("Restaurante: ").append(restaurante.info()).append("\n");
        sb.append("Itens:\n");

        for (ItemPedido item : itens) {
            sb.append("- ").append(item.linha()).append("\n");
        }

        return sb.toString();
    }
}