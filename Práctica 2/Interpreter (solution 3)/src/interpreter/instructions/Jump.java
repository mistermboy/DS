package interpreter.instructions;

import interpreter.Context;
import interpreter.ProgramException;

public class Jump implements Instruction
{
	private int address;
	
	public Jump(int address)
	{
		this.address = address;
	}
	
	@Override
	public void execute(Context context) throws ProgramException 
	{
		context.setIp(address);
	}
	
	@Override
	public String toString()
	{
		return "JMP " + address;
	}
}
