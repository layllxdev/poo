package Lista04.tests.lista04.drone;

import Lista04.src.lista04.drone.Drone;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DroneTest {

    private Drone drone;

    @Before
    public void setUp() {
        drone = new Drone("DR-001");
    }

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void construtor_identificadorNulo_lancaExcecao() {
        new Drone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_identificadorVazio_lancaExcecao() {
        new Drone("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_identificadorApenasBrancos_lancaExcecao() {
        new Drone("   ");
    }

    @Test
    public void construtor_valido_estadoInicialCorreto() {
        Drone d = new Drone("DR-X");
        assertEquals("DR-X", d.getIdentificador());
        assertEquals(0, d.getBateria());
        assertEquals(0, d.getAltitude());
        assertFalse(d.isEmVoo());
    }

    // -------------------------------------------------------------------------
    // identificador — imutabilidade
    // -------------------------------------------------------------------------

    @Test
    public void getIdentificador_retornaValorDefinidoNoConstrutor() {
        assertEquals("DR-001", drone.getIdentificador());
    }

    // -------------------------------------------------------------------------
    // setBateria
    // -------------------------------------------------------------------------

    @Test
    public void setBateria_valorValido_atualiza() {
        drone.setBateria(50);
        assertEquals(50, drone.getBateria());
    }

    @Test
    public void setBateria_limiteInferior_atualiza() {
        drone.setBateria(0);
        assertEquals(0, drone.getBateria());
    }

    @Test
    public void setBateria_limiteSuperior_atualiza() {
        drone.setBateria(100);
        assertEquals(100, drone.getBateria());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBateria_negativo_lancaExcecao() {
        drone.setBateria(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBateria_acimaDecem_lancaExcecao() {
        drone.setBateria(101);
    }

    // -------------------------------------------------------------------------
    // decolar
    // -------------------------------------------------------------------------

    @Test
    public void decolar_bateriaAcimaDe20_colocaEmVoo() {
        drone.setBateria(21);
        drone.decolar();
        assertTrue(drone.isEmVoo());
    }

    @Test
    public void decolar_bateriaExatamente21_colocaEmVoo() {
        drone.setBateria(21);
        drone.decolar();
        assertTrue(drone.isEmVoo());
    }

    @Test
    public void decolar_bateriaIgualA20_naoDecola() {
        drone.setBateria(20);
        drone.decolar();
        assertFalse(drone.isEmVoo());
    }

    @Test
    public void decolar_bateriaZero_naoDecola() {
        drone.decolar();
        assertFalse(drone.isEmVoo());
    }

    // -------------------------------------------------------------------------
    // pousar
    // -------------------------------------------------------------------------

    @Test
    public void pousar_emVoo_defineEmVooFalseEAltitudeZero() {
        drone.setBateria(100);
        drone.decolar();
        drone.setAltitude(50);
        drone.pousar();
        assertFalse(drone.isEmVoo());
        assertEquals(0, drone.getAltitude());
    }

    @Test
    public void pousar_semEstarEmVoo_mantemEstadoConsistente() {
        drone.pousar();
        assertFalse(drone.isEmVoo());
        assertEquals(0, drone.getAltitude());
    }

    // -------------------------------------------------------------------------
    // setAltitude
    // -------------------------------------------------------------------------

    @Test
    public void setAltitude_emVooValorValido_atualiza() {
        drone.setBateria(100);
        drone.decolar();
        drone.setAltitude(80);
        assertEquals(80, drone.getAltitude());
    }

    @Test
    public void setAltitude_emVooLimiteMaximo_atualiza() {
        drone.setBateria(100);
        drone.decolar();
        drone.setAltitude(120);
        assertEquals(120, drone.getAltitude());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setAltitude_emVooNegativo_lancaExcecao() {
        drone.setBateria(100);
        drone.decolar();
        drone.setAltitude(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setAltitude_emVooAcimaDe120_lancaExcecao() {
        drone.setBateria(100);
        drone.decolar();
        drone.setAltitude(121);
    }

    @Test
    public void setAltitude_semEstarEmVoo_ignoraOperacao() {
        drone.setAltitude(50);
        assertEquals(0, drone.getAltitude());
    }

    @Test
    public void setAltitude_aposPouso_ignoraOperacao() {
        drone.setBateria(100);
        drone.decolar();
        drone.setAltitude(60);
        drone.pousar();
        drone.setAltitude(30);
        assertEquals(0, drone.getAltitude());
    }
}