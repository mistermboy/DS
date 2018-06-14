package interpreter.instructions.factories;

import interpreter.instructions.*;

public class LoadFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		return new Load();			
	}
}
