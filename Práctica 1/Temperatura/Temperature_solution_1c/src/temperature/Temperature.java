package temperature;

public class Temperature 
{
	// La representación interna del valor de este objeto temperatura, expresada
	// en grados Celsius
	private double value;
	
	private Temperature(double celsius)
	{
		this.value = celsius;
	}
	
	public static Temperature valueOfCelsius(double value)
	{
		return new Temperature(value);
	}
	
	public static Temperature valueOfFahrenheit(double value)
	{
		return new Temperature((value - 32) * 5 / 9);
	}
	
	public double asCelsius()
	{
		return value;
	}
	
	public double asFahrenheit()
	{
		return (value * 9 / 5) + 32;
	}
}
