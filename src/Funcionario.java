import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {
	private double salario;
	private Trabalho trabalho;
	private int horasTrabalhadas;
	private List<Venda> vendasFeitas = new ArrayList<>();
	
	public Funcionario(double salario, int horasTrabalhadas, String nome, int idade) {
		super(nome, idade);
		Date dataDeHoje = Date.from(Instant.now());
		trabalho = new Trabalho(dataDeHoje, horasTrabalhadas);
		this.salario = salario;
		this.horasTrabalhadas = trabalho.getHoras();
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public List<Venda> getVendasFeitas() {
		return vendasFeitas;
	}

	public void setVendasFeitas(List<Venda> vendasFeitas) {
		this.vendasFeitas = vendasFeitas;
	}

}
