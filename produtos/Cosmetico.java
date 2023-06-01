import java.util.HashMap;
import java.util.Map;

public class Cosmetico extends Produto {
    private static final Map<String, Double> NOME_E_PRECO_MAP = new HashMap<>();

    static {
        NOME_E_PRECO_MAP.put("CREME PARA PELE", 29.90);
        NOME_E_PRECO_MAP.put("HIDRATANTE", 19.90);
        NOME_E_PRECO_MAP.put("PROTETOR SOLAR", 39.90);
        NOME_E_PRECO_MAP.put("OLEO DE PELE", 24.90);
    }

    public Cosmetico(String nome) {
        super(nome, 0);
        setPreco(nome);
    }

    @Override
    public boolean setPreco(String nomeCosmetico) {
        String nomeFormatado = nomeCosmetico.toUpperCase();

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

