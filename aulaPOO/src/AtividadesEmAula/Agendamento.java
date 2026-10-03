package AtividadesEmAula;

public class Agendamento {

    String nomeCliente;
    String servico;
    String data;

    public Agendamento() {
        this(null, null, null);
    }

    public Agendamento(String nomeCliente) {
        this(nomeCliente, null, null);
    }

    public Agendamento(String nomeCliente, String servico, String data) {
        this.nomeCliente = nomeCliente;
        this.servico = servico;
        this.data = data;
    }

    public String toString() {
        return nomeCliente + " - " + servico + " - " + data;
    }

    public static void main(String[] args) {

        Agendamento a1 = new Agendamento();
        Agendamento a2 = new Agendamento("Laila");
        Agendamento a3 = new Agendamento("Ruann", "Troca de óleo da moto, pop 120", "25/03/2026");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}