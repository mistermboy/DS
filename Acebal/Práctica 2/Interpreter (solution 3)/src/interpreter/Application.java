package interpreter;

import interpreter.parser.Parser;
import interpreter.parser.ParserException;

import java.io.IOException;

public class Application 
{
	public static void main(String[] args) throws IOException, ParserException
	{
		try {			
			Parser parser = new Parser();
			Interpreter interpreter = new Interpreter();
			
			interpreter.executeProgram(parser.parse("factorial.txt"));
		} catch (ProgramException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
