package interpreter.instructions.factories;

import interpreter.instructions.*;

public class InputFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		return new Input();
	}
}
