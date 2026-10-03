package Lista04.src.lista04.musica;

public class Musica {

    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String prioridade;

    public Musica(String titulo, String artista, int duracaoSegundos, String prioridade) {

        if (titulo == null || titulo.trim().equals(""))
            throw new IllegalArgumentException("Título inválido");

        if (artista == null || artista.trim().equals(""))
            throw new IllegalArgumentException("Artista inválido");

        if (duracaoSegundos <= 0)
            throw new IllegalArgumentException("Duração inválida");

        if (prioridade == null || (!prioridade.equals("NORMAL") && !prioridade.equals("URGENTE")))
            throw new IllegalArgumentException("Prioridade inválida");

        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {

        if (prioridade == null || (!prioridade.equals("NORMAL") && !prioridade.equals("URGENTE")))
            throw new IllegalArgumentException("Prioridade inválida");

        this.prioridade = prioridade;
    }
}