package Lista04.src.lista04.impressao;

public class Documento {

    private String nome;
    private int numeroPaginas;
    private String prioridade;
    private String status;

    public Documento(String nome, int numeroPaginas, String prioridade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException();
        }

        if (prioridade == null ||
                (!prioridade.equals("NORMAL") && !prioridade.equals("URGENTE"))) {
            throw new IllegalArgumentException();
        }

        this.nome = nome;
        this.numeroPaginas = numeroPaginas;
        this.prioridade = prioridade;
        this.status = "AGUARDANDO";
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void iniciarImpressao() {
        if (status.equals("AGUARDANDO")) {
            status = "IMPRIMINDO";
        }
    }

    public void concluir() {
        if (status.equals("IMPRIMINDO")) {
            status = "CONCLUIDO";
        }
    }
}