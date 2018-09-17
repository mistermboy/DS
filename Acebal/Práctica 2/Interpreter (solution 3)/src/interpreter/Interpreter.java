package interpreter;

import java.util.List;

import interpreter.instructions.Instruction;

public class Interpreter 
{	
	private Context context;

	/**
	 * Ejecuta el programa recibido.
	 * 
	 * @param program  el programa a ejecutar por el intérprete, representado
	 *                 como una lista de objetos instrucción ({@code Instruction})
	 * @throws ProgramException 
	 */
	public void executeProgram(List<Instruction> program) throws ProgramException 
	{
		if (program == null || program.size() == 0)
			throw new IllegalArgumentException("¡No hay instrucciones que ejecutar!");		
		context = new Context(program);
		while (context.getIp() < program.size()) {
			program.get(context.getIp()).execute(context);
		}
	}
	
	/**
	 * Devuelve el contexto del intérprete. El contexto contiene todos los
	 * elementos que representan el estado actual del intérprete (pila, puntero
	 * de pila, memoria y contador de programa), junto con las operaciones que
	 * los manipulan, y que es la información que se pasa como parámetros a
	 * todas las instrucciones al llamar a su método {@code execute}.<p>
	 * 
	 * Este método se proporciona (con visibilidad de paquete) únicamente para
	 * que esté accesible para las pruebas. Aparte de eso, no sería necesario
	 * en absoluto (las instrucciones no hacen uso de él, porque ya lo reciben
	 * como parámetro). Se podría eliminar (eliminando las pruebas unitarias),
	 * manteniendo así la ocultación de la información del intérprete.  
	 * 
	 * @return el contexto que representa el estado actual del intérprete
	 */
	Context getContext()
	{
		if (context == null)
			throw new IllegalStateException("El contexto sólo se crea al ejecutar un programa");
		return context;
	}
}
