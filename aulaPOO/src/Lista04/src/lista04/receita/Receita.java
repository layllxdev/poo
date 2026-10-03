package Lista04.src.lista04.receita;

import java.util.ArrayList;
import java.util.List;

public class Receita {

    private String nome;
    private int tempoPreparo;
    private int rendimentoPorcoes;
    private List<String> ingredientes;

    public Receita(String nome, int tempoPreparo, int rendimentoPorcoes) {

        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (tempoPreparo <= 0) {
            throw new IllegalArgumentException("Tempo inválido");
        }

        if (rendimentoPorcoes <= 0) {
            throw new IllegalArgumentException("Rendimento inválido");
        }

        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.rendimentoPorcoes = rendimentoPorcoes;
        this.ingredientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public int getRendimentoPorcoes() {
        return rendimentoPorcoes;
    }

    public void setTempoPreparo(int tempoPreparo) {
        if (tempoPreparo <= 0) {
            throw new IllegalArgumentException("Tempo inválido");
        }
        this.tempoPreparo = tempoPreparo;
    }

    public void setRendimentoPorcoes(int rendimentoPorcoes) {
        if (rendimentoPorcoes <= 0) {
            throw new IllegalArgumentException("Rendimento inválido");
        }
        this.rendimentoPorcoes = rendimentoPorcoes;
    }

    public List<String> getIngredientes() {
        return new ArrayList<>(ingredientes);
    }

    public void adicionarIngrediente(String ingrediente) {
        if (ingrediente == null || ingrediente.trim().equals("")) {
            return;
        }
        ingredientes.add(ingrediente);
    }

    public void removerIngrediente(String ingrediente) {
        ingredientes.remove(ingrediente);
    }
}