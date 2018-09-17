package interpreter.instructions.factories;

import interpreter.instructions.*;

public class JumpIfGreaterThanFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		int address = Integer.parseInt(args[0]);
		return new JumpIfGreaterThan(address);			
	}
}
