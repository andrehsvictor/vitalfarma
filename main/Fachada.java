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
    	try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("VitalFarma.obj"));
			try {
				vitalFarma.setClientes((List<Cliente>) ois.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        vitalFarma.iniciar();
    }
}
