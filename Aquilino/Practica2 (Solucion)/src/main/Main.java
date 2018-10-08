package main;

import java.io.*;
import java.util.*;

import loader.BasicProgramLoader;
import vm.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BasicProgramLoader loader = new BasicProgramLoader();
		List<Instruction> program = loader.loadProgram(new FileReader("programa.txt"));
		
		VirtualMachine vm = new VirtualMachine(program);
		vm.run();
	}
}
