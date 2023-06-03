import java.util.HashMap;
import java.util.Map;

public abstract class Produto implements IProduto {
    private String nome;
    private double preco;
    private static Map<String, Double> mapDePrecos = new HashMap<String, Double>();
    
    public Produto(String nome) {
        this.nome = nome;
        calcularPreco(nome);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public static Map<String, Double> getMapDePrecos() {
        return mapDePrecos;
    }
    
    public void setMapDePrecos(Map<String, Double> mapDePrecos) {
        Produto.mapDePrecos = mapDePrecos;
    }
    
    public boolean calcularPreco(String nomeProduto) {
    	String nomeFormatado = nomeProduto.toUpperCase();
    	if (mapDePrecos.containsKey(nomeFormatado)) {
    		setPreco(mapDePrecos.get(nomeFormatado));
            return true;
        } else {
            return false;
        }
    }
}
