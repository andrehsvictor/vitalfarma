public class Cosmetico extends Produto {

    private String nome;

    public enum TipoCosmetico {
        CREME_PARA_PELE("Creme para Pele", 29.90),
        HIDRATANTE("Hidratante", 19.90),
        PROTETOR_SOLAR("Protetor Solar", 39.90),
        OLEO_DE_PELE("Óleo de Pele", 24.90);

        private String nome;
        private double preco;

        TipoCosmetico(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }
    }

    public Cosmetico(String nome) {
        super(nome, 0);
        this.nome = nome;
        setPreco(calcularValor(nome));
    }

    @Override
    public double calcularValor(String nome) {
        String nomeFormatado = this.nome.toLowerCase();

        for (TipoCosmetico tipo : TipoCosmetico.values()) {
            if (nomeFormatado.equals(tipo.getNome().toLowerCase())) {
                return tipo.getPreco();
            }
        }

        throw new ProdutoInvalidoException("Cosmético inválido: " + this.nome);

    }

    @Override
    public String getDescricao() {
        return "Nome do Cosmético: "+ getNome() + "\nValor: " +getPreco();
    }

}
