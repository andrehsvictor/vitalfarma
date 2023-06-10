import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Fachada {
    private VitalFarma vitalFarma;
    
    public Fachada() {
    	vitalFarma = new VitalFarma();
    	
    }

    public void iniciar() {
    	carregarDados();
        vitalFarma.iniciar();
    }

	private void carregarDados() {
		try {
			ObjectInputStream clientes = new ObjectInputStream(new FileInputStream("dados/clientes.dado"));
			ObjectInputStream pedidos = new ObjectInputStream(new FileInputStream("dados/pedidos.dado"));
			try {
				vitalFarma.setClientes((List<Cliente>) clientes.readObject());
				vitalFarma.setPedidos((List<Pedido>) pedidos.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			clientes.close();
			pedidos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
