public class Cosmetico extends Produto {
    public Cosmetico(String nome) {
        super(nome, definirPreco(nome));
    }

    private static double definirPreco(String nome) {
        switch (nome.toLowerCase()) {
            case "creme para pele":
                return 29.90;
            case "hidratante":
                return 19.90;
            case "protetor solar":
                return 39.90;
            case "óleo de pele":
                return 24.90;
            default:
                throw new IllegalArgumentException("Cosmético inválido: " + nome);
        }
    }

    @Override
    public double calcularValor() {
        return getPreco();
    }
}