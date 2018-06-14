package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public class JumpIfGreaterThan implements Instruction
{
	private int address;
	
	public JumpIfGreaterThan(int address)
	{
		this.address = address;
	}
	
	@Override
	public void execute(Context context) throws ProgramException
	{
		int b = context.pop();
		int a = context.pop();
		if (a > b)
			context.setIp(address);
		else
			context.incrementIp();
	}
	
	@Override
	public String toString()
	{
		return "JMPG " + address;
	}	
}
