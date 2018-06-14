package interpreter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interpreter.instructions.*;
import interpreter.parser.Parser;
import interpreter.parser.ParserException;

import org.junit.Before;
import org.junit.Test;

public class InterpreterTest 
{
	private Interpreter interpreter;
	private Parser parser;
	
	@Before
	public void setUp()
	{
		interpreter = new Interpreter();
		parser = new Parser();
	}
	
	@Test
	public void testFactorial() throws ProgramException, IOException, ParserException 
	{
		interpreter.executeProgram(parser.parse("factorial5.txt"));
		assertEquals(120, interpreter.getContext().pop());
	}
	
	@Test
	public void testEmptyStack() throws ProgramException
	{
		List<Instruction> program = new ArrayList<>();
		program.add(new Add());
		try {
			interpreter.executeProgram(program);
			fail("Se debería haber obtenido un error de ejecución de pila vacía");
		} catch (ProgramException e) {	
		}
		try {
			program = new ArrayList<>();
			program.add(new Push(5));
			program.add(new Add());
			interpreter.executeProgram(program);
			fail("Se debería haber obtenido un error de ejecución de pila vacía");
		} catch (ProgramException e) {			
		}
		program = new ArrayList<>();
		program.add(new Push(5));
		program.add(new Push(3));
		program.add(new Add());
		interpreter.executeProgram(program);
		assertEquals(8, interpreter.getContext().pop());
	}
	
	@Test
	public void testStackOverflow() throws ProgramException
	{
		List<Instruction> program = new ArrayList<>();
		for (int i = 0; i <= Context.STACK_SIZE; i ++) {
			program.add(new Push(i));			
		}
		try {
			interpreter.executeProgram(program);
			fail("Se debería haber obtenido un error de desbordamiento de pila");
		} catch (ProgramException e) {	
		}
	}	
}
