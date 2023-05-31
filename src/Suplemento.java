public class Suplemento extends Produto {
    public Suplemento(String nome) {
        super(nome, definirPreco(nome));
    }

    private static double definirPreco(String nome) {
        switch (nome.toLowerCase()) {
            case "creatina":
                return 120.00;
            case "proteina":
                return 99.99;
            case "vitamina":
                return 70.60;
            case "ômega 3":
                return 55.30;
            case "colágeno":
                return 105.00;
            default:
                throw new IllegalArgumentException("Supremento inválido: " + nome);
        }
    }

    @Override
    public double calcularValor() {
        return getPreco();
    }
}