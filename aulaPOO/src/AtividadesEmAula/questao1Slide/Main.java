package AtividadesEmAula.questao1Slide;

import java.util.ArrayList;
import java.util.List;

class Agendamento {
    protected String cliente;
    protected String servico;
    protected double precoBase;

    public Agendamento(String cliente, String servico, double precoBase) {
        this.cliente = cliente;
        this.servico = servico;
        this.precoBase = precoBase;
    }

    public double calcularCusto() {
        return precoBase;
    }

    public String getCliente() {
        return cliente;
    }
}

class AgendamentoUrgente extends Agendamento {
    private double taxaUrgencia;

    public AgendamentoUrgente(String cliente, String servico, double precoBase, double taxaUrgencia) {
        super(cliente, servico, precoBase);
        this.taxaUrgencia = taxaUrgencia;
    }

    @Override
    public double calcularCusto() {
        return precoBase + taxaUrgencia;
    }
}

class AgendamentoRetorno extends Agendamento {
    public AgendamentoRetorno(String cliente, String servico, double precoBase) {
        super(cliente, servico, precoBase);
    }

    @Override
    public double calcularCusto() {
        return precoBase * 0.85;
    }
}

class Oficina {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public void adicionarAgendamento(Agendamento a) {
        agendamentos.add(a);
    }

    public void gerarRelatorio() {
        for (Agendamento a : agendamentos) {
            System.out.println("Cliente: " + a.getCliente());
            System.out.println("Tipo: " + a.getClass().getSimpleName());
            System.out.println("Custo: R$ " + a.calcularCusto());
            System.out.println("----------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Oficina oficina = new Oficina();

        oficina.adicionarAgendamento(new AgendamentoUrgente("Ruann", "Freio", 300, 80));
        oficina.adicionarAgendamento(new AgendamentoRetorno("Laila", "Alinhamento", 200));

        oficina.gerarRelatorio();
    }
}