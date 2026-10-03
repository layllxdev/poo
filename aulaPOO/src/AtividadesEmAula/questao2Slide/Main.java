package AtividadesEmAula.questao2Slide;

public class Main {

    public static void main(String[] args) {

        Cliente c1 = new Cliente("Laila", "99193-7322");
        Veiculo v1 = new Veiculo("ABC-1234", "Hillux", 2015);
        Servico s1 = new Servico("Troca de óleo", 100);

        Cliente c2 = new Cliente("Ruann", "99381-2154");
        Veiculo v2 = new Veiculo("XYZ-5678", "Civic", 2020);
        Servico s2 = new Servico("Revisão", 300);

        Agendamento a1 = new Agendamento(c1, s1, v1);
        Agendamento a2 = new Agendamento(c2, s2, v2);

        Oficina oficina = new Oficina();
        oficina.adicionarAgendamento(a1);
        oficina.adicionarAgendamento(a2);

        for (Agendamento a : oficina.getAgendamentos()) {
            System.out.println(
                    a.getCliente().getNome() + " | " +
                            a.getVeiculo().getModelo() + " | " +
                            a.getServico().getNome()
            );
        }
    }
}
