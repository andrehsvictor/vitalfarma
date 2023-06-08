import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Cliente {
	private String nome;
	private int idade;
	private CartaoDeFidelidade cartaoDeFidelidade;
	private Pedido pedido;

	public Cliente(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		cartaoDeFidelidade = new CartaoDeFidelidade();
		pedido = new Pedido();
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
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void realizarCompra() {
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
		
		System.out.println("Compra realizada com sucesso");
	}

	private void incrementarQtdCompras() {
		cartaoDeFidelidade.setQtdCompras(cartaoDeFidelidade.getQtdCompras() + 1);
	}
	
	private double calcularDesconto(double valorTotal) {
		final double DESCONTO_CLIENTE_RECORRENTE = valorTotal * 0.3;
		final double DESCONTO_IDOSO = valorTotal * 0.5;
		double descontoTotal = 0;
	
		descontoTotal += (cartaoDeFidelidade.isClienteRecorrente()) ? DESCONTO_CLIENTE_RECORRENTE : 0;
		descontoTotal += (idade >= 60) ? DESCONTO_IDOSO : 0;
		valorTotal -= descontoTotal;
		
		return valorTotal;
	}
	
	public String dataDoPedidoToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return pedido.getDataHora().format(formatter);
    }
	
    public String calcularValorTotal() {
    	double valorTotal = 0;
    	
        for (Produto produto : pedido.getProdutos())
            valorTotal += produto.getPreco();
        
        double valorDescontado = calcularDesconto(valorTotal);
        pedido.setValorTotal(valorDescontado);
        
		String stringValorDescontado = String.format("R$ %.2f", valorDescontado) + " (Com desconto)";
		String stringValorTotal = String.format("R$ %.2f", valorTotal);
        
		return temDesconto() ? stringValorDescontado : stringValorTotal;
    }

	private boolean temDesconto() {
		double valorTotal = pedido.getValorTotal();
		double valorDescontado = calcularDesconto(valorTotal);
		
		return valorDescontado != valorTotal;
	}
    
}
