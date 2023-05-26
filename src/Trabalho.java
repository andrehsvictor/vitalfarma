import java.util.Date;

public class Trabalho {
	private Date data;
	private int horas;
	
	public Trabalho(Date data, int horas) {
		this.data = data;
		this.horas = horas;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
}
