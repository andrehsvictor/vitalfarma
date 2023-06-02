import java.time.LocalDate;
import java.time.Month;

public class Cliente {
	private String nome;
	private int idade;
	private String email;
	private int qtdCompras;
	private boolean clienteRecorrente;
	private boolean idoso;
	private LocalDate comprasNoMes;
	
	public Cliente(String nome, int idade, String email) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		qtdCompras = 0;
		clienteRecorrente = false;
		idoso = (idade >= 60) ? true : false;
		comprasNoMes = null;
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
	
	public String getEmail() {
        return email;
    }
	
	public void setEmail(String email) {
        this.email = email;
    }
	
	public int getQtdCompras() {
        return qtdCompras;
    }
	
	public void setQtdCompras(int qtdCompras) {
        this.qtdCompras = qtdCompras;
    }
	
	public boolean isClienteRecorrente() {
        return clienteRecorrente;
    }
	
	public void setClienteRecorrente(boolean clienteRecorrente) {
        this.clienteRecorrente = clienteRecorrente;
    }
	
	public boolean isIdoso() {
		return idoso;
	}

	public void setIdoso(boolean idoso) {
		this.idoso = idoso;
	}

	public LocalDate getComprasNoMes() {
        return comprasNoMes;
    }
	
	public void setComprasNoMes(LocalDate comprasNoMes) {
        this.comprasNoMes = comprasNoMes;
    }
	
	public void realizarCompra(Pedido pedido) {
		LocalDate dataAtual = LocalDate.now();
		Month mesAtual = dataAtual.getMonth(),
				comprasNoMesMonth = comprasNoMes.getMonth();
		
		boolean isComprasNoMesNull = (comprasNoMes == null),
				areComprasNoMesMonthAndMesAtualDifferent = (comprasNoMesMonth != mesAtual);
		
		if (isComprasNoMesNull || areComprasNoMesMonthAndMesAtualDifferent) {
			incrementarQtdCompras();
        	comprasNoMes = dataAtual;
		} else {
			incrementarQtdCompras();
		}
		
		if(qtdCompras >= 5)
			clienteRecorrente = true;
	}

	private void incrementarQtdCompras() {
		qtdCompras++;
	}
	
	public double calcularDesconto(double valorTotal) {
		final double descontoClienteRecorrente = valorTotal * 0.3,
				descontoIdoso = valorTotal * 0.5;
	
		valorTotal -= clienteRecorrente ? descontoClienteRecorrente : 0;
		valorTotal -= idoso ? descontoIdoso : 0;
		
		return valorTotal;
	}
}
