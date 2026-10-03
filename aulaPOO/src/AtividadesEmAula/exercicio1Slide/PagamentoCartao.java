package AtividadesEmAula.exercicio1Slide;

public class PagamentoCartao extends Pagamento {
    @Override
    public void processar() {
        cobrarCartao();
    }

    private void cobrarCartao() {
        System.out.println("Cobrando no cartão...");
    }
}