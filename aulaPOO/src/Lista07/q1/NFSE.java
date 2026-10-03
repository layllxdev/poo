package Lista07.q1;

public class NFSE extends DocumentoFiscal {

    public NFSE(double valor, String identificador) {
        super(valor, identificador);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.05;
    }

    @Override
    public String gerarXML() {
        return "<nfse>" + identificador + "</nfse>";
    }
}
