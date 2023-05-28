import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CosmeticoTest {
	
	@Test
	void testCalcularValor() {
		Cosmetico cosmetico = new Cosmetico("Hidratante");
		double preco = cosmetico.calcularValor();
		assertEquals(19.90, preco);
	}

	@Test
	void testCosmetico() {
		fail("Not yet implemented");
	}

}
