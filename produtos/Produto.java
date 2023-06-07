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
    
    public static Map<String, Double> getMapaDePrecos() {
        return mapaDePrecos;
    }
    
    public static void setMapaDePrecos(Map<String, Double> mapDePrecos) {
        Produto.mapaDePrecos = mapDePrecos;
    }
    
    public boolean calcularPreco(String nomeDoProduto) {
    	String nomeDoProdutoFormatado = nomeDoProduto.toUpperCase();
    	if (mapaDePrecos.containsKey(nomeDoProdutoFormatado)) {
    		setPreco(mapaDePrecos.get(nomeDoProdutoFormatado));
            return true;
        } else {
        	throw new ProdutoInvalidoException("Produto invalido: " + nomeDoProdutoFormatado);
        }
    }
    
    public String getDescricao() {
    	return getNome() + " R$" + getPreco();
    }
}
