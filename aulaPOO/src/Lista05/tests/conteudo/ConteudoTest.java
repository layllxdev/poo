package Lista05.tests.conteudo;

import Lista05.conteudo.Criador;
import Lista05.conteudo.Midia;
import Lista05.conteudo.Publicacao;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConteudoTest {

    private Criador verificado    = new Criador("ana_digital", 120000, true);
    private Criador naoVerificado = new Criador("joao_comum", 120000, false);
    private Midia video           = new Midia("video", 45, "1080p");
    private Midia audio           = new Midia("audio", 120, "");

    @Test
    public void testTaxaEngajamentoPorSeguidores() {
        Publicacao p = new Publicacao(verificado, video, 8500, 430, 210);
        // (8500 + 430 + 210) / 120000 * 100 = 9140/120000*100 ≈ 7.616
        assertEquals(7.616, p.taxaEngajamento(), 0.01);
    }

    @Test
    public void testTaxaEngajamentoPorVisualizacoes() {
        Publicacao p = new Publicacao(verificado, video, 8500, 430, 210);
        // 9140 / 200000 * 100 ≈ 4.57
        assertEquals(4.57, p.taxaEngajamento(200000), 0.01);
    }

    @Test
    public void testEhViralVerificadoTaxaMedia() {
        // taxa ≈ 7.6 >= 5.0 e verificado → viral
        Publicacao p = new Publicacao(verificado, video, 8500, 430, 210);
        assertTrue(p.ehViral());
    }

    @Test
    public void testNaoEhViralNaoVerificadoTaxaBaixa() {
        // taxa < 10 e não verificado → não viral
        Publicacao p = new Publicacao(naoVerificado, video, 1000, 50, 10);
        assertFalse(p.ehViral());
    }

    @Test
    public void testEhViralTaxaAltaSemVerificacao() {
        // taxa >= 10 → viral independente de verificação
        Publicacao p = new Publicacao(naoVerificado, video, 15000, 500, 500);
        assertTrue(p.ehViral());
    }

    @Test
    public void testResumoPortugues() {
        Publicacao p = new Publicacao(verificado, video, 100, 10, 5);
        String r = p.resumo("pt");
        assertTrue(r.contains("ana_digital"));
        assertTrue(r.contains("1080p") || r.contains("Vídeo") || r.contains("video"));
    }

    @Test
    public void testResumoIngles() {
        Publicacao p = new Publicacao(verificado, video, 100, 10, 5);
        String r = p.resumo("en");
        assertTrue(r.contains("Likes") || r.contains("Followers") || r.contains("Shares"));
    }

    @Test
    public void testDescricaoVideo() {
        assertTrue(video.descricao().contains("1080p"));
        assertTrue(video.descricao().contains("45"));
    }

    @Test
    public void testDescricaoAudio() {
        assertTrue(audio.descricao().contains("120"));
    }

    @Test
    public void testPerfilVerificado() {
        assertTrue(verificado.perfil().contains("ana_digital"));
        assertTrue(verificado.perfil().contains("✓"));
    }

    @Test
    public void testPerfilNaoVerificado() {
        assertFalse(naoVerificado.perfil().contains("✓"));
    }
}