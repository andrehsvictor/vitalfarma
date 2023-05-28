public class Cosmetico extends Produto {
    public Cosmetico(String nome) {
        super(nome, definirPreco(nome));
    }
    
    private static double definirPreco(String nome) {
    	final double PRECO_CREME_PARA_PELE = 29.90,
    			PRECO_HIDRATANTE = 19.90,
    			PRECO_PROTETOR_SOLAR = 39.90,
    			PRECO_OLEO_DE_PELE = 24.90;
    	
    	// Formata pra minúsculo
    	String nomeFormatado = nome.toLowerCase();
    	
        switch (nomeFormatado) {
            case "creme para pele":
                return PRECO_CREME_PARA_PELE;
            case "hidratante":
                return PRECO_HIDRATANTE;
            case "protetor solar":
                return PRECO_PROTETOR_SOLAR;
            case "óleo de pele":
                return PRECO_OLEO_DE_PELE;
            default:
                throw new ProdutoInvalidoException("Cosmético inválido: " + nome);
        }
    }

    @Override
    public double calcularValor() {
        return getPreco();
    }
}