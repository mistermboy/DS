package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public class Sub extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		int b = context.pop();
		int a = context.pop();
		context.push(a - b);
	}

	@Override
	public String toString()
	{
		return "SUB";
	}
}
