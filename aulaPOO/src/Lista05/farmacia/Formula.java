package Lista05.farmacia;

import java.util.ArrayList;
import java.util.List;

public class Formula {
    String nome;
    List<ItemFormula> itens;

    public Formula(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarIngrediente(Ingrediente ing, double quantidade) {
        itens.add(new ItemFormula(ing, quantidade, null));
    }

    public void adicionarIngrediente(Ingrediente ing, double quantidade, String observacao) {
        itens.add(new ItemFormula(ing, quantidade, observacao));
    }

    public double calcularCusto() {
        double total = 0;
        for (ItemFormula item : itens) {
            total += item.ingrediente.custoUnitario * item.quantidade;
        }
        return total;
    }

    public double calcularCusto(double margemLucro) {
        double total = calcularCusto();
        return total + (total * margemLucro);
    }

    public double calcularCusto(double margemLucro, double desconto) {
        double total = calcularCusto(margemLucro);
        return total - desconto;
    }

    public String gerarReceituario() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fórmula: ").append(nome).append("\n");

        for (ItemFormula item : itens) {
            sb.append("- ")
                    .append(item.ingrediente.nome)
                    .append(": ")
                    .append(item.quantidade)
                    .append(" ")
                    .append(item.ingrediente.unidade);

            if (item.observacao != null) {
                sb.append(" (").append(item.observacao).append(")");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}