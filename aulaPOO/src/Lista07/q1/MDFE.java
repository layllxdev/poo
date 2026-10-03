package Lista07.q1;

public class MDFE extends DocumentoFiscal {

    public MDFE(double valor, String identificador){
        super(valor, identificador);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.08;
    }

    @Override
    public String gerarXML() {
        return "<mdfe>" + identificador + "</mdfe>";
    }
}
