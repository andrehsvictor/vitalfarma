import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuplementoTest {

	@Test
	void testSuplemento() {
		Suplemento s = new Suplemento("Colageno");
		double preco = s.getPreco();
		assertEquals(105.00, preco);
	}

}
