package Lista07.q2;

import java.util.HashMap;
import java.util.Map;

public class ArmazenamentoNuvem implements Armazenamento {

    private Map<String, byte[]> storage = new HashMap<>(); //cria um "banco de dados" simples em memória

    @Override
    public void gravar(String caminho, byte[] dados) {
        storage.put(caminho, dados);
    }

    @Override
    public byte[] ler(String caminho) {
        return storage.get(caminho);
    }
}
