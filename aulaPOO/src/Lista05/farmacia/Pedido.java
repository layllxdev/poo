package Lista05.farmacia;

public class Pedido {
    String nomePaciente;
    String dataEntrega;
    Formula formula;

    public Pedido(String nomePaciente, String dataEntrega, Formula formula) {
        this.nomePaciente = nomePaciente;
        this.dataEntrega = dataEntrega;
        this.formula = formula;
    }

    public String resumo() {
        return "Paciente: " + nomePaciente + "\n" +
                "Entrega: " + dataEntrega + "\n" +
                formula.gerarReceituario();
    }
}
