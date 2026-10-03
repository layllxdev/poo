package Lista07.q3;

public class DescontoValorMinimo implements RegraDesconto {

    @Override
    public boolean aplicar(Carrinho carrinho) {
        return carrinho.getSubtotal() > 300;
    }

    @Override
    public double calcularDesconto(Carrinho carrinho) {
        return carrinho.getSubtotal() * 0.10;
    }

    @Override
    public String getDescricao() {
        return "10% de desconto para compras acima de R$300";
    }
}