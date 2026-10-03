package Lista04.tests.lista04.laboratorio;

import Lista04.src.lista04.laboratorio.EstoqueLaboratorio;
import Lista04.src.lista04.laboratorio.ItemLaboratorio;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EstoqueLaboratorioTest {

    private ItemLaboratorio item;
    private EstoqueLaboratorio estoque;

    @Before
    public void setUp() {
        item    = new ItemLaboratorio("LAB-001", "Álcool Isopropílico", 50, 10);
        estoque = new EstoqueLaboratorio();
    }

    // -------------------------------------------------------------------------
    // Construtor — ItemLaboratorio
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void item_codigoNulo_lancaExcecao() {
        new ItemLaboratorio(null, "Nome", 10, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void item_codigoVazio_lancaExcecao() {
        new ItemLaboratorio("", "Nome", 10, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void item_nomeNulo_lancaExcecao() {
        new ItemLaboratorio("COD", null, 10, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void item_nomeVazio_lancaExcecao() {
        new ItemLaboratorio("COD", "", 10, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void item_quantidadeDisponıvelNegativa_lancaExcecao() {
        new ItemLaboratorio("COD", "Nome", -1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void item_quantidadeMinimaZero_lancaExcecao() {
        new ItemLaboratorio("COD", "Nome", 10, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void item_quantidadeMinimaNegativa_lancaExcecao() {
        new ItemLaboratorio("COD", "Nome", 10, -1);
    }

    @Test
    public void item_valoresValidos_criadoComSucesso() {
        assertEquals("LAB-001", item.getCodigo());
        assertEquals("Álcool Isopropílico", item.getNome());
        assertEquals(50, item.getQuantidadeDisponivel());
        assertEquals(10, item.getQuantidadeMinima());
    }

    // -------------------------------------------------------------------------
    // codigo — imutabilidade
    // -------------------------------------------------------------------------

    @Test
    public void item_getCodigo_retornaValorOriginal() {
        assertEquals("LAB-001", item.getCodigo());
    }

    // -------------------------------------------------------------------------
    // Status — cálculo automático
    // -------------------------------------------------------------------------

    @Test
    public void status_quantidadeAcimaDoMinimo_normal() {
        assertEquals("NORMAL", item.getStatus());
    }

    @Test
    public void status_quantidadeIgualAoMinimo_alerta() {
        ItemLaboratorio i = new ItemLaboratorio("X", "Y", 10, 10);
        assertEquals("ALERTA", i.getStatus());
    }

    @Test
    public void status_quantidadeAbaixoDoMinimo_alerta() {
        ItemLaboratorio i = new ItemLaboratorio("X", "Y", 5, 10);
        assertEquals("ALERTA", i.getStatus());
    }

    @Test
    public void status_quantidadeZero_esgotado() {
        ItemLaboratorio i = new ItemLaboratorio("X", "Y", 0, 10);
        assertEquals("ESGOTADO", i.getStatus());
    }

    @Test
    public void status_atualizaAutomaticamenteAposSaida() {
        item.saida(45);          // 50 - 45 = 5, abaixo do mínimo 10
        assertEquals("ALERTA", item.getStatus());
        item.saida(5);           // 5 - 5 = 0
        assertEquals("ESGOTADO", item.getStatus());
    }

    @Test
    public void status_atualizaAutomaticamenteAposEntrada() {
        ItemLaboratorio i = new ItemLaboratorio("X", "Y", 0, 10);
        assertEquals("ESGOTADO", i.getStatus());
        i.entrada(5);
        assertEquals("ALERTA", i.getStatus());
        i.entrada(10);
        assertEquals("NORMAL", i.getStatus());
    }

    // -------------------------------------------------------------------------
    // entrada
    // -------------------------------------------------------------------------

    @Test
    public void entrada_quantidadeValida_aumentaEstoque() {
        item.entrada(20);
        assertEquals(70, item.getQuantidadeDisponivel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void entrada_quantidadeZero_lancaExcecao() {
        item.entrada(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void entrada_quantidadeNegativa_lancaExcecao() {
        item.entrada(-5);
    }

    // -------------------------------------------------------------------------
    // saida
    // -------------------------------------------------------------------------

    @Test
    public void saida_quantidadeValida_diminuiEstoque() {
        item.saida(10);
        assertEquals(40, item.getQuantidadeDisponivel());
    }

    @Test
    public void saida_quantidadeExataDoEstoque_zeraEstoque() {
        item.saida(50);
        assertEquals(0, item.getQuantidadeDisponivel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void saida_quantidadeZero_lancaExcecao() {
        item.saida(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saida_quantidadeNegativa_lancaExcecao() {
        item.saida(-1);
    }

    @Test
    public void saida_quantidadeQueZerariaEstoque_ignoraOperacao() {
        item.saida(51);          // 50 - 51 seria negativo
        assertEquals(50, item.getQuantidadeDisponivel());
    }

    // -------------------------------------------------------------------------
    // EstoqueLaboratorio — cadastrar
    // -------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void cadastrar_itemNulo_lancaExcecao() {
        estoque.cadastrar(null);
    }

    @Test
    public void cadastrar_itemValido_adicionaAoEstoque() {
        estoque.cadastrar(item);
        assertNotNull(estoque.buscarPorCodigo("LAB-001"));
    }

    // -------------------------------------------------------------------------
    // EstoqueLaboratorio — buscarPorCodigo
    // -------------------------------------------------------------------------

    @Test
    public void buscarPorCodigo_existente_retornaItem() {
        estoque.cadastrar(item);
        assertEquals(item, estoque.buscarPorCodigo("LAB-001"));
    }

    @Test
    public void buscarPorCodigo_inexistente_retornaNull() {
        assertNull(estoque.buscarPorCodigo("NAO-EXISTE"));
    }

    // -------------------------------------------------------------------------
    // EstoqueLaboratorio — listarEmAlerta
    // -------------------------------------------------------------------------

    @Test
    public void listarEmAlerta_retornaApenasAlertaEEsgotado() {
        ItemLaboratorio normal   = new ItemLaboratorio("N1", "Normal",   50, 10);
        ItemLaboratorio alerta   = new ItemLaboratorio("A1", "Alerta",    5, 10);
        ItemLaboratorio esgotado = new ItemLaboratorio("E1", "Esgotado",  0, 10);

        estoque.cadastrar(normal);
        estoque.cadastrar(alerta);
        estoque.cadastrar(esgotado);

        List<ItemLaboratorio> resultado = estoque.listarEmAlerta();
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(alerta));
        assertTrue(resultado.contains(esgotado));
        assertFalse(resultado.contains(normal));
    }

    @Test
    public void listarEmAlerta_retornaCopia_naoAfetaEstoqueInterno() {
        ItemLaboratorio alerta = new ItemLaboratorio("A1", "Alerta", 5, 10);
        estoque.cadastrar(alerta);

        List<ItemLaboratorio> copia = estoque.listarEmAlerta();
        copia.clear();

        assertEquals(1, estoque.listarEmAlerta().size());
    }

    @Test
    public void listarEmAlerta_semItensEmAlerta_retornaListaVazia() {
        estoque.cadastrar(item); // status NORMAL
        assertTrue(estoque.listarEmAlerta().isEmpty());
    }
}