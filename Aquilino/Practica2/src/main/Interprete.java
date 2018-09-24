package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.instrucciones.Add;
import main.instrucciones.Input;
import main.instrucciones.Instruccion;
import main.instrucciones.Jmp;
import main.instrucciones.Jmpg;
import main.instrucciones.Load;
import main.instrucciones.Mul;
import main.instrucciones.Output;
import main.instrucciones.Push;
import main.instrucciones.Store;
import main.instrucciones.Sub;

public class Interprete {

	private List<Instruccion> instrucciones = new ArrayList<Instruccion>();
	private Memory memory = new Memory();
	private Stack stack = new Stack();
	private Scanner console = new Scanner(System.in);

	public void cargaInstrucción(String linea) {
		if (linea.trim().length() == 0)
			return;

		String[] instruccion = linea.split(" ");

		switch (instruccion[0]) {

		case "push":
			instrucciones.add(new Push(Integer.parseInt(instruccion[1])));
			break;
		case "add":
			instrucciones.add(new Add());
			break;
		case "sub":
			instrucciones.add(new Sub());
			break;
		case "mul":
			instrucciones.add(new Mul());
			break;
		case "jmp":
			instrucciones.add(new Jmp(Integer.parseInt(instruccion[1])));
			break;
		case "jmpg":
			instrucciones.add(new Jmpg(Integer.parseInt(instruccion[1])));
			break;
		case "load":
			instrucciones.add(new Load());
			break;
		case "store":
			instrucciones.add(new Store());
			break;
		case "input":
			instrucciones.add(new Input());
			break;
		case "output":
			instrucciones.add(new Output());
			break;
		}
	}

	public void ejecutaPrograma() {

		while (memory.getIp() < instrucciones.size()) {

			instrucciones.get(memory.getIp()).execute(this);

		}

	}

	public void incrementaIp() {
		memory.incrementaIp();
	}

	public void setIp(int value) {
		memory.setIp(value);
	}

	public void setMemoria(int direccion, int value) {
		memory.setMemoria(direccion, value);
	}

	public int getMemoria(int direccion) {
		return memory.getMemoria(direccion);
	}

	public int getIp() {
		return memory.getIp();
	}

	public void push(int valor) {
		stack.push(valor);
	}

	public int pop() {
		return stack.pop();
	}

	public int nextInt() {
		return console.nextInt();
	}

}
