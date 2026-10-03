package Lista07.q3;

public class FreteGratis implements RegraDesconto {

    @Override
    public boolean aplicar(Carrinho carrinho) {
        return carrinho.getTotalQuantidade() > 5;
    }

    @Override
    public double calcularDesconto(Carrinho carrinho) {
        return carrinho.getFrete();
    }

    @Override
    public String getDescricao() {
        return "Frete grátis";
    }
}