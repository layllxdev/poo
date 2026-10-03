package Lista07.q1;

public class CTE extends DocumentoFiscal {

    public CTE(double valor, String identificador) {
        super(valor, identificador);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.12;
    }

    @Override
    public String gerarXML() {
        return "<cte>" + identificador + "</cte>";
    }
}
