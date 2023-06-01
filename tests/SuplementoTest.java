import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuplementoTest {

	@Test
	void testSuplemento() {
		Suplemento s = new Suplemento("Vitamina");
		double precoAtual = s.getPreco();
		double precoEsperado = 70.50;
		assertEquals(precoEsperado, precoAtual);
	}

}
