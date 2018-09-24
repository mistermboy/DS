package main.instrucciones;

import main.Interprete;

public class Input extends AbstractInstruccion implements Instruccion{

	@Override
	public void executeBody(Interprete interprete) {
		System.out.println("Escriba un entero:");
		interprete.push(interprete.nextInt());
	}

}
