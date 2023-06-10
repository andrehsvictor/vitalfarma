public class Remedio extends Produto implements Serializable {

    static {
        getMapaDePrecos().put("NEOSALDINA", 22.90);
        getMapaDePrecos().put("ENGOV", 19.75);
        getMapaDePrecos().put("DORIL", 39.90);
        getMapaDePrecos().put("DIPIRONA", 12.10);
        getMapaDePrecos().put("RIVOTRIL", 14.70);
        getMapaDePrecos().put("NEOSORO", 6.70);
        getMapaDePrecos().put("HISTAMIN", 8.70);
        getMapaDePrecos().put("LOSARTANA", 32.70);
    }
    
    public Remedio(String nome) {
            super(nome);
    }

	public boolean isSujeitoAPrescricao(String nomeDoRemedio) {
		switch (nomeDoRemedio) {
		case "RIVOTRIL":
			return true;
		case "LOSARTANA":
			return true;
		case "NEOSORO":
			return true;
		default:
			return false;
		}
	}
}
