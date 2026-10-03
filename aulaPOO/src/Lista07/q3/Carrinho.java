package Lista07.q3;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Item> itens = new ArrayList<>();
    private double frete;

    public Carrinho(double frete) {
        this.frete = frete;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getFrete() {
        return frete;
    }

    public double getSubtotal() {
        double total = 0;
        for (Item i : itens) {
            total += i.getTotal();
        }
        return total;
    }

    public int getTotalQuantidade() {
        int total = 0;
        for (Item i : itens) {
            total += i.getQuantidade();
        }
        return total;
    }
}
