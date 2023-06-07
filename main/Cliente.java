import java.time.LocalDate;
import java.time.Month;

public class Cliente {
	private String nome;
	private int idade;
	private CartaoDeFidelidade cartaoDeFidelidade = new CartaoDeFidelidade();

	public Cliente(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		cartaoDeFidelidade.setQtdCompras(0);
		cartaoDeFidelidade.setClienteRecorrente(false);
		cartaoDeFidelidade.setComprasNoMes(null);
	}

	public String getNome() {
        return nome;
    }
	
	public void setNome(String nome) {
        this.nome = nome;
    }
	
	public int getIdade() {
        return idade;
    }
	
	public void setIdade(int idade) {
        this.idade = idade;
    }
	
	public int getQtdCompras() {
        return cartaoDeFidelidade.getQtdCompras();
    }
	
	public void setQtdCompras(int qtdCompras) {
        this.cartaoDeFidelidade.setQtdCompras(qtdCompras);
    }
	
	public boolean isClienteRecorrente() {
        return cartaoDeFidelidade.isClienteRecorrente();
    }
	
	public void setClienteRecorrente(boolean clienteRecorrente) {
        this.cartaoDeFidelidade.setClienteRecorrente(clienteRecorrente);
    }

	public LocalDate getComprasNoMes() {
        return cartaoDeFidelidade.getComprasNoMes();
    }
	
	public void setComprasNoMes(LocalDate comprasNoMes) {
        this.cartaoDeFidelidade.setComprasNoMes(comprasNoMes);
    }
	
	public void realizarCompra(Pedido pedido) {
		LocalDate dataAtual = LocalDate.now();
		
		Month mesAtual = dataAtual.getMonth();
		Month comprasNoMesMonth = cartaoDeFidelidade.getComprasNoMes().getMonth();
		
		boolean isComprasNoMesNull = (cartaoDeFidelidade.getComprasNoMes() == null);
		boolean areComprasNoMesMonthAndMesAtualDifferent = (comprasNoMesMonth != mesAtual);
		
		incrementarQtdCompras();
		
		if (isComprasNoMesNull || areComprasNoMesMonthAndMesAtualDifferent)
        	cartaoDeFidelidade.setComprasNoMes(dataAtual);
		
		if(cartaoDeFidelidade.getQtdCompras() >= 5)
			cartaoDeFidelidade.setClienteRecorrente(true);
	}

	private void incrementarQtdCompras() {
		cartaoDeFidelidade.setQtdCompras(cartaoDeFidelidade.getQtdCompras() + 1);
	}
	
	public double calcularDesconto(double valorTotal) {
		final double DESCONTO_CLIENTE_RECORRENTE = valorTotal * 0.3;
		final double DESCONTO_IDOSO = valorTotal * 0.5;
		double descontoTotal = 0;
	
		descontoTotal += (cartaoDeFidelidade.isClienteRecorrente()) ? DESCONTO_CLIENTE_RECORRENTE : 0;
		descontoTotal += (idade >= 60) ? DESCONTO_IDOSO : 0;
		valorTotal -= descontoTotal;
		
		return valorTotal;
	}
}
