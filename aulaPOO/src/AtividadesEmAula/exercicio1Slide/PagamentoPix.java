package AtividadesEmAula.exercicio1Slide;

public class PagamentoPix extends Pagamento {
    @Override
    public void processar() {
        enviarPix();
    }

    private void enviarPix() {
        System.out.println("Enviando PIX...");
    }
}