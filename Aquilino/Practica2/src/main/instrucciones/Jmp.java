package main.instrucciones;

import main.Interprete;

public class Jmp implements Instruccion {

	private int value;

	public Jmp(int value) {
		this.value = value;
	}

	@Override
	public void execute(Interprete interprete) {
		interprete.setIp(value);
	}

}
