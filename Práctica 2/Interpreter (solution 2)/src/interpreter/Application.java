package interpreter;

import interpreter.parser.Parser;
import interpreter.parser.ParserException;
import interpreter.instructions.factories.*;

import java.io.IOException;

public class Application 
{
	private Parser parser;
	private Interpreter interpreter;
	
	public static void main(String[] args) throws IOException, ParserException
	{
		new Application().run();
	}
	
	public void run()
	{
		parser = new Parser();
		interpreter = new Interpreter();
		
		// registra todas las instrucciones de nuestro intérprete junto con el
		// objeto que se encarga de saber cómo crear cada una
		registerFactories();
		
		try {			
			interpreter.executeProgram(parser.parse("factorial.txt"));
		} catch (ProgramException e) {
			System.out.println(e.getMessage());
			System.out.println(interpreter.getContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registerFactories()
	{
		parser.registerFactory("PUSH", new PushFactory());
		parser.registerFactory("ADD", new AddFactory());
		parser.registerFactory("SUB", new SubFactory());
		parser.registerFactory("MUL", new MulFactory());
		parser.registerFactory("JMP", new JumpFactory());
		parser.registerFactory("JMPG", new JumpIfGreaterThanFactory());
		parser.registerFactory("LOAD", new LoadFactory());
		parser.registerFactory("STORE", new StoreFactory());
		parser.registerFactory("INPUT", new InputFactory());
		parser.registerFactory("OUTPUT", new OutputFactory());		
	}	
}
