package Lista07.q3;

import java.util.List;

public class MotorDescontos {

    public RegraDesconto calcularMelhorRegra(Carrinho carrinho,
                                             List<RegraDesconto> regras) {

        RegraDesconto melhorRegra = null;
        double maiorDesconto = 0;

        for (RegraDesconto regra : regras) {

            if (regra.aplicar(carrinho)) {

                double desconto = regra.calcularDesconto(carrinho);

                if (desconto > maiorDesconto) {
                    maiorDesconto = desconto;
                    melhorRegra = regra;
                }
            }
        }

        return melhorRegra;
    }
}
