package Lista05.conteudo;

public class Criador {
    private String nomeUsuario;
    private int seguidores;
    private boolean verificado;

    public Criador(String nomeUsuario, int seguidores, boolean verificado) {
        this.nomeUsuario = nomeUsuario;
        this.seguidores = seguidores;
        this.verificado = verificado;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public String perfil() {
        String s = "@" + nomeUsuario + " (" + seguidores + " seguidores)";
        if (verificado) {
            s += " ✓";
        }
        return s;
    }
}