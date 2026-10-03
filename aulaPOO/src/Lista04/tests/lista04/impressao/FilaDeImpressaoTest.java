package Lista04.tests.lista04.impressao;

import Lista04.src.lista04.impressao.Documento;
import Lista04.src.lista04.impressao.FilaDeImpressao;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaDeImpressaoTest {

    private FilaDeImpressao fila;
    private Documento normal1;
    private Documento normal2;
    private Documento normal3;
    private Documento urgente1;
    private Documento urgente2;

    @Before
    public void setUp() {
        fila     = new FilaDeImpressao("Impressora Principal");
        normal1  = new Documento("relatorio.pdf",      10, "NORMAL");
        normal2  = new Documento("contrato.pdf",        5, "NORMAL");
        normal3  = new Documento("apresentacao.pdf",   20, "NORMAL");
        urgente1 = new Documento("nota_fiscal.pdf",     2, "URGENTE");
        urgente2 = new Documento("laudo_medico.pdf",    3, "URGENTE");
    }

    // -------------------------------------------------------------------------
    // Construtor — Documento
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void documento_nomeNulo_lancaExcecao() {
        new Documento(null, 5, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void documento_nomeVazio_lancaExcecao() {
        new Documento("", 5, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void documento_numeroPaginasZero_lancaExcecao() {
        new Documento("arq.pdf", 0, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void documento_numeroPaginasNegativo_lancaExcecao() {
        new Documento("arq.pdf", -1, "NORMAL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void documento_prioridadeInvalida_lancaExcecao() {
        new Documento("arq.pdf", 5, "MEDIA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void documento_prioridadeNula_lancaExcecao() {
        new Documento("arq.pdf", 5, null);
    }

    @Test
    public void documento_valoresValidos_statusInicialAguardando() {
        assertEquals("AGUARDANDO", normal1.getStatus());
    }

    // -------------------------------------------------------------------------
    // iniciarImpressao e concluir — Documento
    // -------------------------------------------------------------------------

    @Test
    public void iniciarImpressao_deAguardando_mudaParaImprimindo() {
        normal1.iniciarImpressao();
        assertEquals("IMPRIMINDO", normal1.getStatus());
    }

    @Test
    public void concluir_deImprimindo_mudaParaConcluido() {
        normal1.iniciarImpressao();
        normal1.concluir();
        assertEquals("CONCLUIDO", normal1.getStatus());
    }

    @Test
    public void iniciarImpressao_deImprimindo_ignoraEMantemStatus() {
        normal1.iniciarImpressao();
        normal1.iniciarImpressao();
        assertEquals("IMPRIMINDO", normal1.getStatus());
    }

    @Test
    public void iniciarImpressao_deConcluido_ignoraEMantemStatus() {
        normal1.iniciarImpressao();
        normal1.concluir();
        normal1.iniciarImpressao();
        assertEquals("CONCLUIDO", normal1.getStatus());
    }

    @Test
    public void concluir_deAguardando_ignoraEMantemStatus() {
        normal1.concluir();
        assertEquals("AGUARDANDO", normal1.getStatus());
    }

    @Test
    public void concluir_deConcluido_ignoraEMantemStatus() {
        normal1.iniciarImpressao();
        normal1.concluir();
        normal1.concluir();
        assertEquals("CONCLUIDO", normal1.getStatus());
    }

    // -------------------------------------------------------------------------
    // Construtor — FilaDeImpressao
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void fila_nomeNulo_lancaExcecao() {
        new FilaDeImpressao(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fila_nomeVazio_lancaExcecao() {
        new FilaDeImpressao("");
    }

    // -------------------------------------------------------------------------
    // adicionar
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void adicionar_documentoNulo_lancaExcecao() {
        fila.adicionar(null);
    }

    @Test
    public void adicionar_documentoNormal_vaiParaOFinal() {
        fila.adicionar(normal1);
        fila.adicionar(normal2);
        // normal1 deve ser o próximo
        fila.imprimirProximo();
        // após imprimir normal1, o próximo deve ser normal2
        assertEquals(1, fila.totalPaginasNaFila());
    }

    @Test
    public void adicionar_documentoUrgente_vaiAntesDeNormais() {
        fila.adicionar(normal1);
        fila.adicionar(urgente1);
        // urgente1 deve ser impresso antes de normal1
        fila.imprimirProximo();
        assertEquals("CONCLUIDO", urgente1.getStatus());
        assertEquals("AGUARDANDO", normal1.getStatus());
    }

    @Test
    public void adicionar_doisUrgentes_mantemOrdemEntreUrgentes() {
        fila.adicionar(normal1);
        fila.adicionar(urgente1);
        fila.adicionar(urgente2);
        // ordem esperada: urgente1, urgente2, normal1
        fila.imprimirProximo();
        assertEquals("CONCLUIDO", urgente1.getStatus());
        assertEquals("AGUARDANDO", urgente2.getStatus());

        fila.imprimirProximo();
        assertEquals("CONCLUIDO", urgente2.getStatus());
        assertEquals("AGUARDANDO", normal1.getStatus());
    }

    @Test
    public void adicionar_urgenteEntreVariosNormais_ficaAposUrgentesExistentes() {
        fila.adicionar(normal1);
        fila.adicionar(normal2);
        fila.adicionar(urgente1);
        fila.adicionar(urgente2);
        fila.adicionar(normal3);
        // ordem esperada: urgente1, urgente2, normal1, normal2, normal3
        fila.imprimirProximo(); assertEquals("CONCLUIDO", urgente1.getStatus());
        fila.imprimirProximo(); assertEquals("CONCLUIDO", urgente2.getStatus());
        fila.imprimirProximo(); assertEquals("CONCLUIDO", normal1.getStatus());
        fila.imprimirProximo(); assertEquals("CONCLUIDO", normal2.getStatus());
        fila.imprimirProximo(); assertEquals("CONCLUIDO", normal3.getStatus());
    }

    // -------------------------------------------------------------------------
    // cancelar
    // -------------------------------------------------------------------------

    @Test
    public void cancelar_documentoAguardando_removeDeFilaComSucesso() {
        fila.adicionar(normal1);
        fila.cancelar("relatorio.pdf");
        assertEquals(0, fila.totalPaginasNaFila());
    }

    @Test
    public void cancelar_documentoInexistente_ignoraSilenciosamente() {
        fila.adicionar(normal1);
        fila.cancelar("nao_existe.pdf");
        assertEquals(10, fila.totalPaginasNaFila());
    }

    @Test
    public void cancelar_documentoEmImpressao_ignoraEMantemNaFila() {
        fila.adicionar(normal1);
        normal1.iniciarImpressao();    // simula início da impressão
        fila.cancelar("relatorio.pdf");
        assertEquals(10, fila.totalPaginasNaFila());
    }

    @Test
    public void cancelar_filhaVazia_ignoraSilenciosamente() {
        fila.cancelar("qualquer.pdf");
        assertEquals(0, fila.totalPaginasNaFila());
    }

    // -------------------------------------------------------------------------
    // imprimirProximo
    // -------------------------------------------------------------------------

    @Test
    public void imprimirProximo_filaVazia_naoLancaExcecao() {
        fila.imprimirProximo(); // deve exibir mensagem e não lançar exceção
    }

    @Test
    public void imprimirProximo_removeDocumentoDaFila() {
        fila.adicionar(normal1);
        fila.imprimirProximo();
        assertEquals(0, fila.totalPaginasNaFila());
    }

    @Test
    public void imprimirProximo_definStatusConcluido() {
        fila.adicionar(normal1);
        fila.imprimirProximo();
        assertEquals("CONCLUIDO", normal1.getStatus());
    }

    // -------------------------------------------------------------------------
    // totalPaginasNaFila
    // -------------------------------------------------------------------------

    @Test
    public void totalPaginasNaFila_filaVazia_retornaZero() {
        assertEquals(0, fila.totalPaginasNaFila());
    }

    @Test
    public void totalPaginasNaFila_multiplosDocumentos_somaCOrreta() {
        fila.adicionar(normal1);   // 10
        fila.adicionar(normal2);   //  5
        fila.adicionar(urgente1);  //  2
        assertEquals(17, fila.totalPaginasNaFila());
    }

    @Test
    public void totalPaginasNaFila_aposImprimir_descontaPaginas() {
        fila.adicionar(normal1);   // 10
        fila.adicionar(normal2);   //  5
        fila.imprimirProximo();    // remove 2 (urgente1 não está, então remove normal1 = 10)
        assertEquals(5, fila.totalPaginasNaFila());
    }
}