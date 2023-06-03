import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private List<Remedio> remedios = new ArrayList<>();
	private List<Suplemento> suplementos = new ArrayList<>();
	private List<Cosmetico> cosmeticos = new ArrayList<>();
	
	public void adicionarRemedio(Remedio remedio) {
        this.remedios.add(remedio);
    }
	
	public void adicionarSuplemento(Suplemento suplemento) {
        this.suplementos.add(suplemento);
    }
	
	public void adicionarCosmetico(Cosmetico cosmetico) {
        this.cosmeticos.add(cosmetico);
    }
	
	public void removerRemedio(Remedio remedio) {
        this.remedios.remove(remedio);
    }
	
	public void removerSuplemento(Suplemento suplemento) {
        this.suplementos.remove(suplemento);
    }
	
	public void removerCosmetico(Cosmetico cosmetico) {
        this.cosmeticos.remove(cosmetico);
    }

	public void listarProdutos() {
		for (Cosmetico cosmetico : cosmeticos)
			System.out.println(cosmetico.getDescricao());
        for (Suplemento suplemento : suplementos)
        	System.out.println(suplemento.getDescricao());
	}
}
