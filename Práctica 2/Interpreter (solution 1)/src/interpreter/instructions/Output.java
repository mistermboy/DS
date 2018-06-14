package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public class Output extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		System.out.println(context.pop());
	}
	
	@Override
	public String toString()
	{
		return "OUTPUT";
	}	
}
