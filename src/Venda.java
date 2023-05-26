import java.util.Date;

public class Venda {
	private Produto produtoVendido;
	private Date data;
	private Funcionario funcionario;
	
	public Venda(Produto produtoVendido, Date data, Funcionario funcionario) {
		this.produtoVendido = produtoVendido;
		this.data = data;
		this.funcionario = funcionario;
	}
	
	public Produto getProdutoVendido() {
		return produtoVendido;
	}
	public void setProdutoVendido(Produto produtoVendido) {
		this.produtoVendido = produtoVendido;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
