package actions;

/**
 * Esta clase representa una EstrategiConcreta en el patrón Strategy
 *
 */
public class EmergencyService implements Action {

	@Override
	public void press() {
		System.out.println("Sevicio de emergencias: llamando al 112");
	}

	@Override
	public String getInfo() {
		return "LLamar al servicio de emergencias";
	}

}
