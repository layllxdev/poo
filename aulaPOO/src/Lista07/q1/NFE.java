package Lista07.q1;

public class NFE extends DocumentoFiscal {

    public NFE(double valor, String identificador) {
        super(valor, identificador);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.18;
    }

    @Override
    public String gerarXML() {
    return "<nfe>" + identificador + "<n/fe>";
    }
}