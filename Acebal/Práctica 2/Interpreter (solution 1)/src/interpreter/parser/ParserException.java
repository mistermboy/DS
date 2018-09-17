package interpreter.parser;

public class ParserException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public ParserException(String message)
	{
		super(message);
	}
	
	public ParserException(int lineNumber, String line, String message)
	{
		super(String.format("Syntax error at line %d (%s): %s", lineNumber, line, message));
	}
}
