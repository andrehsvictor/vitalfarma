import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CosmeticoTest {

    @Test
    public void tests() {
        Cosmetico creme = new Cosmetico("Creme para Pele");
        double valorEsperado = 29.90;
        Assertions.assertEquals(valorEsperado, creme.getPreco());

    }

    @Test
    public void testProtetorSolar() {
        Cosmetico cosmetico = new Cosmetico("Protetor Solar");
        double valorEsperado = 39.90;
        Assertions.assertEquals(valorEsperado, cosmetico.getPreco());
    }
    @Test
    public void testHidratante() {
        Cosmetico cosmetico = new Cosmetico("Hidratante");
        double valorEsperado = 19.90;
        Assertions.assertEquals(valorEsperado, cosmetico.getPreco());
    }
    @Test
    public void testOleoDePele() {
        Cosmetico cosmetico = new Cosmetico("Oleo de Pele");
        double valorEsperado = 24.90;
        Assertions.assertEquals(valorEsperado, cosmetico.getPreco());

    }

    @Test
    public void testExcecao() {
        Assertions.assertThrows(ProdutoInvalidoException.class, () -> {
            new Cosmetico("Sabonete");
        });
    }
}
