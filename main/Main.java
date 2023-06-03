
public class Main {

	public static void main(String[] args) {
		VitalFarma vf = new VitalFarma();
		vf.getEstoque()
		.listarProdutos();
		vf.getEstoque().removerSuplementoPorNome("vitamina");
		vf.getEstoque().listarProdutos();
	}

}
