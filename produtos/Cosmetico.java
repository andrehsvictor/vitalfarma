public class Cosmetico extends Produto implements Serializable {

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

