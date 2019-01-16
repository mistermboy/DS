package actions;

/**
 * Esta clase representa una EstrategiConcreta en el patrón Strategy
 *
 */
public class Forecast implements Action {

	@Override
	public void press() {
		System.out.println("Conectando con el servidor...");
		System.out.println("Hoy hace un expléndido día soleado");
		System.out.println("La predicción para el día de mañana es sol y nubes");
	}

	@Override
	public String getInfo() {
		return "Consultar la previsión meteorológica";
	}

}
