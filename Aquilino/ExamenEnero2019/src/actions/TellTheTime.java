package actions;

/**
 * Esta clase representa una EstrategiConcreta en el patrón Strategy
 *
 */
public class TellTheTime implements Action {

	public void press() {
		System.out.println("Son las 12:00");
	}

	public String getInfo() {
		return "Decir la hora";
	}

}
