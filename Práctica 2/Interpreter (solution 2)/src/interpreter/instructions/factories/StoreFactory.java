package interpreter.instructions.factories;

import interpreter.instructions.*;

public class StoreFactory implements InstructionFactory
{
	@Override
	public Instruction create(String[] args) 
	{
		return new Store();			
	}
}
