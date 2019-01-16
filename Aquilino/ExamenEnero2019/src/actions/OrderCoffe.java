package actions;

/**
 * Esta clase representa una EstrategiConcreta en el patrón Strategy
 *
 */
public class OrderCoffe implements Action {

	public void press() {
		System.out.println("Conectando con el servidor...");
		System.out.println("Pedido online realizado de café");
	}

	public String getInfo() {
		return "Pedir online café";
	}

}
