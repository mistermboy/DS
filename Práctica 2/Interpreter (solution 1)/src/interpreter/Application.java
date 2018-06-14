package interpreter;

import interpreter.parser.Parser;

public class Application 
{
	public static void main(String[] args) throws Exception
	{
		Parser parser = new Parser();
		Interpreter interpreter;
		interpreter = new Interpreter(parser.parse("factorial.txt"));
		interpreter.executeProgram();
	}
}
