public class Suplemento extends Produto {

    public enum TipoSuplemento{
        CREATINA("Creatina", 120),
        PROTEINA("Proteina", 95.90),
        VITAMINA("Vitamina", 70.50),
        ÔMEGA3("Ômega 3", 55.40),
        COLÁGENO("Colágeno", 105.00);

        private String nome;
        private double preco;

        TipoSuplemento(String nome, double preco) {
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
    public Suplemento(String nome) {
        super(nome, 0);

        setPreco(calcularValor(nome));
    }

    @Override
    public double calcularValor(String nome) {
        String nomeFormatado = nome.toLowerCase();
        
        Suplemento.TipoSuplemento[] tipos = Suplemento.TipoSuplemento.values();
        
        for (Suplemento.TipoSuplemento tipo : tipos) {
            if (nomeFormatado.equals(tipo.getNome().toLowerCase())) {
                return tipo.getPreco();
            }
        }

        throw new ProdutoInvalidoException("Suplemento inválido: " + getNome());
    }

    @Override
    public String getDescricao() {
        return "Nome do Suplemento: "+ getNome() + "\nValor: " +getPreco();
    }
}