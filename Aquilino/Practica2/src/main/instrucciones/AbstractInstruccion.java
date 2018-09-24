package main.instrucciones;

import main.Interprete;

public abstract class AbstractInstruccion implements Instruccion {

	public void execute(Interprete interprete) {
		executeBody(interprete);
		interprete.incrementaIp();
	}

	public abstract void executeBody(Interprete interprete);

}
