import java.util.HashMap;
import java.util.Map;

public abstract class Produto {
    private String nome;
    private double preco;
    private static Map<String, Double> mapaDePrecos = new HashMap<String, Double>();
    
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
        return mapaDePrecos;
    }
    
    public void setMapDePrecos(Map<String, Double> mapDePrecos) {
        Produto.mapaDePrecos = mapDePrecos;
    }
    
    public boolean calcularPreco(String nomeProduto) {
    	String nomeFormatado = nomeProduto.toUpperCase();
    	if (mapaDePrecos.containsKey(nomeFormatado)) {
    		setPreco(mapaDePrecos.get(nomeFormatado));
            return true;
        } else {
            return false;
        }
    }
    
    public String getDescricao() {
    	return getNome() + " R$ " + getPreco();
    }
}
