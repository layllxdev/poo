package Lista05.farmacia;

public class ItemFormula {
    public Ingrediente ingrediente;
    public double quantidade;
    public String observacao;

    public ItemFormula(Ingrediente ingrediente, double quantidade, String observacao) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }
}
