package actions;

/**
 * Esta clase representa una EstrategiConcreta en el patrón Strategy
 *
 */
public class Disable implements Action {

	@Override
	public void press() {
		System.out.println("[Botón sin configurar]");
	}

	@Override
	public String getInfo() {
		return "No hacer nada";
	}

}
