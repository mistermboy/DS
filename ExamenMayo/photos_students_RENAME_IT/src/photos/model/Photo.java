package photos.model;

public class Photo 
{
	private String image;

	// valores de los ajustes predefinidos, inicializados a sus valores por omisión
	private int brightness = 0, contrast = 0;	
	// si se han aplicado o no a la foto
	private boolean isBrightnessEnabled, isContrastEnabled;
	
	public Photo(String filename)
	{
		image = new String(filename);
	}
	
	/**
	 * Devuelve una copia de la imagen que representa esta fotografía a la que
	 * se le han aplicado todos los ajustes realizados en la foto. Nótese que
	 * este método no modifica la imagen original, sino que crea una copia de
	 * la misma que es sobre la que se aplican los ajustes y la que finalmente
	 * se devuelve.
	 *  
	 * @return un objeto {@code String} que representa la imagen generada
	 *         resultante de aplicar los ajustes realizados a esta fotografía 
	 */
	public String outputImage()
	{
		String result = new String(image);
		result = applyAdjustments(result);
		return result;
	}
	
	
	//-- Ajustes
	
	private String applyAdjustments(String image)
	{
		String result = image;
		if (isBrightnessEnabled)
			result = applyBrightness(result);
		if (isContrastEnabled)
			result = applyContrast(result);
		return result;
	}
	
	private String applyBrightness(String image)
	{
		return image + String.format("\nBrillo: %+d", brightness);
	}
	
	private String applyContrast(String image)
	{
		return image + String.format("\nContraste: %+d", contrast);
	}
	
	public void enableAdjustment(String adjustmentName)
	{
		if (adjustmentName.equalsIgnoreCase("brillo"))
			isBrightnessEnabled = true;
		else if (adjustmentName.equalsIgnoreCase("contraste"))
			isContrastEnabled = true;
		else
			throw new IllegalArgumentException("Nombre de ajuste desconocido");
	}
	
	public void setAdjustment(String adjustmentName, int value)
	{
		if (adjustmentName.equalsIgnoreCase("brillo")) {
			brightness = value;
			isBrightnessEnabled = true;
		} else if (adjustmentName.equalsIgnoreCase("contraste")) {
			contrast = value;
			isContrastEnabled = true;
		} else
			throw new IllegalArgumentException("Nombre de ajuste desconocido");
	}

	public void disableAdjustment(String adjustmentName)
	{
		if (adjustmentName.equalsIgnoreCase("brillo")) {
			isBrightnessEnabled = false;
			brightness = 0;
		} else if (adjustmentName.equalsIgnoreCase("contraste")) {
			isContrastEnabled = false;
			contrast = 0;
		} else
			throw new IllegalArgumentException("Nombre de ajuste desconocido");
	}
	
	
	//-- Otros métodos
	
	@Override
	public String toString()
	{
		return String.format(image);
	}
}
