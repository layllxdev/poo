package Lista04.src.lista04.podcast;

public class Episodio {

    private String titulo;
    private int numero;
    private int duracaoMinutos;
    private String status;

    public Episodio(String titulo, int numero, int duracaoMinutos) {

        if (titulo == null || titulo.trim().equals("")) {
            throw new IllegalArgumentException("Título inválido");
        }

        if (numero <= 0) {
            throw new IllegalArgumentException("Número inválido");
        }

        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("Duração inválida");
        }

        this.titulo = titulo;
        this.numero = numero;
        this.duracaoMinutos = duracaoMinutos;
        this.status = "RASCUNHO";
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumero() {
        return numero;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public String getStatus() {
        return status;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("Duração inválida");
        }
        this.duracaoMinutos = duracaoMinutos;
    }

    public void publicar() {
        if (status.equals("RASCUNHO")) {
            status = "PUBLICADO";
        }
    }

    public void arquivar() {
        if (status.equals("PUBLICADO")) {
            status = "ARQUIVADO";
        }
    }

    public void restaurar() {
        if (status.equals("ARQUIVADO")) {
            status = "RASCUNHO";
        }
    }
}
