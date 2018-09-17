public class Main {

	public static void main(String[] args) {
		
		Temperature[] temperaturas = new Temperature[100];

		// Toma de datos
		for (int i = 0; i < temperaturas.length; i++)
			temperaturas[i] = new Temperature(leeSensorCelsius());


		double media = 0;
		double mediaFarenheit = 0;
		for (int i = 0; i < temperaturas.length; i++) {
			media += temperaturas[i].getCelsius();
			mediaFarenheit += temperaturas[i].getFahrenheit();
		}
		
		media = media / temperaturas.length;
		mediaFarenheit = mediaFarenheit / temperaturas.length;
		
		//Celsius
		System.out.println(media);
		//Fahrenheit
		System.out.println(mediaFarenheit);
		
//		Temperature varianza = new Temperature(0);
//		for (int i = 0; i < temperaturas.length; i++)
//			varianza.setCelsius(); Math.pow((asFahrenheit(temperaturas[i])) - asFahrenheit(media), 2);
//		varianza = varianza / temperaturas.length;
//		
//		
//		System.out.println(varianza);
//		System.out.println(asCelsius(varianza));
		
		
	}

	public static double leeSensorCelsius() {
		return Math.random() * 30;
	}
	
	
	
	
}
