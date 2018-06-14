package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public class Push extends AbstractInstruction implements Instruction
{
	private int value;
	
	public Push(int value)
	{
		this.value = value;
	}

	@Override
	protected void run(Context context) throws ProgramException 
	{
		context.push(value);
	}
	
	@Override
	public String toString()
	{
		return "PUSH " + value;
	}	
}
