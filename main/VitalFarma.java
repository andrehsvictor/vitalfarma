import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VitalFarma implements Serializable {
    private static final long serialVersionUID = 8496667498812511605L;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private transient Estoque estoque = new Estoque();

    {
        estoque.adicionarSuplemento("CREATINA");
        estoque.adicionarSuplemento("PROTEINA");
        estoque.adicionarSuplemento("VITAMINA");
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

	public void iniciar(){
		exibirLogoDaFarmacia();
		iniciarOperacoes();
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
	
	public void iniciarCompras(){
    	int opcao;
    	final int COMPRAR_MAIS = 1;
    	final int TERMINAR = 2;
    	final int CANCELAR_COMPRA = 3;
    	final int SAIR = 4;
    	
    	limparConsole();
    	
		Cliente cliente = processarCliente();
		cliente.fazerPedido();
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
				sair();
            default:
            	exibirMensagemDeErro("Opcao invalida");
            	break;
			}
		} while(opcao != SAIR && opcao != CANCELAR_COMPRA);
	}

	public void iniciarOperacoes() {
		exibirOperacoes();
		int opcao = intInput("-> Digite uma opcao: ");
		final int COMPRAR = 1;
		final int EXIBIR_CLIENTES = 2;
		final int EXIBIR_PEDIDOS = 3;
		final int INFO = 4;
		final int SAIR = 5;

		do {
			switch(opcao) {
			case COMPRAR:
				limparConsole();
				iniciarCompras();
				break;
			case EXIBIR_CLIENTES:
				limparConsole();
                exibirListaDeClientes();
                stringInput("Digite qualquer coisa para voltar: ");
                limparConsole();
    			exibirLogoDaFarmacia();
				break;
			case EXIBIR_PEDIDOS:
				limparConsole();
                exibirListaDePedidos();
                stringInput("Digite qualquer coisa para voltar: ");
                limparConsole();
                exibirLogoDaFarmacia();
                break;
			case INFO:
				limparConsole();
                exibirLogoDaFarmacia();
                exibirInfo();
                stringInput("Digite qualquer coisa para voltar: ");
                limparConsole();
                exibirLogoDaFarmacia();
				break;
			case SAIR:
				sair();
				break;
			default:
				limparConsole();
				exibirLogoDaFarmacia();
				exibirMensagemDeErro("Opção inválida!");
				break;
			}
			exibirOperacoes();
			opcao = intInput("Digite uma opcao: ");
		} while(opcao != SAIR);
	}

	public void exibirListaDePedidos() {
		for(Pedido pedido : pedidos) {
		System.out.println("╭────────────────────── Pedido ──────────────────────╮");
        System.out.printf("│ Data e Hora: %-37s │%n", pedido.getDataHora());
        System.out.println("│                                                    │");
        System.out.println("│ Produtos:                                          │");
        for (Produto produto : pedido.getProdutos()) {
            System.out.printf("│   • %s R$%-36.2f│%n",produto.getNome(), produto.getPreco());
        }
        System.out.println("│                                                    │");
        System.out.printf("│ Valor Total: R$%-36s│%n",String.format("%.2f", pedido.getValorTotal()));
        System.out.println("╰────────────────────────────────────────────────────╯");
		}
	}

	public void exibirInfo() {
		System.out.println("╭────────────────────────────────────────────────────╮");
        System.out.println("│                                                    │");
        System.out.println("│    Programa feito para o projeto final da          │");
        System.out.println("│    disciplina de Linguagem de Programação,         │");
        System.out.println("│    lecionada  pela  profª  Raquel Pereira          │");
        System.out.println("│                                                    │");
        System.out.println("│    Integrantes do grupo:                           │");
        System.out.println("│    - André Henrique                                │");
        System.out.println("│    - Cleber Marcolino                              │");
        System.out.println("│    - Suerdo Flaubert                               │");
        System.out.println("│    - Maria Victória                                │");
        System.out.println("│                                                    │");
        System.out.println("╰────────────────────────────────────────────────────╯");
        
	}

	public void sair() {
		salvarDados();
		System.exit(0);
	}
	
	public void salvarDados() {
		salvarClientes();
		salvarPedidos();
	}

	public void salvarClientes() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados/clientes.data"));
			oos.writeObject(this.clientes);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarPedidos() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados/pedidos.data"));
			oos.writeObject(this.pedidos);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void adicionarProdutoAoPedido(Cliente cliente) {
        String nomeDoProdutoDesejado = stringInput("-> Digite o nome do produto: ").toUpperCase();
        Produto produto = procurarProdutoNoEstoque(nomeDoProdutoDesejado);
        boolean produtoDesejadoExisteNoEstoque = produto != null;

        limparConsole();

        if (produtoDesejadoExisteNoEstoque) {
            if (produto instanceof Remedio) {
                adicionarRemedioAoPedido(cliente, produto, nomeDoProdutoDesejado);
            } else {
                cliente.getPedido().addProduto(produto);
                System.out.println("[*] - Produto " + produto.getNome() + " adicionado ao pedido");
            }
            Collections.sort(cliente.getPedido().getProdutos());
        } else {
        	exibirMensagemDeErro("Produto " + nomeDoProdutoDesejado + " não existe no estoque");
        }
    }
    public void adicionarRemedioAoPedido(Cliente cliente, Produto produto, String nomeDoProdutoDesejado) {
        Remedio remedio = (Remedio) produto;

        if (remedio.isSujeitoAPrescricao(nomeDoProdutoDesejado)) {
            if (temReceita(nomeDoProdutoDesejado)) {
            	limparConsole();
                cliente.getPedido().addProduto(produto);
                System.out.println("[*] - Produto " + produto.getNome() + " adicionado ao pedido");
            } else {
            	exibirMensagemDeErro("Este produto exige prescricao medica");
            	exibirMensagemDeErro("Voce precisa apresentar a receita medica para poder compra-lo");
            }
        } else {
            cliente.getPedido().addProduto(produto);
            System.out.println("[*] - Produto " + produto.getNome() + " adicionado ao pedido");
        }
    }

    public boolean temReceita(String nomeMedicamento) {
        if (nomeMedicamento.equals("RIVOTRIL")) {
            String codigoCorreto = stringInput("Digite o codigo da receita medica para Rivotril: ");
            return codigoCorreto.equals("201324");
        } else if (nomeMedicamento.equals("LOSARTANA")) {
            String codigoCorreto = stringInput("Digite o código da receita médica para Losartana: ");
            return codigoCorreto.equals("890213");
        } else if (nomeMedicamento.equals("NEOSORO")) {
            String codigoCorreto = stringInput("Digite o código da receita médica para Neosoro: ");
            return codigoCorreto.equals("562739");
        }
        return true;
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

	public void terminarPedido(Cliente cliente) {
		System.out.println("[*] - Pedido terminado com sucesso");
		exibirPedido(cliente);
		cliente.realizarCompra();
		addPedido(cliente.getPedido());
	}

	public void exibirPedido(Cliente cliente) {
		
		System.out.println("╔══════════════════════════════════════════╗");
	    System.out.println("║             PEDIDO VITALFARMA            ║");
	    System.out.println("╠══════════════════════════════════════════╣");
	    System.out.printf("║ Data e Hora do Pedido: %-18s║%n", cliente.dataDoPedidoToString());
	    System.out.println("╠══════════════════════════════════════════╣");
	    System.out.println("║                 PRODUTOS                 ║");
	    System.out.println("╠══════════════════════════════════════════╣");
	    for (Produto produto : cliente.getPedido().getProdutos()) {
	    	System.out.printf("║ %19s R$ %-18.2f║%n", produto.getNome(), produto.getPreco());
	    }
	    System.out.println("╠══════════════════════════════════════════╣");
	    System.out.printf("║ Valor Total: %-27s ║%n", cliente.calcularValorTotal());
	    System.out.println("╠══════════════════════════════════════════╣");
	    System.out.printf("║ Cliente: %-31s ║%n", cliente.getNome());
	    System.out.println("╚══════════════════════════════════════════╝");
	}

	public void exibirOpcoesCompras() {
		System.out.println("╭──────────────────────╮");
        System.out.println("│         MENU         │");
        System.out.println("├──────────────────────┤");
        System.out.println("│ 1. Comprar mais      │");
        System.out.println("│ 2. Terminar pedido   │");
        System.out.println("│ 3. Cancelar compra   │");
        System.out.println("│ 4. Sair              │");
        System.out.println("╰──────────────────────╯");
	}

	public void exibirOperacoes() {
		System.out.println("╭──────────────────────╮");
        System.out.println("│         MENU         │");
        System.out.println("├──────────────────────┤");
        System.out.println("│ 1. Comprar           │");
        System.out.println("│ 2. Exibir Clientes   │");
        System.out.println("│ 3. Exibir Pedidos    │");
        System.out.println("│ 4. Informações       │");
        System.out.println("│ 5. Sair              │");
        System.out.println("╰──────────────────────╯");
	}

	public void exibirProdutosDoEstoque() {
		getEstoque().exibirProdutos();
	}

	public void exibirMensagemDeErro(String mensagem) {
		System.out.println("[!] - " + mensagem);
	}

	public void exibirLogoDaFarmacia() {
		System.out.println(" __     ___ _        _ _____                          ");
		System.out.println(" \\ \\   / (_) |_ __ _| |  ___|_ _ _ __ _ __ ___   __ _ ");
		System.out.println("  \\ \\ / /| | __/ _` | | |_ / _` | '__| '_ ` _ \\ / _` |");
		System.out.println("   \\ V / | | || (_| | |  _| (_| | |  | | | | | | (_| |");
		System.out.println("    \\_/  |_|\\__\\__,_|_|_|  \\__,_|_|  |_| |_| |_|\\__,_|");

	
	}

	public void exibirListaDeClientes() {
		System.out.println("╭──────────────────────────────────────────────╮");
	    System.out.println("│                   CLIENTES                   │");
	    System.out.println("├──────────────────────┬────────┬──────────────┤");
	    System.out.println("│        Nome          │ Idade  │ Qtd. Compras │");
	    System.out.println("├──────────────────────┼────────┼──────────────┤");
	
	    for (Cliente cliente : clientes) {
	
	        System.out.printf("│ %-20s │ " + "%-6s │ " + "%-12s │\n",cliente.getNome(), cliente.getIdade(), cliente.getCartaoDeFidelidade().getQtdCompras());
	    }
	
	    System.out.println("╰──────────────────────┴────────┴──────────────╯");
	}

	public void limparConsole() {
		for(int i = 0; i < 100; i++) System.out.println();
    }

	public String stringInput(String label) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(label);
        String line = scanner.nextLine().strip();
        return line;
    }

	public int intInput(String label) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(label);
        int integer = scanner.nextInt();
        return integer;
    }
}
