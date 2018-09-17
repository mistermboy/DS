package interpreter.parser;

import interpreter.instructions.*;
import interpreter.instructions.factories.*;
import interpreter.loader.InstructionLoader;
import interpreter.loader.LoaderException;

import java.util.*;
import java.io.*;

public class Parser 
{
	private InstructionLoader loader = new InstructionLoader();
	
	public Parser() throws LoaderException
	{
		loader.readConfigurationFile();
	}
	
	public List<Instruction> parse(String filename) throws IOException, ParserException
	{
		List<Instruction> program = new ArrayList<>();
		BufferedReader file = new BufferedReader(new FileReader(filename));
		String line;
		int lineNumber = 0;
		while ((line = file.readLine()) != null) {
			lineNumber++;
			// salta la línea si está en blanco
			if (line.trim().length() == 0)
				continue;
			program.add(parseLine(lineNumber, line));
		}
		file.close();
		return program;
	}
	
	private Instruction parseLine(int lineNumber, String line) throws ParserException
	{
		String[] tokens = line.split(" ");
		
		String name = tokens[0].toUpperCase();
		String[] arguments = Arrays.copyOfRange(tokens, 1, tokens.length);
		InstructionFactory factory = loader.getFactoryFor(name);
		if (factory == null)
			throw new ParserException(lineNumber, line, "Instrucción desconocida: " + name);
		
		try {
			return factory.create(arguments);
		} catch (RuntimeException e) {
			throw new ParserException(lineNumber, line);
		}
	}
	
	
}
