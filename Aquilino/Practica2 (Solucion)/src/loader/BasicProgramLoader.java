package loader;
import instructions.*;

import java.io.*;
import java.util.*;

import vm.Instruction;

public class BasicProgramLoader {
	public List<Instruction> loadProgram(Reader reader) throws IOException {

		BufferedReader fichero = new BufferedReader(reader);
		List<Instruction> programa = new ArrayList<Instruction>();

		String linea;
		while ((linea = fichero.readLine()) != null) {
			if (linea.trim().length() > 0)
				programa.add(creaInstrucción(linea));
		}
		fichero.close();
		return programa;
	}

	private Instruction creaInstrucción(String linea) {
		String[] word = linea.split(" ");

		if (word[0].equals("add"))
			return new Add();
		if (word[0].equals("sub"))
			return new Sub();
		if (word[0].equals("mul"))
			return new Mul();
		if (word[0].equals("load"))
			return new Load();
		if (word[0].equals("store"))
			return new Store();
		if (word[0].equals("input"))
			return new Input();
		if (word[0].equals("output"))
			return new Output();

		int operando = Integer.parseInt(word[1]);

		if (word[0].equals("push"))
			return new Push(operando);
		if (word[0].equals("jmp"))
			return new Jump(operando);
		if (word[0].equals("jmpg"))
			return new JumpGreater(operando);

		throw new IllegalArgumentException();
	}
}
