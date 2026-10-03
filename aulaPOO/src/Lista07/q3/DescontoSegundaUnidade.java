package Lista07.q3;

public class DescontoSegundaUnidade implements RegraDesconto {

    @Override
    public boolean aplicar(Carrinho carrinho) {
        return carrinho.getItens().size() >= 2;
    }

    @Override
    public double calcularDesconto(Carrinho carrinho) {
        double menorPreco = Double.MAX_VALUE;

        for (Item i : carrinho.getItens()) {
            if (i.getPrecoUnitario() < menorPreco) {
                menorPreco = i.getPrecoUnitario();
            }
        }

        return menorPreco * 0.5;
    }

    @Override
    public String getDescricao() {
        return "50% de desconto no item mais barato";
    }
}