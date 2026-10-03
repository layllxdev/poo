package Lista07.q2;

import java.util.HashMap;
import java.util.Map;

public class ArmazenamentoComCache implements Armazenamento {

    private Armazenamento armazenamentoReal;
    private Map<String, byte[]> cache = new HashMap<>(); //guarda dados em memória (cache)

    public ArmazenamentoComCache(Armazenamento armazenamentoReal) {
        this.armazenamentoReal = armazenamentoReal;
    }

    @Override
    public void gravar(String caminho, byte[] dados) {
        armazenamentoReal.gravar(caminho, dados); //vai gravar na nuvem
        cache.put(caminho, dados); //salva na nuvem
        //evitando o erro do código original
    }

    @Override
    public byte[] ler(String caminho) {
        if (cache.containsKey(caminho)) {
            return cache.get(caminho); //verifica se já está no cache, se tiver, já retorna rápido
        }

        byte[] dados = armazenamentoReal.ler(caminho); //se não tiver no cache, ele busca na nuvem
        if (dados != null) { //se encontrou na nuvem
            return cache.put(caminho, dados); //salva no cache para uma próxima vez
        }

        return dados;
    }
}
