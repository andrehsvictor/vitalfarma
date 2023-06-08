# VitalFarma

Este repositório é sobre um projeto final para a disciplina de Linguagem da Programação,
utilizando todos os conceitos aprendidos no decorrer da disciplina. O projeto consiste
numa farmácia, que aplica conceitos de POO e alguns Design Patterns, bem como boas práticas
para otimização de código.

## Convenções

Umas paradas padronizadas pra facilitar a manutenção do projeto.

### Para variáveis:
- Use sempre ```qtd``` como prefixo de variáveis que guardem quantidades. Ex: ```qtdRemedios```
- Quando criar uma variável que seja uma lista, seu nome deve estar no plural. Ex: ```List<Remedio> remedios;```

### Para métodos:
- Use ações em inglês como sufixo em nome de métodos das classes CRUD. Ex: ```addRemedio()```,```removeRemedio```

## UML do projeto:
```mermaid
---
title: VitalFarma
---
classDiagram
    note "Para simplificar o diagrama, não foram incluídos métodos getters,
    setters, métodos CRUD como add e remove e métodos privados"
    class Produto {
        <<abstract>>
        -nome: String
        -preco: double
        -mapaDePrecos: Map$
  
        +Produto(nome: String)
        +calcularPreco(nomeDoProduto: String) boolean
        +exibirDescricao() void
    }

    class Suplemento {
        +Suplemento(nome: String)
    }

    class Remedio {
        +Remedio(nome: String)
        +isSujeitoAPrescricao(nomeDoRemedio: String) boolean
        +exibirDescricao() void
    }

    class Cosmetico {
        +Cosmetico(nome: String)
    }

    class VitalFarma {
        -pedidos: List~Pedido~
        -clientes: List~Cliente~
        -estoque: Estoque

        +VitalFarma()
        +adicionarCliente(nome: String, idade: int)
        +procurarClientePorNome(nome: String): Cliente
        +exibirPedido(cliente: Cliente)
    }

    class Pedido {
        -produtos: List~Produto~
        -valorTotal: double
        -dataHora: LocalDateTime
        + Pedido()
    }

    class Cliente {
        -nome: String
        -idade: int
        -cartaoDeFidelidade: CartaoDeFidelidade
        -pedido: Pedido

        + Cliente(nome: String, idade: int)
        + realizarCompra(): void
        + dataDoPedidoToString(): String
        + calcularValorTotal(): String
    }

    class CartaoDeFidelidade {
        -qtdCompras: int
        -clienteRecorrente: boolean
        -comprasNoMes: LocalDate
    }

    class Estoque {
        -remedios: List~Remedio~
        -suplementos: List~Suplemento~
        -cosmeticos: List~Cosmetico~

        + adicionarRemedio(nomeRemedio: String): void
        + adicionarSuplemento(nomeSuplemento: String): void
        + adicionarCosmetico(nomeCosmetico: String): void
        + removerRemedioPorNome(nome: String): void
        + removerSuplementoPorNome(nome: String): void
        + removerCosmeticoPorNome(nome: String): void
        + procurarProdutoPorNome(nome: String): Produto
        + exibirProdutos(): void
    }
    
    VitalFarma o-- Estoque
    VitalFarma o-- Pedido
    VitalFarma o-- Cliente
    Pedido o-- Produto
    Cliente o-- CartaoDeFidelidade
    Cliente o-- Pedido
    Produto <|-- Suplemento
    Produto <|-- Remedio
    Produto <|-- Cosmetico
```
