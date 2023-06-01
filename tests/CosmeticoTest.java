import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteCosmetico {

    @Test
    public void testes() {
        Cosmetico creme = new Cosmetico("Creme para Pele");
        double valorEsperado = 29.90;
        Assertions.assertEquals(valorEsperado, creme.getPreco());

    }

    @Test
    public void testeProtetorSolar() {
        Cosmetico cosmetico = new Cosmetico("Protetor Solar");
        double valorEsperado = 39.90;
        Assertions.assertEquals(valorEsperado, cosmetico.getPreco());
    }
    @Test
    public void testeHidratante() {
        Cosmetico cosmetico = new Cosmetico("Hidratante");
        double valorEsperado = 19.90;
        Assertions.assertEquals(valorEsperado, cosmetico.getPreco());
    }
    @Test
    public void testeOleoDePele() {
        Cosmetico cosmetico = new Cosmetico("Óleo de Pele");
        double valorEsperado = 24.90;
        Assertions.assertEquals(valorEsperado, cosmetico.getPreco());

    }

    @Test
    public void testeGetDescricao() {
        Cosmetico cosmetico = new Cosmetico("Creme para Pele");
        String descricaoEsperada = "Nome do Cosmético: Creme para Pele\nValor: 29.9";
        Assertions.assertEquals(descricaoEsperada, cosmetico.getDescricao());
    }
    @Test
    public void testeExceção() {
        Assertions.assertThrows(ProdutoInvalidoException.class, () -> {
            Cosmetico cosmetico = new Cosmetico("Sabonete");
        });
    }
}
