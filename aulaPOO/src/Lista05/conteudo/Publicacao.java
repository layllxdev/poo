package Lista05.conteudo;

public class Publicacao {
    private Criador criador;
    private Midia midia;
    private int curtidas;
    private int comentarios;
    private int compartilhamentos;

    public Publicacao(Criador criador, Midia midia, int curtidas, int comentarios, int compartilhamentos) {
        this.criador = criador;
        this.midia = midia;
        this.curtidas = curtidas;
        this.comentarios = comentarios;
        this.compartilhamentos = compartilhamentos;
    }

    public double taxaEngajamento() {
        return (curtidas + comentarios + compartilhamentos) / (double) criador.getSeguidores() * 100;
    }

    public double taxaEngajamento(int visualizacoes) {
        return (curtidas + comentarios + compartilhamentos) / (double) visualizacoes * 100;
    }

    public boolean ehViral() {
        double taxa = taxaEngajamento();
        if (taxa >= 10.0) return true;
        if (criador.isVerificado() && taxa >= 5.0) return true;
        return false;
    }

    public String resumo() {
        return resumo("pt");
    }

    public String resumo(String idioma) {
        StringBuilder sb = new StringBuilder();

        boolean en = idioma.equalsIgnoreCase("en");

        String likes = en ? "Likes" : "Curtidas";
        String comments = en ? "Comments" : "Comentários";
        String shares = en ? "Shares" : "Compartilhamentos";
        String engagement = en ? "Engagement Rate" : "Taxa de Engajamento";

        sb.append(criador.perfil()).append("\n");
        sb.append(midia.descricao()).append("\n");
        sb.append(likes).append(": ").append(curtidas).append("\n");
        sb.append(comments).append(": ").append(comentarios).append("\n");
        sb.append(shares).append(": ").append(compartilhamentos).append("\n");
        sb.append(engagement).append(": ")
                .append(String.format("%.3f", taxaEngajamento()))
                .append("%");

        return sb.toString();
    }
}