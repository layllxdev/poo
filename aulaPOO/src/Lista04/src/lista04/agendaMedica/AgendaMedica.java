package Lista04.src.lista04.agendaMedica;

import java.util.ArrayList;
import java.util.List;

public class AgendaMedica {

    private List<Consulta> consultas = new ArrayList<>();

    public void agendar(Consulta c) {

        if (c == null)
            throw new IllegalArgumentException();

        consultas.add(c);
    }

    public Consulta buscarPorId(int id) {

        for (Consulta c : consultas) {
            if (c.getId() == id)
                return c;
        }

        return null;
    }

    public List<Consulta> listarPorMedico(String nomeMedico) {

        List<Consulta> lista = new ArrayList<>();

        for (Consulta c : consultas) {
            if (c.getNomeMedico().equals(nomeMedico)) {
                lista.add(c);
            }
        }

        return lista;
    }

    public List<Consulta> listarAtivas() {

        List<Consulta> lista = new ArrayList<>();

        for (Consulta c : consultas) {
            if (c.getStatus().equals("AGENDADA") || c.getStatus().equals("CONFIRMADA")) {
                lista.add(c);
            }
        }

        return lista;
    }
}