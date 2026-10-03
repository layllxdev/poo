package Lista04.src.lista04.laboratorio;

public class ItemLaboratorio {

    private String codigo;
    private String nome;
    private int quantidadeDisponivel;
    private int quantidadeMinima;
    private String status;

    public ItemLaboratorio(String codigo, String nome, int quantidadeDisponivel, int quantidadeMinima) {

        if (codigo == null || codigo.trim().equals(""))
            throw new IllegalArgumentException("Código inválido");

        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Nome inválido");

        if (quantidadeDisponivel < 0)
            throw new IllegalArgumentException("Quantidade inválida");

        if (quantidadeMinima <= 0)
            throw new IllegalArgumentException("Quantidade mínima inválida");

        this.codigo = codigo;
        this.nome = nome;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeMinima = quantidadeMinima;

        atualizarStatus();
    }

    private void atualizarStatus() {

        if (quantidadeDisponivel == 0) {
            status = "ESGOTADO";
        } else if (quantidadeDisponivel <= quantidadeMinima) {
            status = "ALERTA";
        } else {
            status = "NORMAL";
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public String getStatus() {
        return status;
    }

    public void entrada(int quantidade) {

        if (quantidade <= 0)
            throw new IllegalArgumentException("Quantidade inválida");

        quantidadeDisponivel += quantidade;
        atualizarStatus();
    }

    public void saida(int quantidade) {

        if (quantidade <= 0)
            throw new IllegalArgumentException("Quantidade inválida");

        if (quantidadeDisponivel - quantidade < 0)
            return;

        quantidadeDisponivel -= quantidade;
        atualizarStatus();
    }
}