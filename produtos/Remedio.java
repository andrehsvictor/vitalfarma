import java.util.HashMap;
import java.util.Map;

public class Remedio extends Produto {
	private static final Map<String, Double> MAP_DE_PRECOS = new HashMap<>();

	public Remedio(String nome, double preco) {
		super(nome, preco);
		setPreco(nome);
	}

	@Override
	public boolean setPreco(String nomeRemedio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescricao() {
		return "Nome do Remédio: " + getNome() + "/nPreço: " + getPreco();
	}

}
