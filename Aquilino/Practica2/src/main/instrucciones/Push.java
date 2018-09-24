package main.instrucciones;

import main.Interprete;

public class Push extends AbstractInstruccion implements Instruccion {

	private int value;

	public Push(int value) {
		this.value = value;
	}

	@Override
	public void executeBody(Interprete interprete) {
		interprete.push(value);
	}

}
