package interpreter.instructions.factories;

import interpreter.instructions.*;

public class AddFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		return new Add();
	}
}
