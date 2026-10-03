package Lista07.q2;

public interface Armazenamento {

    void gravar(String caminho, byte[] dados);

    byte[] ler(String caminho);
}

//diz o que deve ser feito, não como deve ser feito