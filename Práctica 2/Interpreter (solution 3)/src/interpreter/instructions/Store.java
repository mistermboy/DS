package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public class Store extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		int value = context.pop();
		int address = context.pop();
		context.write(address, value);
	}
	
	@Override
	public String toString()
	{
		return "STORE";
	}	
}
