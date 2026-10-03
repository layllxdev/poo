package Lista07.q3;

public interface RegraDesconto {

    boolean aplicar(Carrinho carrinho);

    double calcularDesconto(Carrinho carrinho);

    String getDescricao();
}