package AtividadesEmAula.questao2Slide;

public class Agendamento {

    private Cliente cliente;
    private Servico servico;
    private Veiculo veiculo;

    public Agendamento(Cliente cliente, Servico servico, Veiculo veiculo) {
        this.cliente = cliente;
        this.servico = servico;
        this.veiculo = veiculo;
    }

    public double calcularCusto() {return servico.getPreco();}

    public Cliente getCliente() { return cliente; }
    public Servico getServico() { return servico; }
    public Veiculo getVeiculo() { return veiculo; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setServico(Servico servico) { this.servico = servico; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
}