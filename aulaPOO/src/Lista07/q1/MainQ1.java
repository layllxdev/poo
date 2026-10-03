package Lista07.q1;

public class MainQ1 {

    public static void main(String[] args) {
        ProcessadorFiscal processador = new ProcessadorFiscal();

        DocumentoFiscal doc = new MDFE(1000, "12345");

        String resultado = processador.processar(doc);
        System.out.println(resultado);
    }
}

//O processador esta fazendo coisa demais, correndo o risco de quebrar, sem
//contar que quebra os dois principios,
//o de responsabilidade unica e o de OCP,
//com a ideia de cada documento se processar sozinho, criando uma base com uma
//classe abstrata e cada classe implementa sua própia lógica
//ou seja, trocar decisão por comportamento