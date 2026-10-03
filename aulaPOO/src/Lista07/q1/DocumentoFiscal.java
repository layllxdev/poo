package Lista07.q1;

public abstract class DocumentoFiscal {

    protected double valor;
    protected String identificador;

    public DocumentoFiscal(double valor, String identificador) {
        this.valor = valor;
        this.identificador = identificador;
    }

    public abstract double calcularImposto();
    public abstract String gerarXML();
}
