package Lista05.tests.farmacia;

import Lista05.farmacia.Formula;
import Lista05.farmacia.Ingrediente;
import Lista05.farmacia.Pedido;
import org.junit.Test;
import static org.junit.Assert.*;

public class FarmaciaTest {

    private Ingrediente vitamina = new Ingrediente("Vitamina C", 0.05, "mg");
    private Ingrediente zinco    = new Ingrediente("Zinco", 0.20, "mg");

    @Test
    public void testCustoBasico() {
        Formula f = new Formula("Teste");
        f.adicionarIngrediente(vitamina, 500);
        f.adicionarIngrediente(zinco, 10);
        // 500*0.05 + 10*0.20 = 25 + 2 = 27
        assertEquals(27.0, f.calcularCusto(), 0.001);
    }

    @Test
    public void testCustoComMargem() {
        Formula f = new Formula("Teste");
        f.adicionarIngrediente(vitamina, 500);
        f.adicionarIngrediente(zinco, 10);
        // 27 * 1.30 = 35.10
        assertEquals(35.10, f.calcularCusto(0.30), 0.001);
    }

    @Test
    public void testCustoComMargemEDesconto() {
        Formula f = new Formula("Teste");
        f.adicionarIngrediente(vitamina, 500);
        f.adicionarIngrediente(zinco, 10);
        // 35.10 - 5.00 = 30.10
        assertEquals(30.10, f.calcularCusto(0.30, 5.00), 0.001);
    }

    @Test
    public void testReceituarioContemIngrediente() {
        Formula f = new Formula("Teste");
        f.adicionarIngrediente(vitamina, 500, "dissolver antes");
        String rec = f.gerarReceituario();
        assertTrue(rec.contains("Vitamina C"));
        assertTrue(rec.contains("dissolver antes"));
    }

    @Test
    public void testReceituarioSemObservacao() {
        Formula f = new Formula("Teste");
        f.adicionarIngrediente(zinco, 10);
        String rec = f.gerarReceituario();
        assertTrue(rec.contains("Zinco"));
    }

    @Test
    public void testResumoPedidoContemPaciente() {
        Formula f = new Formula("Antioxidante");
        f.adicionarIngrediente(vitamina, 100);
        Pedido p = new Pedido("Carlos", "30/06/2025", f);
        assertTrue(p.resumo().contains("Carlos"));
        assertTrue(p.resumo().contains("Vitamina C"));
    }
}