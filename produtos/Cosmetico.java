import java.util.HashMap;
import java.util.Map;

public class Cosmetico extends Produto {
    private static final Map<String, Double> NOME_E_PRECO_MAP = new HashMap<>();

    static {
        NOME_E_PRECO_MAP.put("Creme para Pele", 29.90);
        NOME_E_PRECO_MAP.put("Hidratante", 19.90);
        NOME_E_PRECO_MAP.put("Protetor Solar", 39.90);
        NOME_E_PRECO_MAP.put("Óleo de Pele", 24.90);

    }

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

        setPreco(calcularPreco(nome));
    }

    /*
     * TODO Mude esse calcularPreco()
     * 		para setPreco(String nomeCosmetico)
     */
    @Override
    public double calcularPreco(String nome) {
        String nomeFormatado = nome.toLowerCase();

        for (TipoCosmetico tipo : TipoCosmetico.values()) {
            if (nomeFormatado.equals(tipo.getNome().toLowerCase())) {
                return tipo.getPreco();
            }
        }

        throw new ProdutoInvalidoException("Cosmético inválido: " + getNome());

    }

    @Override
    public String getDescricao() {
        return "Nome do Cosmético: "+ getNome() + "\nValor: " +getPreco();
    }

}
