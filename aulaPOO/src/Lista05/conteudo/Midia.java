package Lista05.conteudo;

public class Midia {
    private String tipo;
    private int duracaoSegundos;
    private String resolucao;

    public Midia(String tipo, int duracaoSegundos, String resolucao) {
        this.tipo = tipo;
        this.duracaoSegundos = duracaoSegundos;
        this.resolucao = resolucao;
    }

    public String descricao() {
        if (tipo.equalsIgnoreCase("video")) {
            return "Vídeo " + resolucao + " | " + duracaoSegundos + "s";
        } else if (tipo.equalsIgnoreCase("imagem")) {
            return "Imagem " + resolucao;
        } else if (tipo.equalsIgnoreCase("audio")) {
            return "Áudio | " + duracaoSegundos + "s";
        }
        return "";
    }
}