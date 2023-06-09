import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ProdutoTest {

    private static final double DELTA = 1e-15;
    private Map<String, Double> mapaDePrecos;

    @Before
    public void setUp() {
        mapaDePrecos = new HashMap<>();
        mapaDePrecos.put("PRODUTO1", 10.0);
        mapaDePrecos.put("PRODUTO2", 20.0);
        mapaDePrecos.put("PRODUTO3", 30.0);
        Produto.setMapaDePrecos(mapaDePrecos);
    }

    @Test
    public void testCalcularPreco() {
        Produto produto1 = new ProdutoConcreto("PRODUTO1");
        Assert.assertEquals(10.0, produto1.getPreco(), DELTA);

        Produto produto2 = new ProdutoConcreto("PRODUTO2");
        Assert.assertEquals(20.0, produto2.getPreco(), DELTA);

        Produto produto3 = new ProdutoConcreto("PRODUTO3");
        Assert.assertEquals(30.0, produto3.getPreco(), DELTA);

    }

    private static class ProdutoConcreto extends Produto {
        public ProdutoConcreto(String nome) {
            super(nome);
        }
    }
}
