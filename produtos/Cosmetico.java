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

    public Cosmetico(String nome) {
        super(nome, 0);
    }

    @Override
    public boolean setPreco(String nomeProdutoArg) {
        String nomeFormatado = nomeProdutoArg.toUpperCase();

        for (String nomeProduto : NOME_E_PRECO_MAP.keySet())
            if (nomeFormatado.equals(nomeProduto)) {
                double preco = NOME_E_PRECO_MAP.get(nomeFormatado);
                this.setPreco(preco);
                return true;
            }

        throw new ProdutoInvalidoException("Cosmético inválido: " + getNome());
    }

    @Override
    public String getDescricao() {
        return "Nome do Cosmético: " + getNome() + "\nValor: " + getPreco();
    }
}

