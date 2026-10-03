package AtividadesEmAula.exercicio1Slide;

public class PagamentoBoleto extends Pagamento {
    @Override
    public void processar() {
        imprimirBoleto();
    }

    private void imprimirBoleto() {
        System.out.println("Imprimindo boleto...");
    }
}