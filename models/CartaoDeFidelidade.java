import java.io.Serializable;
import java.time.LocalDate;

public class CartaoDeFidelidade implements Serializable {
	private static final long serialVersionUID = 3640998671215688011L;
	private int qtdCompras;
	private boolean clienteRecorrente;
	private LocalDate comprasNoMes;

	public CartaoDeFidelidade() {
		this.qtdCompras = 0;
        this.clienteRecorrente = false;
        this.comprasNoMes = LocalDate.now();
	}

	public int getQtdCompras() {
		return qtdCompras;
	}

	public boolean isClienteRecorrente() {
		return (qtdCompras >= 5) ? true : false;
	}

	public void setQtdCompras(int qtdCompras) {
		this.qtdCompras = qtdCompras;
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