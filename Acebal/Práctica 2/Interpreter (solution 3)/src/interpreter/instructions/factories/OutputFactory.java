package interpreter.instructions.factories;

import interpreter.instructions.*;

public class OutputFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		return new Output();			
	}
}
