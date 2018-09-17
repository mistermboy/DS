package interpreter.instructions.factories;

import interpreter.instructions.*;

public class MulFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		return new Mul();			
	}
}
