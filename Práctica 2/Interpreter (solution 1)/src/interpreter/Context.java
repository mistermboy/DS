package interpreter;

import interpreter.instructions.Instruction;

import java.util.List;

public class Context 
{
	public static final int STACK_SIZE = 32;
	public static final int MEMORY_SIZE = 1024;

	/**
	 * Representa la pila del intérprete.
	 */
	private int[] stack = new int[STACK_SIZE];
	
	/**
	 * El puntero de pila (<i>stack pointer</i>). Inicialmente a cero (cuando la pila 
	 * está vacía), apunta en cada momento a la posición actual de la pila (la del último
	 * valor introducido o, lo que es lo mismo, la cima de la pila).
	 */
	private int sp = 0;

	/**
	 * El puntero de instrucciones (<i>instruction pointer</i>). Guarda la dirección de
	 * la siguiente instrucción a ejecutar. En nuestra implementación no es más que un 
	 * índice con la posición de dicha instrucción en la lista de instrucciones que
	 * representa el programa.
	 */
	private int ip = 0;

	/**
	 * Representa la memoria. 
	 */
	private int[] memory = new int[MEMORY_SIZE];
	
	/**
	 * El programa que está siendo ejecutado, representado como una lista de objetos 
	 * instrucción. Aunque no es imprescindible guardarlo en esta clase (de hecho, no
	 * haría falta guardarlo en ningún sitio aparte de en el propio parámetro del método
	 * {@code executeProgram} de {@code Interpreter} donde se recibe), al hacerlo
	 * permitimos realizar comprobaciones en las operaciones de esta clase que modifican
	 * el puntero de instrucción, para lanzar las oportunas excepciones durante la ejecución
	 * del programa en caso de que alguna instrucción intente acceder a una dirección
	 * inválida de la memoria del programa (un valor negativo o por encima de la última
	 * instrucción).
	 * 
	 * <p>Así mismo, y como ventaja adicional, en el caso de éste y otros posibles errores
	 * que se pueden producir en tiempo de ejecución (pila vacía o pila llena, acceso a una
	 * dirección de memoria incorrecta, etcétera), al guardar aquí la lista de instrucciones
	 * que conforman el programa, junto con el puntero de instrucción (que ése sí es
	 * imprescindible guardarlo en esta clase para que lo puedan modificar las instrucciones
	 * al ejecutarse), es posible mostrar la instrucción concreta que ha dado el error. 
	 */
	private List<Instruction> program;
	
	public Context(List<Instruction> program)
	{
		this.program = program;
	}
	
	// Operaciones que manipulan la pila

	public void push(int value) throws ProgramException
	{
		if (sp == stack.length)
			executionError("La pila está llena, no se ha podido añadir el valor: " + value);
		stack[sp++] = value;
	}
	
	public int pop() throws ProgramException 
	{
		if (sp == 0)
			executionError("La pila está vacía, no se ha podido extraer un valor");
		return stack[--sp];
	}
	
	// Operaciones que manipulan el puntero de instrucciones
	
	public void setIp(int ip) throws ProgramException
	{
		if (ip < 0 || ip >= program.size())
			executionError("Acceso fuera del área de instrucciones: " + ip);
		this.ip = ip;
	}
	
	public void incrementIp()
	{
		ip++;
		assert ip < program.size() : "¿Cómo ha podido llegar a tener IP un valor inválido al incrementarse?";
	}
	
	int getIp()
	{
		return ip;
	}
	
	// Operaciones que manipulan la memoria
	
	public int read(int address) throws ProgramException
	{
		checkMemoryAddress(address);
		return memory[address];
	}
	
	public void write(int address, int value) throws ProgramException
	{
		checkMemoryAddress(address);
		memory[address] = value;
	}
	
	private void checkMemoryAddress(int address) throws ProgramException
	{
		if (address < 0 || address > memory.length)
			executionError("Dirección de memoria incorrecta: " + address);		
	}
	
	private void executionError(String message) throws ProgramException
	{
		throw new ProgramException(program.get(ip), message);
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("Execution Context\n");
		result.append("-----------------\n");
		result.append("IP = " + ip + "\n");
		result.append("SP = " + sp + "\n");
		result.append("Program:\n");
		for (int i = 0; i < program.size(); i++)
			result.append(i + ": " + program.get(i) + "\n");
		result.append("Stack:\n");
		for (int i = stack.length - 1; i >= 0; i--)
			result.append(i + ": " + stack[i] + "\n");
		return result.toString();		
	}
}
