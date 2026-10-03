package Lista04.tests.lista04.podcast;

import Lista04.src.lista04.podcast.Episodio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EpisodioTest {

    private Episodio episodio;

    @Before
    public void setUp() {
        episodio = new Episodio("Introdução ao Java", 1, 45);
    }

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void construtor_tituloNulo_lancaExcecao() {
        new Episodio(null, 1, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_tituloVazio_lancaExcecao() {
        new Episodio("", 1, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_tituloApenasBrancos_lancaExcecao() {
        new Episodio("   ", 1, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_numeroZero_lancaExcecao() {
        new Episodio("Título", 0, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_numeroNegativo_lancaExcecao() {
        new Episodio("Título", -1, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_duracaoZero_lancaExcecao() {
        new Episodio("Título", 1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtor_duracaoNegativa_lancaExcecao() {
        new Episodio("Título", 1, -10);
    }

    @Test
    public void construtor_valoresValidos_estadoInicialCorreto() {
        assertEquals("Introdução ao Java", episodio.getTitulo());
        assertEquals(1, episodio.getNumero());
        assertEquals(45, episodio.getDuracaoMinutos());
        assertEquals("RASCUNHO", episodio.getStatus());
    }

    // -------------------------------------------------------------------------
    // numero — imutabilidade
    // -------------------------------------------------------------------------

    @Test
    public void getNumero_retornaValorDefinidoNoConstrutor() {
        assertEquals(1, episodio.getNumero());
    }

    // -------------------------------------------------------------------------
    // setDuracaoMinutos
    // -------------------------------------------------------------------------

    @Test
    public void setDuracaoMinutos_valorValido_atualiza() {
        episodio.setDuracaoMinutos(60);
        assertEquals(60, episodio.getDuracaoMinutos());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDuracaoMinutos_zero_lancaExcecao() {
        episodio.setDuracaoMinutos(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDuracaoMinutos_negativo_lancaExcecao() {
        episodio.setDuracaoMinutos(-5);
    }

    // -------------------------------------------------------------------------
    // publicar
    // -------------------------------------------------------------------------

    @Test
    public void publicar_deRascunho_mudaParaPublicado() {
        episodio.publicar();
        assertEquals("PUBLICADO", episodio.getStatus());
    }

    @Test
    public void publicar_dePublicado_ignoraEMantemStatus() {
        episodio.publicar();
        episodio.publicar();
        assertEquals("PUBLICADO", episodio.getStatus());
    }

    @Test
    public void publicar_deArquivado_ignoraEMantemStatus() {
        episodio.publicar();
        episodio.arquivar();
        episodio.publicar();
        assertEquals("ARQUIVADO", episodio.getStatus());
    }

    // -------------------------------------------------------------------------
    // arquivar
    // -------------------------------------------------------------------------

    @Test
    public void arquivar_dePublicado_mudaParaArquivado() {
        episodio.publicar();
        episodio.arquivar();
        assertEquals("ARQUIVADO", episodio.getStatus());
    }

    @Test
    public void arquivar_deRascunho_ignoraEMantemStatus() {
        episodio.arquivar();
        assertEquals("RASCUNHO", episodio.getStatus());
    }

    @Test
    public void arquivar_deArquivado_ignoraEMantemStatus() {
        episodio.publicar();
        episodio.arquivar();
        episodio.arquivar();
        assertEquals("ARQUIVADO", episodio.getStatus());
    }

    // -------------------------------------------------------------------------
    // restaurar
    // -------------------------------------------------------------------------

    @Test
    public void restaurar_deArquivado_mudaParaRascunho() {
        episodio.publicar();
        episodio.arquivar();
        episodio.restaurar();
        assertEquals("RASCUNHO", episodio.getStatus());
    }

    @Test
    public void restaurar_deRascunho_ignoraEMantemStatus() {
        episodio.restaurar();
        assertEquals("RASCUNHO", episodio.getStatus());
    }

    @Test
    public void restaurar_dePublicado_ignoraEMantemStatus() {
        episodio.publicar();
        episodio.restaurar();
        assertEquals("PUBLICADO", episodio.getStatus());
    }

    // -------------------------------------------------------------------------
    // Fluxo completo
    // -------------------------------------------------------------------------

    @Test
    public void fluxoCompleto_rascunhoPublicadoArquivadoRascunhoPublicado() {
        assertEquals("RASCUNHO", episodio.getStatus());
        episodio.publicar();
        assertEquals("PUBLICADO", episodio.getStatus());
        episodio.arquivar();
        assertEquals("ARQUIVADO", episodio.getStatus());
        episodio.restaurar();
        assertEquals("RASCUNHO", episodio.getStatus());
        episodio.publicar();
        assertEquals("PUBLICADO", episodio.getStatus());
    }
}