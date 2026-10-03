package AtividadesEmAula.questao2Slide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Oficina {

    private List<Agendamento> agendamentos = new ArrayList<>();

    public void adicionarAgendamento(Agendamento a) {
        agendamentos.add(a);
    }

    public List<Agendamento> getAgendamentos() {
        return Collections.unmodifiableList(agendamentos);
    }
}
