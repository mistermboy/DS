package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public abstract class AbstractInstruction implements Instruction
{
	@Override
	public void execute(Context context) throws ProgramException
	{
		run(context);
		context.incrementIp();
	}
	
	protected abstract void run(Context context) throws ProgramException;
}
