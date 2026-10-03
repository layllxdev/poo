package Lista05.tests.treino;

import Lista05.treino.Serie;
import Lista05.treino.Treino;
import Lista05.treino.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreinoTest {

    private Usuario carlos = new Usuario("Carlos", 78.0, 1.75, 28, "M");
    private Usuario ana    = new Usuario("Ana", 55.0, 1.65, 32, "F");

    private Treino treinoCompleto() {
        Treino t = new Treino(carlos);
        t.adicionarSerie("Supino", 10, 80.0);
        t.adicionarSerie("Supino", 10, 80.0);
        t.adicionarSerie(new Serie("Agachamento", 12, 100.0));
        return t;
    }

    @Test
    public void testVolumeTotal() {
        // 10*80 + 10*80 + 12*100 = 800 + 800 + 1200 = 2800
        assertEquals(2800.0, treinoCompleto().calcularVolume(), 0.001);
    }

    @Test
    public void testVolumePorExercicio() {
        // apenas Supino: 800 + 800 = 1600
        assertEquals(1600.0, treinoCompleto().calcularVolume("Supino"), 0.001);
    }

    @Test
    public void testVolumePorExercicioInexistente() {
        assertEquals(0.0, treinoCompleto().calcularVolume("Rosca"), 0.001);
    }

    @Test
    public void testFcMaximaMasculino() {
        // 220 - 28 = 192
        assertEquals(192, treinoCompleto().fcMaxima());
    }

    @Test
    public void testFcMaximaFeminino() {
        Treino t = new Treino(ana);
        // 226 - 32 = 194
        assertEquals(194, t.fcMaxima());
    }

    @Test
    public void testAvaliarAdequado() {
        // IMC Carlos = 78 / (1.75^2) ≈ 25.5, volume 2800 >= 1000
        assertEquals("Treino adequado", treinoCompleto().avaliar());
    }

    @Test
    public void testAvaliarAumentarCarga() {
        Treino t = new Treino(carlos);
        t.adicionarSerie("Supino", 2, 10.0); // volume = 20, IMC ok
        assertEquals("Aumentar carga", t.avaliar());
    }

    @Test
    public void testAvaliarConsulteProfissional() {
        // IMC muito alto (obesidade grau III)
        Usuario obeso = new Usuario("X", 150.0, 1.70, 30, "M");
        Treino t = new Treino(obeso);
        t.adicionarSerie("Supino", 10, 200.0);
        assertEquals("Consulte um profissional", t.avaliar());
    }

    @Test
    public void testRelatorioContemUsuario() {
        assertTrue(treinoCompleto().relatorio().contains("Carlos"));
    }

    @Test
    public void testRelatorioContemExercicio() {
        assertTrue(treinoCompleto().relatorio().contains("Supino"));
    }

    @Test
    public void testLinhaSerieContemDados() {
        Serie s = new Serie("Supino", 10, 80.0);
        assertTrue(s.linha().contains("Supino"));
        assertTrue(s.linha().contains("80"));
    }

    @Test
    public void testCalcularIMC() {
        // 78 / (1.75^2) = 78 / 3.0625 ≈ 25.5
        assertEquals(25.5, carlos.calcularIMC(), 0.1);
    }
}