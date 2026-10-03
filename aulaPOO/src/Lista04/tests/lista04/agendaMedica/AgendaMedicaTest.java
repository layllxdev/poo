package Lista04.tests.lista04.agendaMedica;

import Lista04.src.lista04.agendaMedica.AgendaMedica;
import Lista04.src.lista04.agendaMedica.Consulta;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AgendaMedicaTest {

    private Consulta consulta;
    private AgendaMedica agenda;

    @Before
    public void setUp() {
        consulta = new Consulta(1, "João Silva", "Dra. Ana", "20/06/2025 09:00", "");
        agenda   = new AgendaMedica();
    }

    // -------------------------------------------------------------------------
    // Construtor — Consulta
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void construtor_idZero_lancaExcecao() {
        new Consulta(0, "Paciente", "Médico", "01/01/2025 08:00", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_idNegativo_lancaExcecao() {
        new Consulta(-1, "Paciente", "Médico", "01/01/2025 08:00", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_nomePacienteNulo_lancaExcecao() {
        new Consulta(1, null, "Médico", "01/01/2025 08:00", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_nomePacienteVazio_lancaExcecao() {
        new Consulta(1, "", "Médico", "01/01/2025 08:00", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_nomeMedicoNulo_lancaExcecao() {
        new Consulta(1, "Paciente", null, "01/01/2025 08:00", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_nomeMedicoVazio_lancaExcecao() {
        new Consulta(1, "Paciente", "", "01/01/2025 08:00", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_dataHoraNula_lancaExcecao() {
        new Consulta(1, "Paciente", "Médico", null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_dataHoraVazia_lancaExcecao() {
        new Consulta(1, "Paciente", "Médico", "", "");
    }

    @Test
    public void construtor_valoresValidos_statusInicialAgendada() {
        assertEquals("AGENDADA", consulta.getStatus());
    }

    // -------------------------------------------------------------------------
    // id — imutabilidade
    // -------------------------------------------------------------------------

    @Test
    public void getId_retornaValorDefinidoNoConstrutor() {
        assertEquals(1, consulta.getId());
    }

    // -------------------------------------------------------------------------
    // confirmar
    // -------------------------------------------------------------------------

    @Test
    public void confirmar_deAgendada_mudaParaConfirmada() {
        consulta.confirmar();
        assertEquals("CONFIRMADA", consulta.getStatus());
    }

    @Test
    public void confirmar_deConfirmada_ignoraEMantemStatus() {
        consulta.confirmar();
        consulta.confirmar();
        assertEquals("CONFIRMADA", consulta.getStatus());
    }

    @Test
    public void confirmar_deCancelada_ignoraEMantemStatus() {
        consulta.cancelar();
        consulta.confirmar();
        assertEquals("CANCELADA", consulta.getStatus());
    }

    @Test
    public void confirmar_deRealizada_ignoraEMantemStatus() {
        consulta.confirmar();
        consulta.realizar();
        consulta.confirmar();
        assertEquals("REALIZADA", consulta.getStatus());
    }

    // -------------------------------------------------------------------------
    // cancelar
    // -------------------------------------------------------------------------

    @Test
    public void cancelar_deAgendada_mudaParaCancelada() {
        consulta.cancelar();
        assertEquals("CANCELADA", consulta.getStatus());
    }

    @Test
    public void cancelar_deConfirmada_mudaParaCancelada() {
        consulta.confirmar();
        consulta.cancelar();
        assertEquals("CANCELADA", consulta.getStatus());
    }

    @Test
    public void cancelar_deCancelada_ignoraEMantemStatus() {
        consulta.cancelar();
        consulta.cancelar();
        assertEquals("CANCELADA", consulta.getStatus());
    }

    @Test
    public void cancelar_deRealizada_ignoraEMantemStatus() {
        consulta.confirmar();
        consulta.realizar();
        consulta.cancelar();
        assertEquals("REALIZADA", consulta.getStatus());
    }

    // -------------------------------------------------------------------------
    // realizar
    // -------------------------------------------------------------------------

    @Test
    public void realizar_deConfirmada_mudaParaRealizada() {
        consulta.confirmar();
        consulta.realizar();
        assertEquals("REALIZADA", consulta.getStatus());
    }

    @Test
    public void realizar_deAgendada_ignoraEMantemStatus() {
        consulta.realizar();
        assertEquals("AGENDADA", consulta.getStatus());
    }

    @Test
    public void realizar_deCancelada_ignoraEMantemStatus() {
        consulta.cancelar();
        consulta.realizar();
        assertEquals("CANCELADA", consulta.getStatus());
    }

    @Test
    public void realizar_deRealizada_ignoraEMantemStatus() {
        consulta.confirmar();
        consulta.realizar();
        consulta.realizar();
        assertEquals("REALIZADA", consulta.getStatus());
    }

    // -------------------------------------------------------------------------
    // observacoes
    // -------------------------------------------------------------------------

    @Test
    public void setObservacoes_atualizaValor() {
        consulta.setObservacoes("Paciente alérgico a penicilina.");
        assertEquals("Paciente alérgico a penicilina.", consulta.getObservacoes());
    }

    // -------------------------------------------------------------------------
    // AgendaMedica — agendar
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void agendar_consultaNula_lancaExcecao() {
        agenda.agendar(null);
    }

    @Test
    public void agendar_consultaValida_adicionaAoAgenda() {
        agenda.agendar(consulta);
        assertNotNull(agenda.buscarPorId(1));
    }

    // -------------------------------------------------------------------------
    // AgendaMedica — buscarPorId
    // -------------------------------------------------------------------------

    @Test
    public void buscarPorId_existente_retornaConsulta() {
        agenda.agendar(consulta);
        assertEquals(consulta, agenda.buscarPorId(1));
    }

    @Test
    public void buscarPorId_inexistente_retornaNull() {
        assertNull(agenda.buscarPorId(99));
    }

    // -------------------------------------------------------------------------
    // AgendaMedica — listarPorMedico
    // -------------------------------------------------------------------------

    @Test
    public void listarPorMedico_retornaApenasConsultasDoMedico() {
        Consulta c2 = new Consulta(2, "Maria", "Dr. Bruno", "21/06/2025 10:00", "");
        agenda.agendar(consulta);
        agenda.agendar(c2);

        List<Consulta> resultado = agenda.listarPorMedico("Dra. Ana");
        assertEquals(1, resultado.size());
        assertEquals(consulta, resultado.get(0));
    }

    @Test
    public void listarPorMedico_retornaCopia_naoAfetaAgendaInterna() {
        agenda.agendar(consulta);
        List<Consulta> copia = agenda.listarPorMedico("Dra. Ana");
        copia.clear();
        assertEquals(1, agenda.listarPorMedico("Dra. Ana").size());
    }

    @Test
    public void listarPorMedico_medicoInexistente_retornaListaVazia() {
        agenda.agendar(consulta);
        assertTrue(agenda.listarPorMedico("Dr. Fantasma").isEmpty());
    }

    // -------------------------------------------------------------------------
    // AgendaMedica — listarAtivas
    // -------------------------------------------------------------------------

    @Test
    public void listarAtivas_retornaAgendadaEConfirmada() {
        Consulta c2 = new Consulta(2, "Maria", "Dr. Bruno", "21/06/2025 10:00", "");
        Consulta c3 = new Consulta(3, "Pedro", "Dra. Ana",  "22/06/2025 11:00", "");

        agenda.agendar(consulta); // AGENDADA
        agenda.agendar(c2);       // AGENDADA -> CONFIRMADA
        agenda.agendar(c3);       // AGENDADA -> CANCELADA

        c2.confirmar();
        c3.cancelar();

        List<Consulta> ativas = agenda.listarAtivas();
        assertEquals(2, ativas.size());
        assertTrue(ativas.contains(consulta));
        assertTrue(ativas.contains(c2));
        assertFalse(ativas.contains(c3));
    }

    @Test
    public void listarAtivas_todasCanceladasOuRealizadas_retornaListaVazia() {
        consulta.cancelar();
        agenda.agendar(consulta);
        assertTrue(agenda.listarAtivas().isEmpty());
    }
}