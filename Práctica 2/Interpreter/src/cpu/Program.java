package cpu;

import java.io.BufferedReader;
import java.io.FileReader;

public class Program {

	public static void main(String[] args) throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("src/factorial.txt"));

		Interpreter interpreter = new Interpreter();
			
		String line;
		while ((line = file.readLine()) != null)
			interpreter.loadSentence(line);
		file.close();

		interpreter.executeProgram();
	}

}
