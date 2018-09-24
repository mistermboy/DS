package main.instrucciones;

import main.Interprete;

public class Jmpg implements Instruccion {

	private int value;

	public Jmpg(int value) {
		this.value = value;
	}

	@Override
	public void execute(Interprete interprete) {
		int pop1 = interprete.pop();
		int pop2 = interprete.pop();
		if (pop2 > pop1)
			interprete.setIp(value);
		else
			interprete.incrementaIp();
	}

}
