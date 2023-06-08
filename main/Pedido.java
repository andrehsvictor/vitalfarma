import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
public class Pedido {
    private List<Produto> produtos;
    private double valorTotal;
    private LocalDateTime dataHora;
    
    public Pedido() {
        this.produtos = new ArrayList<>();
        this.valorTotal = 0.0;
        dataHora = LocalDateTime.now();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularValorTotal() {
        valorTotal = 0.0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }
    public String dataToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }
    public void imprimirPedido() {
        System.out.println("----- PEDIDO VITALFARMA -----");
        System.out.println("Data e Hora do Pedido: " + dataToString());
        System.out.println("Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto.getDescricao());
        }
        System.out.println("Valor Total: R$" + calcularValorTotal());
        System.out.println("------------------");
    }
}