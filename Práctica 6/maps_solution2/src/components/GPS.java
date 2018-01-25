package components;

public class GPS 
{
	public void navigateTo(String address) 
	{
		System.out.println("GPS: Gire a la derecha [...] Ha llegado a su destino: " + address);
	}

	public Coordinates getCoordinates(String address) 
	{
		// Cálculo de relleno: simplmente devuelve la posición en función de la primera letra
		double number = (address.toLowerCase().charAt(0) - 'a') * 10 + 10;
		return new Coordinates(number, number);
	}

	public String getAddress(Coordinates coordinates) 
	{
		return coordinates.toString();
	}
}
