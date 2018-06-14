package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public interface Instruction 
{
	public void execute(Context context) throws ProgramException;
}
