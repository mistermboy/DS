package interpreter.instructions.factories;

import interpreter.instructions.Instruction;

public interface InstructionFactory 
{
	Instruction create(String[] args);
}
