package estrategias;

import cpu.Interpreter;

public abstract class AbstractInstruccion implements Instruccion {

	private Interpreter interpreter;

	public void incrementaIp() {
		this.interpreter.incrementIP();
	}

	public void setInterpreter(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	public Interpreter getInterpreter() {
		return interpreter;
	}
	
	public abstract void execute();

}
