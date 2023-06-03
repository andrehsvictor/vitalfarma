public class Cosmetico extends Produto {

    static {
        getMapDePrecos().put("CREME PARA PELE", 29.90);
        getMapDePrecos().put("HIDRATANTE", 19.90);
        getMapDePrecos().put("PROTETOR SOLAR", 39.90);
        getMapDePrecos().put("OLEO DE PELE", 24.90);
    }

    public Cosmetico(String nome) {
        super(nome);
        calcularPreco(nome);
    }

    @Override
    public String getDescricao() {
        return "Nome do Cosmético: " + getNome() + "\nPreço: " + getPreco();
    }
}

