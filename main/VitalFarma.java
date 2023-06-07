import java.util.ArrayList;
import java.util.List;

public class VitalFarma {
	private List<Cliente> clientes = new ArrayList<>();
	private List<Pedido> pedidos = new ArrayList<>();
	private Estoque estoque = new Estoque();
	
	{
		estoque.adicionarSuplemento("CREATINA");
		estoque.adicionarSuplemento("PROTEINA");
		estoque.adicionarSuplemento("VITAMINA");
		estoque.adicionarSuplemento("OMEGA 3");
		estoque.adicionarSuplemento("COLAGENO");
		
		estoque.adicionarCosmetico("CREME PARA PELE");
		estoque.adicionarCosmetico("HIDRATANTE");
		estoque.adicionarCosmetico("PROTETOR SOLAR");
		estoque.adicionarCosmetico("OLEO DE PELE");
		
		estoque.adicionarRemedio("NEOSALDINA");
        estoque.adicionarRemedio("ENGOV");
       	estoque.adicionarRemedio("DORIL");
        estoque.adicionarRemedio("DIPIRONA");
        estoque.adicionarRemedio("RIVOTRIL");
        estoque.adicionarRemedio("NEOSORO");
        estoque.adicionarRemedio("HISTAMIN");
        estoque.adicionarRemedio("LOSARTANA ");
	}
	
	public VitalFarma() {
		iniciar();
    }

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Pedido> getPedidos() {
        return pedidos;
    }
	
	public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
	
	public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
	
	public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
	
	public void removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }
	
	public void removePedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
	
	public Estoque getEstoque() {
        return estoque;
    }
	
	public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
	
	public void iniciar() {
		exibirSloganDaFarmacia();
		getEstoque().listarProdutos();
	}
	
	private void exibirSloganDaFarmacia() {
		final String SLOGAN = 
				"-------------------" + "\n" +
				"    VITALFARMA" + "\n" +
				"-------------------" + "\n";
		
		System.out.println(SLOGAN);
	}

}
