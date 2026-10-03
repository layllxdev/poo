package Lista04.src.lista04.laboratorio;

import java.util.ArrayList;
import java.util.List;

public class EstoqueLaboratorio {

    private List<ItemLaboratorio> itens = new ArrayList<>();

    public void cadastrar(ItemLaboratorio item) {

        if (item == null)
            throw new IllegalArgumentException();

        itens.add(item);
    }

    public ItemLaboratorio buscarPorCodigo(String codigo) {

        for (ItemLaboratorio i : itens) {
            if (i.getCodigo().equals(codigo)) {
                return i;
            }
        }

        return null;
    }

    public List<ItemLaboratorio> listarEmAlerta() {

        List<ItemLaboratorio> copia = new ArrayList<>();

        for (ItemLaboratorio i : itens) {
            if (i.getStatus().equals("ALERTA") || i.getStatus().equals("ESGOTADO")) {
                copia.add(i);
            }
        }

        return copia;
    }
}