package main.instrucciones;

import main.Interprete;

public class Load extends AbstractInstruccion implements Instruccion {

	@Override
	public void executeBody(Interprete interprete) {
		int direccion = interprete.pop();
		interprete.push(interprete.getMemoria(direccion));
	}

}
