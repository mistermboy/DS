
public class Temperature {

	private double celsius;
	private double fahrenheit;
	private boolean celsiusOk;
	private boolean fahrenheitOk;
	
	public Temperature(double celsius) {
		setCelsius(celsius);
	}
	
	
	public double getCelsius() {
		
		if(celsiusOk)
			return celsius;
		
		celsiusOk = true;
		return celsius = fahrenheit * 1.8 + 32;
	}

	public double getFahrenheit() {
		
		if(fahrenheitOk)
			return fahrenheit;
		
		fahrenheitOk = true;
		return fahrenheit = celsius * 1.8 + 32;
	}


	public void setCelsius(double temp) {
		celsius = temp;
		celsiusOk = true;
		
		fahrenheitOk = false;
	}



	public void setFahrenheit(double temp) {
		fahrenheit = temp;
		fahrenheitOk = true;
		
		celsiusOk = false;
	}





}
