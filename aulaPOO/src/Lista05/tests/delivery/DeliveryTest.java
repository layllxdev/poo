package Lista05.tests.delivery;

import Lista05.delivery.ItemPedido;
import Lista05.delivery.Pedido;
import Lista05.delivery.Restaurante;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeliveryTest {

    private Restaurante r = new Restaurante("Sushi Boa Vista", "Japonês", 4.8);

    private Pedido pedidoPadrao() {
        Pedido p = new Pedido("Lucas", r, 3.0);
        p.adicionarItem("Temaki Salmão", 14.95, 2);
        p.adicionarItem(new ItemPedido("Missoshiru", 6.00, 1));
        return p;
    }

    @Test
    public void testSubtotal() {
        // 14.95*2 + 6.00*1 = 29.90 + 6.00 = 35.90
        assertEquals(35.90, pedidoPadrao().calcularSubtotal(), 0.001);
    }

    @Test
    public void testTotalPadrao() {
        // 35.90 + 2.00 + 1.50*3 = 35.90 + 6.50 = 42.40
        assertEquals(42.40, pedidoPadrao().calcularTotal(), 0.001);
    }

    @Test
    public void testTotalExpressa() {
        // taxa expressa = (2.00 + 1.50*3) * 2 = 6.50 * 2 = 13.00
        // total = 35.90 + 13.00 = 48.90
        assertEquals(48.90, pedidoPadrao().calcularTotal("expressa"), 0.001);
    }

    @Test
    public void testTotalRetirada() {
        // sem taxa de entrega
        assertEquals(35.90, pedidoPadrao().calcularTotal("retirada"), 0.001);
    }

    @Test
    public void testTotalComCupom() {
        // retirada: 35.90 - 5.00 = 30.90
        assertEquals(30.90, pedidoPadrao().calcularTotal("retirada", 5.00), 0.001);
    }

    @Test
    public void testTotalComCupomMaiorQueValor() {
        // cupom maior que o total → resultado não pode ser negativo
        assertEquals(0.00, pedidoPadrao().calcularTotal("retirada", 999.00), 0.001);
    }

    @Test
    public void testResumoPedidoContemCliente() {
        assertTrue(pedidoPadrao().resumoPedido().contains("Lucas"));
    }

    @Test
    public void testResumoPedidoContemRestaurante() {
        assertTrue(pedidoPadrao().resumoPedido().contains("Sushi Boa Vista"));
    }

    @Test
    public void testResumoPedidoContemItem() {
        assertTrue(pedidoPadrao().resumoPedido().contains("Temaki Salmão"));
    }

    @Test
    public void testLinhaItem() {
        ItemPedido item = new ItemPedido("Missoshiru", 6.00, 1);
        assertTrue(item.linha().contains("Missoshiru"));
        assertTrue(item.linha().contains("6"));
    }

    @Test
    public void testInfoRestaurante() {
        String info = r.info();
        assertTrue(info.contains("Sushi Boa Vista"));
        assertTrue(info.contains("4.8"));
    }
}