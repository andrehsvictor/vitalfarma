import java.util.ArrayList;
import java.util.List;

public class VitalFarma {
	private List<Cliente> clientes = new ArrayList<>();
	private List<Pedido> pedidos = new ArrayList<>();
	private Estoque estoque = new Estoque();
	
	{
		estoque.adicionarSuplemento(new Suplemento("Creatina"));
		estoque.adicionarSuplemento(new Suplemento("Proteina"));
		estoque.adicionarSuplemento(new Suplemento("Vitamina"));
		estoque.adicionarSuplemento(new Suplemento("Omega 3"));
		estoque.adicionarSuplemento(new Suplemento("Colageno"));
		
		estoque.adicionarCosmetico(new Cosmetico("Creme para pele"));
		estoque.adicionarCosmetico(new Cosmetico("Hidratante"));
		estoque.adicionarCosmetico(new Cosmetico("Protetor solar"));
		estoque.adicionarCosmetico(new Cosmetico("Oleo de pele"));
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

}
