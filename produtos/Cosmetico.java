import java.io.Serializable;

public class Cosmetico extends Produto implements Serializable {
	
	private static final long serialVersionUID = 5509994527016343751L;

	static {
        getMapaDePrecos().put("CREME PARA PELE", 29.90);
        getMapaDePrecos().put("HIDRATANTE", 19.90);
        getMapaDePrecos().put("PROTETOR SOLAR", 39.90);
        getMapaDePrecos().put("OLEO DE PELE", 24.90);
    }

    public Cosmetico(String nome) {
        super(nome);
        calcularPreco(nome);
    }
}

