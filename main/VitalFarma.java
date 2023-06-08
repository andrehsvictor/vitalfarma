import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        estoque.adicionarRemedio("LOSARTANA");
	}
	
	public VitalFarma() {
		start();
    }

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Pedido> getPedidos() {
	    return pedidos;
	}

	public Estoque getEstoque() {
	    return estoque;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
	
	public void setEstoque(Estoque estoque) {
	    this.estoque = estoque;
	}

	public void addCliente(Cliente cliente) {
	    this.clientes.add(cliente);
	}

	public void addPedido(Pedido pedido) {
	    this.pedidos.add(pedido);
	}

	public void adicionarCliente(String nome, int idade) {
		if(procurarClientePorNome(nome) == null) {
			Cliente cliente = new Cliente(nome, idade);
			addCliente(cliente);
		};
	}
	
	public void removeCliente(Cliente cliente) {
	    this.clientes.remove(cliente);
	}

	public void removePedido(Pedido pedido) {
	    this.pedidos.remove(pedido);
	}

	public Cliente procurarClientePorNome(String nome) {
		for (Cliente cliente : clientes)
            if (cliente.getNome().equals(nome))
                return cliente;
		
		return null;
	}
	
	private void start() {
		exibirSloganDaFarmacia();
		getEstoque().exibirProdutos();
		Scanner sc = new Scanner(System.in);
		String nomeDoProdutoDesejado = sc.nextLine().toUpperCase();
		Produto produtoDesejado = getEstoque().procurarProdutoPorNome(nomeDoProdutoDesejado);
		
		if(nomeDoProdutoDesejado.equals(produtoDesejado.getNome())) {
			String nomeCliente = sc.nextLine()
					.toUpperCase()
                    .strip();
			int idadeCliente = sc.nextInt();
			
			adicionarCliente(nomeCliente, idadeCliente);
			
			Cliente cliente = procurarClientePorNome(nomeCliente);
			cliente.getPedido().addProduto(produtoDesejado);
			limparConsole();
			exibirPedido(cliente);
			cliente.realizarCompra();
			
		}
		
		
	}
	
	public void exibirPedido(Cliente cliente) {
        System.out.println("---------- PEDIDO VITALFARMA ----------");
        System.out.println("Data e Hora do Pedido: " + cliente.dataDoPedidoToString());
        System.out.println("Produtos:");
        for (Produto produto : cliente.getPedido().getProdutos()) {
            produto.exibirDescricao();
        }
        System.out.println("Valor Total: " + cliente.calcularValorTotal());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("---------------------------------------");
    }
    
    private void exibirSloganDaFarmacia() {
		final String SLOGAN = "- V I T A L F A R M A -" + "\n";
		System.out.println(SLOGAN);
	}

	private void limparConsole() {
    	for(int i = 0; i < 100; i++) System.out.println();
    }
}
