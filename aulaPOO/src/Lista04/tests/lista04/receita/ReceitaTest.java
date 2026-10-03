package Lista04.tests.lista04.receita;

import Lista04.src.lista04.receita.Receita;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReceitaTest {

    private Receita receita;

    @Before
    public void setUp() {
        receita = new Receita("Bolo de Cenoura", 60, 8);
    }

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void construtor_nomeNulo_lancaExcecao() {
        new Receita(null, 30, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_nomeVazio_lancaExcecao() {
        new Receita("", 30, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_nomeApenasBrancos_lancaExcecao() {
        new Receita("   ", 30, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_tempoPreparoZero_lancaExcecao() {
        new Receita("Bolo", 0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_tempoPreparoNegativo_lancaExcecao() {
        new Receita("Bolo", -10, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_rendimentoZero_lancaExcecao() {
        new Receita("Bolo", 30, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_rendimentoNegativo_lancaExcecao() {
        new Receita("Bolo", 30, -1);
    }

    @Test
    public void construtor_valoresValidos_criaComSucResso() {
        Receita r = new Receita("Sopa", 45, 2);
        assertEquals("Sopa", r.getNome());
        assertEquals(45, r.getTempoPreparo());
        assertEquals(2, r.getRendimentoPorcoes());
    }

    // -------------------------------------------------------------------------
    // setTempoPreparo
    // -------------------------------------------------------------------------

    @Test
    public void setTempoPreparo_valorValido_atualiza() {
        receita.setTempoPreparo(90);
        assertEquals(90, receita.getTempoPreparo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTempoPreparo_zero_lancaExcecao() {
        receita.setTempoPreparo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTempoPreparo_negativo_lancaExcecao() {
        receita.setTempoPreparo(-5);
    }

    // -------------------------------------------------------------------------
    // setRendimentoPorcoes
    // -------------------------------------------------------------------------

    @Test
    public void setRendimentoPorcoes_valorValido_atualiza() {
        receita.setRendimentoPorcoes(12);
        assertEquals(12, receita.getRendimentoPorcoes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRendimentoPorcoes_zero_lancaExcecao() {
        receita.setRendimentoPorcoes(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRendimentoPorcoes_negativo_lancaExcecao() {
        receita.setRendimentoPorcoes(-3);
    }

    // -------------------------------------------------------------------------
    // adicionarIngrediente
    // -------------------------------------------------------------------------

    @Test
    public void adicionarIngrediente_valido_adicionaNaLista() {
        receita.adicionarIngrediente("Farinha");
        assertTrue(receita.getIngredientes().contains("Farinha"));
    }

    @Test
    public void adicionarIngrediente_nulo_ignoraSilenciosamente() {
        receita.adicionarIngrediente(null);
        assertTrue(receita.getIngredientes().isEmpty());
    }

    @Test
    public void adicionarIngrediente_vazio_ignoraSilenciosamente() {
        receita.adicionarIngrediente("");
        assertTrue(receita.getIngredientes().isEmpty());
    }

    @Test
    public void adicionarIngrediente_apenasBrancos_ignoraSilenciosamente() {
        receita.adicionarIngrediente("   ");
        assertTrue(receita.getIngredientes().isEmpty());
    }

    @Test
    public void adicionarIngrediente_multiplos_mantemTodos() {
        receita.adicionarIngrediente("Ovo");
        receita.adicionarIngrediente("Leite");
        receita.adicionarIngrediente("Açúcar");
        assertEquals(3, receita.getIngredientes().size());
    }

    // -------------------------------------------------------------------------
    // removerIngrediente
    // -------------------------------------------------------------------------

    @Test
    public void removerIngrediente_existente_remove() {
        receita.adicionarIngrediente("Sal");
        receita.removerIngrediente("Sal");
        assertFalse(receita.getIngredientes().contains("Sal"));
    }

    @Test
    public void removerIngrediente_inexistente_ignoraSilenciosamente() {
        receita.adicionarIngrediente("Pimenta");
        receita.removerIngrediente("Alho");
        assertEquals(1, receita.getIngredientes().size());
    }

    @Test
    public void removerIngrediente_listaVazia_ignoraSilenciosamente() {
        receita.removerIngrediente("Qualquer");
        assertTrue(receita.getIngredientes().isEmpty());
    }

    // -------------------------------------------------------------------------
    // getIngredientes — proteção de cópia
    // -------------------------------------------------------------------------

    @Test
    public void getIngredientes_retornaCopia_naoAfetaListaInterna() {
        receita.adicionarIngrediente("Manteiga");
        List<String> copia = receita.getIngredientes();
        copia.add("INVASOR");
        assertFalse(receita.getIngredientes().contains("INVASOR"));
    }

    @Test
    public void getIngredientes_listaVazia_retornaListaVazia() {
        assertTrue(receita.getIngredientes().isEmpty());
    }

    @Test
    public void getIngredientes_refletemAdicionesPosteriores() {
        receita.adicionarIngrediente("Canela");
        List<String> antes = receita.getIngredientes();
        receita.adicionarIngrediente("Cravo");
        List<String> depois = receita.getIngredientes();
        assertEquals(1, antes.size());
        assertEquals(2, depois.size());
    }
}