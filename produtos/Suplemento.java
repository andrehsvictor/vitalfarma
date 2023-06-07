public class Suplemento extends Produto {
	
	static {
		getMapaDePrecos().put("CREATINA", 120.00);
		getMapaDePrecos().put("PROTEINA", 95.90);
		getMapaDePrecos().put("VITAMINA", 70.50);
		getMapaDePrecos().put("OMEGA 3", 55.40);
		getMapaDePrecos().put("COLAGENO", 105.00);
	}
	
	public Suplemento(String nome) {
        super(nome);
    }

}