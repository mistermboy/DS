package cpu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import estrategias.Add;
import estrategias.Input;
import estrategias.Instruccion;
import estrategias.Jmp;
import estrategias.Jmpg;
import estrategias.Load;
import estrategias.Mul;
import estrategias.Output;
import estrategias.Push;
import estrategias.Store;
import estrategias.Sub;

public class Interpreter {

	private List<String[]> instructions = new ArrayList<>();
	private int ip = 0;

	private int[] memory = new int[1024];

	private int[] stack = new int[32];
	private int sp = 0;

	private static final boolean TRACE = false;

	public void executeProgram() {

		List<Instruccion> ins = new ArrayList<Instruccion>();

		while (ip < instructions.size()) {
			String[] sentence = instructions.get(ip);

			if (sentence[0].equals("push")) {
				ins.add(new Push(Integer.parseInt(sentence[1])));

			} else if (sentence[0].equals("add")) {
				ins.add(new Add());
			} else if (sentence[0].equals("sub")) {
				int b = pop();
				int a = pop();
				push(a - b);
				ip++;

				ins.add(new Sub());

			} else if (sentence[0].equals("mul")) {
				push(pop() * pop());
				ip++;

				ins.add(new Mul());

			} else if (sentence[0].equals("jmp")) {
				ip = Integer.parseInt(sentence[1]);

				ins.add(new Jmp());

			} else if (sentence[0].equals("jmpg")) {
				int b = pop();
				int a = pop();
				if (a > b)
					ip = Integer.parseInt(sentence[1]);
				else
					ip++;

				ins.add(new Jmpg());

			} else if (sentence[0].equals("load")) {
				int address = pop();
				push(memory[address]);
				ip++;

				ins.add(new Load());

			} else if (sentence[0].equals("store")) {
				int value = pop();
				int address = pop();
				memory[address] = value;
				ip++;

				ins.add(new Store());

			} else if (sentence[0].equals("input")) {
				System.out.println("Escriba un entero:");
				push(readValue());
				ip++;

				ins.add(new Input());
			} else if (sentence[0].equals("output")) {
				System.out.println(pop());
				ip++;

				ins.add(new Output());
			}
		}
	}

	public void loadSentence(String line) {
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens)
				System.out.println("*" + token + "*");
		}
		instructions.add(tokens);
	}

	public void push(int value) {
		stack[sp] = value;
		sp++;
	}

	public int pop() {
		sp--;
		return stack[sp];
	}

	public int readValue() {
		return new Scanner(System.in).nextInt();
	}

	public void incrementIP() {
		this.ip++;
	}
}
