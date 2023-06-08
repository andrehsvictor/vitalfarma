import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private List<Remedio> remedios = new ArrayList<>();
	private List<Suplemento> suplementos = new ArrayList<>();
	private List<Cosmetico> cosmeticos = new ArrayList<>();
	
	public void adicionarRemedio(String nomeRemedio) {
        Remedio remedio = new Remedio(nomeRemedio);
		this.remedios.add(remedio);
    }
	
	public void adicionarSuplemento(String nomeSuplemento) {
		Suplemento suplemento = new Suplemento(nomeSuplemento);
        this.suplementos.add(suplemento);
    }
	
	public void adicionarCosmetico(String nomeCosmetico) {
        Cosmetico cosmetico = new Cosmetico(nomeCosmetico);
        this.cosmeticos.add(cosmetico);
    }
	
	public void removerRemedioPorNome(String nome) {
        Remedio remedio = (Remedio) procurarProdutoPorNome(nome);
        boolean isRemedioNotNull = (remedio != null);
        
        if(isRemedioNotNull)
        	this.remedios.remove(remedio);
    }
	
	public void removerSuplementoPorNome(String nome) {
        Suplemento suplemento = (Suplemento) procurarProdutoPorNome(nome);
        boolean isSuplementoNotNull = (suplemento != null);
        
        if(isSuplementoNotNull)
        	this.suplementos.remove(suplemento);
    }
	
	public void removerCosmeticoPorNome(String nome) {
		Cosmetico cosmetico = (Cosmetico) procurarProdutoPorNome(nome);
        boolean isCosmeticoNotNull = (cosmetico != null);
        
        if(isCosmeticoNotNull)
        	this.cosmeticos.remove(cosmetico);
    }
	
	public Produto procurarProdutoPorNome(String nome) {
		String nomeFormatado = nome.toUpperCase();
		
		for(Suplemento suplemento : suplementos)
			if(suplemento.getNome().matches(nomeFormatado))
				return suplemento;
		
		for(Cosmetico cosmetico : cosmeticos)
			if(cosmetico.getNome().matches(nomeFormatado))
				return cosmetico;
		
		for(Remedio remedio : remedios)
			if(remedio.getNome().matches(nomeFormatado))
                return remedio;
		
		return null;
	}

	public void exibirProdutos() {
		String labelSuplementos = "---------------- Suplementos";
		String labelCosmeticos = "----------------- Cosmeticos";
		String labelRemedios = "------------------- Remedios";
		
		System.out.println(labelCosmeticos);
		for (Cosmetico cosmetico : cosmeticos)
			cosmetico.exibirDescricao();
		System.out.println(labelSuplementos);
        for (Suplemento suplemento : suplementos)
        	suplemento.exibirDescricao();
        System.out.println(labelRemedios);
        for (Remedio remedio : remedios)
        	remedio.exibirDescricao();
	}
	
}
