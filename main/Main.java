
public class Main {

	public static void main(String[] args) {
		VitalFarma vf = new VitalFarma();
		Cliente c = vf.criarCliente("Andre", 18);
		vf.fazerPedido(c);
	}

}
