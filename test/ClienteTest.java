import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class ClienteTest {

    private Cliente cliente;
    private CartaoDeFidelidade cartaoDeFidelidade;
    private Map<String, Double> mapaDePrecos;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("Suerdo", 18);
    }


    @org.junit.Test
    public void testCalcularValorTotal() {
        Produto produto1 = new Produto("Produto 1") {
            @Override
            public double getPreco() {
                return 10.0;
            }
        };

        Produto produto2 = new Produto("Produto 2") {
            @Override
            public double getPreco() {
                return 20.0;
            }
        };

        cliente.getPedido().addProduto(produto1);
        cliente.getPedido().addProduto(produto2);

        String valorTotal = cliente.calcularValorTotal();
        Assertions.assertEquals("R$ 30,00 (Com desconto)", valorTotal);
    }

    @Test
    public void testCalcularValorTotalSemDesconto() {
        try {
            Produto produto = new Produto("COLAGENO") {
                @Override
                public double getPreco() {
                    return 15.0;
                }
            };

            // Adicione COLAGENO ao mapa de preços
            Map<String, Double> mapaDePrecos = new HashMap<>();
            mapaDePrecos.put("COLAGENO", 15.0);
            Produto.setMapaDePrecos(mapaDePrecos);

            cliente.getPedido().addProduto(produto);

            String valorTotal = cliente.calcularValorTotal();
            Assertions.assertEquals("R$ 15,00", valorTotal);
        } catch (ProdutoInvalidoException e) {
            Assertions.fail( e.getMessage());
        }
    }

    @Test
    public void testDataDoPedidoToString() {
        LocalDate dataHora = LocalDate.of(2023, Month.JANUARY, 1);
        cliente.getPedido().setDataHora(dataHora.atStartOfDay());

        String dataHoraFormatada = cliente.dataDoPedidoToString();
        Assertions.assertEquals("01/01/2023 00:00", dataHoraFormatada);
    }
}
