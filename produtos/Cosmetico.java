import java.util.HashMap;
import java.util.Map;

public class Cosmetico extends Produto {
    private static final Map<String, Double> MAP_DE_PRECOS = new HashMap<>();

    static {
        MAP_DE_PRECOS.put("CREME PARA PELE", 29.90);
        MAP_DE_PRECOS.put("HIDRATANTE", 19.90);
        MAP_DE_PRECOS.put("PROTETOR SOLAR", 39.90);
        MAP_DE_PRECOS.put("OLEO DE PELE", 24.90);
    }

    public Cosmetico(String nome) {
        super(nome, 0);
        setPreco(nome);
    }

    @Override
    public boolean setPreco(String nomeCosmetico) {
        String nomeFormatado = nomeCosmetico.toUpperCase();

        for (String nomeProduto : MAP_DE_PRECOS.keySet())
            if (nomeFormatado.equals(nomeProduto)) {
                double preco = MAP_DE_PRECOS.get(nomeFormatado);
                this.setPreco(preco);
                return true;
            }

        throw new ProdutoInvalidoException("Cosmético inválido: " + getNome());
    }

    @Override
    public String getDescricao() {
        return "Nome do Cosmético: " + getNome() + "\nPreço: " + getPreco();
    }
}

