package main.instrucciones;

import main.Interprete;

public class Store extends AbstractInstruccion implements Instruccion{

	@Override
	public void executeBody(Interprete interprete) {
		int valor = interprete.pop();
		int direccion = interprete.pop();
		interprete.setMemoria(direccion, valor);
	}

}
