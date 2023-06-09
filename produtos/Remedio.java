public class Remedio extends Produto {

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
    
    @Override
    public void exibirDescricao() {
    	String tarja = "[Sujeito a prescricao medica]";
    	
    	if(isSujeitoAPrescricao(getNome()))
    		System.out.printf("%-20s R$%.2f %s%n", getNome(), getPreco(), tarja);
    	else
    		super.exibirDescricao();;
    }

	private boolean isSujeitoAPrescricao(String nomeDoRemedio) {
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
