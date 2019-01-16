package actions;

/**
 * Esta clase representa una EstrategiConcreta en el patrón Strategy
 *
 */
public class OrderGillete implements Action {

	public void press() {
		System.out.println("Conectando con el servidor...");
		System.out.println("Pedido online realizado de Gillete");
	}

	public String getInfo() {
		return "Pedir online Gillette";
	}

}
