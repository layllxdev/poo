package Lista07.q3;

import java.util.List;

public class MainQ3 {

    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho(50);

        carrinho.adicionarItem(new Item("Camisa", 100, 2));
        carrinho.adicionarItem(new Item("Calça", 150, 1));
        carrinho.adicionarItem(new Item("Meia", 20, 3));
        carrinho.adicionarItem(new Item("Boné", 50, 1));

        List<RegraDesconto> regras = List.of(
                new DescontoValorMinimo(),
                new DescontoSegundaUnidade(),
                new FreteGratis()
        );

        MotorDescontos motor = new MotorDescontos();

        RegraDesconto melhor = motor.calcularMelhorRegra(carrinho, regras);

        if (melhor != null) {
            double valor = melhor.calcularDesconto(carrinho);
            System.out.println("Regra aplicada: " + melhor.getDescricao());
            System.out.println("Desconto: R$ " + valor);
        } else {
            System.out.println("Nenhuma regra aplicada");
        }
    }
}