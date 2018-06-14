package interpreter.loader;

import interpreter.instructions.factories.InstructionFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InstructionLoader 
{
	private Map<String, InstructionFactory> factories = new HashMap<>();
	
	public void readConfigurationFile() throws LoaderException
	{
		try {
			BufferedReader configFile = new BufferedReader(new FileReader("instructions.config"));

			String line;
			while ((line = configFile.readLine()) != null) {
				String[] property = line.split(":");
				String instructionName = property[0].toUpperCase();
				Class<?> instructionFactoryClass = Class.forName(property[1]);
				registerInstructionFactory(instructionName, (InstructionFactory) instructionFactoryClass.newInstance());
			}
			configFile.close();			
		} catch (FileNotFoundException e) {
			throw new LoaderException("No se encontró el fichero de configuración: no se pueden cargar las instrucciones");
		} catch (IOException e) {
			throw new LoaderException("Error leyendo el fichero de configuración: no se pueden cargar las instrucciones");
		} catch (ClassNotFoundException e) {
			throw new LoaderException("Error al cargar las instrucciones: no se encontró la factoría especificada: " + e.getMessage());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new LoaderException("Error al cargar las instrucciones: no se pudo crear la factoría: " + e.getMessage());
		}
	}

	private void registerInstructionFactory(String instructionName, InstructionFactory factory)
	{
		factories.put(instructionName, factory);		
	}
	
	public InstructionFactory getFactoryFor(String instructionName)
	{
		return factories.get(instructionName);
	}
}
