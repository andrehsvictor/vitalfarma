import java.util.HashMap;
import java.util.Map;

public class Suplemento extends Produto {
	private static final Map<String, Double> MAP_DE_PRECOS = new HashMap<>();
	
	static {
		MAP_DE_PRECOS.put("CREATINA", 120.00);
		MAP_DE_PRECOS.put("PROTEINA", 95.90);
		MAP_DE_PRECOS.put("VITAMINA", 70.50);
        MAP_DE_PRECOS.put("OMEGA 3", 55.40);
        MAP_DE_PRECOS.put("COLAGENO", 105.00);
	}
	
	public Suplemento(String nome) {
        super(nome, 0);
        setPreco(nome);
    }

    @Override
    public boolean setPreco(String nomeSuplemento) {
        String nomeFormatado = nomeSuplemento.toUpperCase();
        
        for (String nomeProduto : MAP_DE_PRECOS.keySet())
            if (nomeFormatado.equals(nomeProduto)) {
            	double preco = MAP_DE_PRECOS.get(nomeFormatado);
            	this.setPreco(preco);
                return true;
            }

        throw new ProdutoInvalidoException("Suplemento inválido: " + getNome());
    }

    @Override
    public String getDescricao() {
        return "Nome do Suplemento: "+ getNome() + "\nPreço: " +getPreco();
    }
}