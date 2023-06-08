import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private double valorTotal;
    private LocalDateTime dataHora;
    
    public Pedido() {
        this.produtos = new ArrayList<>();
        this.valorTotal = 0.0;
        dataHora = LocalDateTime.now();
    }

    public List<Produto> getProdutos() {
		return produtos;
	}
    
	public double getValorTotal() {
        return this.valorTotal;
    }
	
	public LocalDateTime getDataHora() {
        return dataHora;
    }

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
	
	public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        produtos.remove(produto);
    }
}