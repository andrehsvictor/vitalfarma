import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VitalFarma implements Serializable {
	private static final long serialVersionUID = 8496667498812511605L;
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

	public void start() {
		exibirLogoDaFarmacia();
		iniciarMenuDeOpcoes();
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

	private void cadastrarCliente(String nome, int idade) {
		if(procurarClientePorNome(nome) == null) {
			Cliente cliente = new Cliente(nome, idade);
			addCliente(cliente);
		}
	}
	
	public void removeCliente(Cliente cliente) {
	    this.clientes.remove(cliente);
	}

	public void removePedido(Pedido pedido) {
	    this.pedidos.remove(pedido);
	}

	private Cliente procurarClientePorNome(String nome) {
		for (Cliente cliente : clientes)
            if (cliente.getNome().equals(nome))
                return cliente;
		
		return null;
	}
	
	private void exibirPedido(Cliente cliente) {
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
    
    private void iniciarCompras() {
    	int opcao;
    	final int COMPRAR_MAIS = 1;
    	final int TERMINAR = 2;
    	final int CANCELAR_COMPRAR = 3;
    	final int SAIR = 4;
    	
    	limparConsole();
		Cliente cliente = processarCliente();
		exibirProdutosDoEstoque();
		adicionarProdutoAoPedido(cliente);
		do {
			String desejaContinuarLabel = "-------- Opcoes --------\n" +
			"1 - Comprar mais\n" +
            "2 - Terminar pedido\n" +
            "3 - Cancelar compra\n" +
            "4 - Sair\n";
			
			System.out.println(desejaContinuarLabel);
			opcao = intInput("-> Digite uma opcao: ");
			
			switch(opcao) {
			case COMPRAR_MAIS:
				limparConsole();
				exibirProdutosDoEstoque();
                adicionarProdutoAoPedido(cliente);
                break;
			case TERMINAR:
				limparConsole();
                System.out.println("[*] - Pedido terminado com sucesso");
                exibirPedido(cliente);
                cliente.realizarCompra();
                break;
            default:
            	System.out.println("[!] - Opcao invalida");
            	break;
			}
			
		} while(opcao != SAIR);
	}

	private void adicionarProdutoAoPedido(Cliente cliente) {
		String nomeDoProdutoDesejado = stringInput("-> Digite o nome do produto: ")
				.toUpperCase();
		Produto produto = procurarProdutoNoEstoque(nomeDoProdutoDesejado);
		boolean produtoDesejadoExisteNoEstoque = nomeDoProdutoDesejado.equals(produto.getNome());
		limparConsole();
		if(produtoDesejadoExisteNoEstoque) {
			cliente.getPedido().addProduto(produto);
			System.out.println("[*] - Produto " + produto.getNome() + " adicionado ao pedido");
		} else {
			System.out.println("[!] - Produto " + nomeDoProdutoDesejado + " nao existe no estoque");
		}
	}

	private Produto procurarProdutoNoEstoque(String nomeDoProduto) {
		return getEstoque().procurarProdutoPorNome(nomeDoProduto);
	}

	private Cliente processarCliente() {
		String nomeCliente = stringInput("Digite seu nome: ")
				.toLowerCase();
		Cliente cliente = procurarClientePorNome(nomeCliente);
		
		if(cliente == null) {
			System.out.println("[!] - Cliente inexistente. Iniciando cadastramento...");
			int idadeCliente = intInput("Digite a idade do cliente: ");
			limparConsole();
			System.out.println("[*] - Cliente cadastrado com sucesso");
			cadastrarCliente(nomeCliente, idadeCliente);
		} else {
			limparConsole();
			System.out.println("[*] - Bem-vindo de volta, " + cliente.getNome() + "! :)");
		}
		
		return procurarClientePorNome(nomeCliente);
	}

	private void iniciarMenuDeOpcoes() {
    	exibirOpcoes();
		int opcao = intInput("-> Digite uma opcao: ");
		final int COMPRAR = 1;
		final int EXIBIR_CLIENTES = 2;
		final int SAIR = 4;
		
		do {
			switch(opcao) {
			case COMPRAR:
				limparConsole();
				iniciarCompras();
				break;
			case EXIBIR_CLIENTES:
				break;
			case SAIR:
				break;
			default:
				limparConsole();
				System.out.println("[!] - Digite uma opcao valida");
				break;
			}
			exibirOpcoes();
			opcao = intInput("Digite uma opcao: ");
		} while(opcao != 4);
	}

	private void exibirOpcoes() {
		System.out.println("------------ MENU DE OPCOES -----------");
        System.out.println("1 - Comprar");
        System.out.println("2 - Exibir Clientes");
        System.out.println("3 - Info");
        System.out.println("4 - Sair");
        System.out.println("---------------------------------------");
	}

	private void exibirProdutosDoEstoque() {
		getEstoque().exibirProdutos();
	}

	private void exibirLogoDaFarmacia() {
		String logo =
	            "                                                                                       \n" +
	            ",--.   ,--.,--.  ,--.          ,--.,------.                                 \n" +
	            " \\  `.'  / `--',-'  '-. ,--,--.|  ||  .---',--,--.,--.--.,--,--,--. ,--,--. \n" +
	            "  \\     /  ,--.'-.  .-'' ,-.  ||  ||  `--,' ,-.  ||  .--'|        |' ,-.  | \n" +
	            "   \\   /   |  |  |  |  \\ '-'  ||  ||  |`  \\ '-'  ||  |   |  |  |  |\\ '-'  | \n" +
	            "    `-'    `--'  `--'   `--`--'`--'`--'    `--`--'`--'   `--`--`--' `--`--' \n" +
	            "                                                                           \n";

	        System.out.println(logo);

	}

	private void limparConsole() {
    	for(int i = 0; i < 100; i++) System.out.println();
    }

	private String stringInput(String label) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(label);
		String line = scanner.nextLine().strip();
		return line;
	}

	private int intInput(String label) {
		Scanner scanner = new Scanner(System.in);
	    System.out.print(label);
	    int integer = scanner.nextInt();
	    return integer;
	}
}
