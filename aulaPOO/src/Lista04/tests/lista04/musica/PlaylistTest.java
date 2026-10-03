package Lista04.tests.lista04.musica;

import Lista04.src.lista04.musica.Musica;
import Lista04.src.lista04.musica.Playlist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaylistTest {

    private Playlist playlist;
    private Musica normal1;
    private Musica normal2;
    private Musica urgente1;
    private Musica urgente2;

    @Before
    public void setUp() {
        playlist  = new Playlist("Minha Playlist");
        normal1   = new Musica("Canção A", "Artista 1", 200, "NORMAL");
        normal2   = new Musica("Canção B", "Artista 2", 180, "NORMAL");
        urgente1  = new Musica("Urgente X", "Artista 3", 210, "URGENTE");
        urgente2  = new Musica("Urgente Y", "Artista 4", 190, "URGENTE");
    }

    // -------------------------------------------------------------------------
    // Construtor — Musica
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void musica_tituloNulo_lancaExcecao() {
        new Musica(null, "Artista", 200, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void musica_tituloVazio_lancaExcecao() {
        new Musica("", "Artista", 200, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void musica_artistaNulo_lancaExcecao() {
        new Musica("Título", null, 200, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void musica_artistaVazio_lancaExcecao() {
        new Musica("Título", "", 200, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void musica_duracaoZero_lancaExcecao() {
        new Musica("Título", "Artista", 0, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void musica_duracaoNegativa_lancaExcecao() {
        new Musica("Título", "Artista", -1, "NORMAL");
    }

    // -------------------------------------------------------------------------
    // setPrioridade — Musica
    // -------------------------------------------------------------------------

    @Test
    public void musica_setPrioridade_normal_atualiza() {
        urgente1.setPrioridade("NORMAL");
        assertEquals("NORMAL", urgente1.getPrioridade());
    }

    @Test
    public void musica_setPrioridade_urgente_atualiza() {
        normal1.setPrioridade("URGENTE");
        assertEquals("URGENTE", normal1.getPrioridade());
    }

    @Test(expected = IllegalArgumentException.class)
    public void musica_setPrioridade_invalida_lancaExcecao() {
        normal1.setPrioridade("ALTA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void musica_setPrioridade_nula_lancaExcecao() {
        normal1.setPrioridade(null);
    }

    // -------------------------------------------------------------------------
    // Construtor — Playlist
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void playlist_nomeNulo_lancaExcecao() {
        new Playlist(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void playlist_nomeVazio_lancaExcecao() {
        new Playlist("");
    }

    @Test
    public void playlist_valida_tamanhoInicialZero() {
        assertEquals(0, playlist.tamanho());
    }

    // -------------------------------------------------------------------------
    // adicionar
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void adicionar_nulo_lancaExcecao() {
        playlist.adicionar(null);
    }

    @Test
    public void adicionar_musicaNormal_vaiParaOFinal() {
        playlist.adicionar(normal1);
        playlist.adicionar(normal2);
        assertEquals(normal1, playlist.proximaMusica());
    }

    @Test
    public void adicionar_musicaUrgente_vaiAntesDeNormais() {
        playlist.adicionar(normal1);
        playlist.adicionar(urgente1);
        assertEquals(urgente1, playlist.proximaMusica());
    }

    @Test
    public void adicionar_duasUrgentes_mantemOrdemEntreUrgentes() {
        playlist.adicionar(normal1);
        playlist.adicionar(urgente1);
        playlist.adicionar(urgente2);
        // urgente1 foi inserido antes de urgente2
        assertEquals(urgente1, playlist.proximaMusica());
        playlist.reproduzirProxima();
        assertEquals(urgente2, playlist.proximaMusica());
    }

    @Test
    public void adicionar_urgenteEntreNormais_ficaAntesDeNormais() {
        playlist.adicionar(normal1);
        playlist.adicionar(normal2);
        playlist.adicionar(urgente1);
        // ordem esperada: urgente1, normal1, normal2
        assertEquals(urgente1, playlist.reproduzirProxima());
        assertEquals(normal1, playlist.reproduzirProxima());
        assertEquals(normal2, playlist.reproduzirProxima());
    }

    // -------------------------------------------------------------------------
    // remover
    // -------------------------------------------------------------------------

    @Test
    public void remover_existente_removeDaFila() {
        playlist.adicionar(normal1);
        playlist.remover("Canção A");
        assertEquals(0, playlist.tamanho());
    }

    @Test
    public void remover_inexistente_ignoraSilenciosamente() {
        playlist.adicionar(normal1);
        playlist.remover("Não Existe");
        assertEquals(1, playlist.tamanho());
    }

    @Test
    public void remover_listaVazia_ignoraSilenciosamente() {
        playlist.remover("Qualquer");
        assertEquals(0, playlist.tamanho());
    }

    // -------------------------------------------------------------------------
    // proximaMusica
    // -------------------------------------------------------------------------

    @Test
    public void proximaMusica_filaVazia_retornaNull() {
        assertNull(playlist.proximaMusica());
    }

    @Test
    public void proximaMusica_naoRemoveDaFila() {
        playlist.adicionar(normal1);
        playlist.proximaMusica();
        assertEquals(1, playlist.tamanho());
    }

    // -------------------------------------------------------------------------
    // reproduzirProxima
    // -------------------------------------------------------------------------

    @Test
    public void reproduzirProxima_filaVazia_retornaNull() {
        assertNull(playlist.reproduzirProxima());
    }

    @Test
    public void reproduzirProxima_removeDaFila() {
        playlist.adicionar(normal1);
        Musica reproduzida = playlist.reproduzirProxima();
        assertEquals(normal1, reproduzida);
        assertEquals(0, playlist.tamanho());
    }

    // -------------------------------------------------------------------------
    // tamanho
    // -------------------------------------------------------------------------

    @Test
    public void tamanho_aposAdicionarERemover_correto() {
        playlist.adicionar(normal1);
        playlist.adicionar(normal2);
        playlist.adicionar(urgente1);
        assertEquals(3, playlist.tamanho());
        playlist.reproduzirProxima();
        assertEquals(2, playlist.tamanho());
    }
}