public class Suplemento extends Produto {
	
	static {
		getMapDePrecos().put("CREATINA", 120.00);
		getMapDePrecos().put("PROTEINA", 95.90);
		getMapDePrecos().put("VITAMINA", 70.50);
		getMapDePrecos().put("OMEGA 3", 55.40);
		getMapDePrecos().put("COLAGENO", 105.00);
	}
	
	public Suplemento(String nome) {
        super(nome);
    }

    @Override
    public String getDescricao() {
        return "Nome do Suplemento: "+ getNome() + "\nPreço: " +getPreco();
    }

}