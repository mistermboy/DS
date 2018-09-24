package main.instrucciones;

import main.Interprete;

public class Output extends AbstractInstruccion implements Instruccion {

	@Override
	public void executeBody(Interprete interprete) {
		System.out.println(interprete.pop());
	}

}
