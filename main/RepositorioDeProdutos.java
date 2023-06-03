import java.util.ArrayList;
import java.util.List;

public class RepositorioDeProdutos {
	private List<Remedio> remedios = new ArrayList<>();
	private List<Suplemento> suplementos = new ArrayList<>();
	private List<Cosmetico> cosmeticos = new ArrayList<>();
	
	public List<Remedio> getRemedios() {
        return remedios;
    }
	
	public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
    }
	
	public List<Suplemento> getSuplementos() {
        return suplementos;
    }
	
	public void setSuplementos(List<Suplemento> suplementos) {
        this.suplementos = suplementos;
    }
	
	public List<Cosmetico> getCosmeticos() {
        return cosmeticos;
    }
	
	public void setCosmeticos(List<Cosmetico> cosmeticos) {
        this.cosmeticos = cosmeticos;
    }
	
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

	}
}
