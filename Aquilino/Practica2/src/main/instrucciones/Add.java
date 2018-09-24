package main.instrucciones;

import main.Interprete;

public class Add extends AbstractInstruccion implements Instruccion {

	@Override
	public void executeBody(Interprete interprete) {
		int pop1 = interprete.pop();
		int pop2 = interprete.pop();
		interprete.push(pop1 + pop2);
	}

}
