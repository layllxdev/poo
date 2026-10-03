package Lista07.q1;

public class ProcessadorFiscal {

    public String processar(DocumentoFiscal documento) {
        double imposto = documento.calcularImposto();
        String xml = documento.gerarXML();

        return xml + "|imposto:" + String.format("%.2f", imposto);
    }
}
