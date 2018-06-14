package interpreter.instructions.factories;

import interpreter.instructions.*;

public class SubFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		return new Sub();			
	}
}
