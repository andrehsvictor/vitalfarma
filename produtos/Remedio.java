public class Remedio extends Produto {

	public Remedio(String nome) {
		super(nome);
		calcularPreco(nome);
	}

	@Override
	public boolean calcularPreco(String nomeRemedio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescricao() {
		return "Nome do Remédio: " + getNome() + "/nPreço: " + getPreco();
	}

}
