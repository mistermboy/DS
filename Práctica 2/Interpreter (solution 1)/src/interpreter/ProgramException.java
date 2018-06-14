package interpreter;

import interpreter.instructions.Instruction;

public class ProgramException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ProgramException(Instruction instruction, String message)
	{
		super("An error has occurred while executing the insturction " + instruction + ": " + message);
	}
}
