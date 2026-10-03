package Lista04.src.lista04.musica;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String nome;
    private List<Musica> fila;

    public Playlist(String nome) {

        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Nome inválido");

        this.nome = nome;
        fila = new ArrayList<>();
    }

    public void adicionar(Musica m) {

        if (m == null)
            throw new IllegalArgumentException("Música nula");

        if (m.getPrioridade().equals("URGENTE")) {

            int i = 0;

            while (i < fila.size() && fila.get(i).getPrioridade().equals("URGENTE")) {
                i++;
            }

            fila.add(i, m);
        } else {
            fila.add(m);
        }
    }

    public void remover(String titulo) {

        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).getTitulo().equals(titulo)) {
                fila.remove(i);
                return;
            }
        }
    }

    public Musica proximaMusica() {

        if (fila.isEmpty())
            return null;

        return fila.get(0);
    }

    public Musica reproduzirProxima() {

        if (fila.isEmpty())
            return null;

        return fila.remove(0);
    }

    public int tamanho() {
        return fila.size();
    }

    public void listar() {

        for (Musica m : fila) {
            System.out.println(m.getTitulo() + " - " + m.getArtista() + " (" + m.getPrioridade() + ")");
        }
    }
}
