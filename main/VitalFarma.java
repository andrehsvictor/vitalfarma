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

	public void iniciar() {
		exibirLogoDaFarmacia();
		iniciarMenuDeOperacoes();
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

	public void cadastrarCliente(String nome, int idade) {
		if(procurarClientePorNome(nome) == null) {
			Cliente cliente = new Cliente(nome, idade);
			addCliente(cliente);
		}
	}

	public Cliente procurarClientePorNome(String nome) {
		for (Cliente cliente : clientes)
            if (cliente.getNome().equals(nome))
                return cliente;
		
		return null;
	}
	
	public void iniciarCompras() {
    	int opcao;
    	final int COMPRAR_MAIS = 1;
    	final int TERMINAR = 2;
    	final int CANCELAR_COMPRA = 3;
    	final int SAIR = 4;
    	
    	limparConsole();
    	
		Cliente cliente = processarCliente();
		exibirProdutosDoEstoque();
		adicionarProdutoAoPedido(cliente);
		
		do {
			exibirOpcoesCompras();
			opcao = intInput("-> Digite uma opcao: ");
			
			switch(opcao) {
			case COMPRAR_MAIS:
				limparConsole();
				exibirProdutosDoEstoque();
                adicionarProdutoAoPedido(cliente);
                break;
			case TERMINAR:
				limparConsole();
                terminarPedido(cliente);
                break;
			case CANCELAR_COMPRA:
				limparConsole();
				exibirLogoDaFarmacia();
                System.out.println("[*] - Compra cancelada com sucesso");
                break;
			case SAIR:
				System.exit(0);
            default:
            	exibirMensagemDeErro("Opcao invalida");
            	break;
			}
		} while(opcao != SAIR && opcao != CANCELAR_COMPRA);
	}

	public void iniciarMenuDeOperacoes() {
		exibirOperacoes();
		int opcao = intInput("-> Digite uma opcao: ");
		final int COMPRAR = 1;
		final int EXIBIR_CLIENTES = 2;
		final int INFO = 3;
		final int SAIR = 4;

		do {
			switch(opcao) {
			case COMPRAR:
				limparConsole();
				iniciarCompras();
				break;
			case EXIBIR_CLIENTES:
				break;
			case INFO:
				break;
			case SAIR:
				System.exit(0);
				break;
			default:
				limparConsole();
				exibirLogoDaFarmacia();
				exibirMensagemDeErro("Opcao invalida!");
				break;
			}
			exibirOperacoes();
			opcao = intInput("Digite uma opcao: ");
		} while(opcao != 4);
	}

	public void adicionarProdutoAoPedido(Cliente cliente) {
		String nomeDoProdutoDesejado = stringInput("-> Digite o nome do produto: ")
				.toUpperCase();
		Produto produto = procurarProdutoNoEstoque(nomeDoProdutoDesejado);
		limparConsole();
		if(produto != null) {
			cliente.getPedido().addProduto(produto);
			System.out.println("[*] - Produto " + produto.getNome() + " adicionado ao pedido");
		} else {
			exibirMensagemDeErro("Produto " + nomeDoProdutoDesejado + " nao existe no estoque");
		}
	}

	public Produto procurarProdutoNoEstoque(String nomeDoProduto) {
		return getEstoque().procurarProdutoPorNome(nomeDoProduto);
	}

	public Cliente processarCliente() {
		String nomeCliente = stringInput("Digite seu nome: ")
				.toLowerCase();
		Cliente cliente = procurarClientePorNome(nomeCliente);
		
		if(cliente == null) {
			exibirMensagemDeErro("Cliente inexistente. Iniciando cadastramento...");
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

	private void exibirOpcoesCompras() {
		String opcoes = "---------------- OPCOES ---------------\n" +
		"1 - Comprar mais\n" +
		"2 - Terminar pedido\n" +
		"3 - Cancelar compra\n" +
		"4 - Sair\n" +
		"---------------------------------------";
		System.out.println(opcoes);
	}

	private void terminarPedido(Cliente cliente) {
		System.out.println("[*] - Pedido terminado com sucesso");
		exibirPedido(cliente);
		cliente.realizarCompra();
		cliente.getPedido().removeAllProdutos();
	}

	private void exibirOperacoes() {
		System.out.println("----------------- MENU ----------------");
        System.out.println("1 - Comprar");
        System.out.println("2 - Exibir Clientes");
        System.out.println("3 - Info");
        System.out.println("4 - Sair");
        System.out.println("---------------------------------------");
	}

	private void exibirProdutosDoEstoque() {
		getEstoque().exibirProdutos();
	}
	
	private void exibirMensagemDeErro(String mensagem) {
		System.out.println("[!] - " + mensagem);
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
