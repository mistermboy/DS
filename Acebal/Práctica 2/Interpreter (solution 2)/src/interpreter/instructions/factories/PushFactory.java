package interpreter.instructions.factories;

import interpreter.instructions.*;

public class PushFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		int value = Integer.parseInt(args[0]);
		return new Push(value);		
	}
}
