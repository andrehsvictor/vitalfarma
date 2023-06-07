import java.time.LocalDate;

public class CartaoDeFidelidade {
	private int qtdCompras;
	private boolean clienteRecorrente;
	private LocalDate comprasNoMes;

	public CartaoDeFidelidade() {
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

	public LocalDate getComprasNoMes() {
		return comprasNoMes;
	}

	public void setComprasNoMes(LocalDate comprasNoMes) {
		this.comprasNoMes = comprasNoMes;
	}
}