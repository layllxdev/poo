package Lista04.src.lista04.impressao;

import java.util.ArrayList;
import java.util.List;

public class FilaDeImpressao {

    private String nome;
    private List<Documento> fila;

    public FilaDeImpressao(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.nome = nome;
        this.fila = new ArrayList<>();
    }

    public void adicionar(Documento d) {
        if (d == null) {
            throw new IllegalArgumentException();
        }

        if (d.getPrioridade().equals("URGENTE")) {
            int i = 0;

            while (i < fila.size() && fila.get(i).getPrioridade().equals("URGENTE")) {
                i++;
            }

            fila.add(i, d);
        } else {
            fila.add(d);
        }
    }

    public void cancelar(String nome) {
        for (int i = 0; i < fila.size(); i++) {
            Documento d = fila.get(i);

            if (d.getNome().equals(nome) && d.getStatus().equals("AGUARDANDO")) {
                fila.remove(i);
                return;
            }
        }
    }

    public void imprimirProximo() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }

        Documento d = fila.get(0);

        d.iniciarImpressao();
        d.concluir();

        System.out.println(d.getNome() + " " + d.getNumeroPaginas());

        fila.remove(0);
    }

    public void exibirFila() {
        for (Documento d : fila) {
            System.out.println(d.getNome() + " " + d.getPrioridade() + " " + d.getStatus());
        }
    }

    public int totalPaginasNaFila() {
        return fila.size();
    }
}