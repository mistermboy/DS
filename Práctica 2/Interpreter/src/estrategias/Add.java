package estrategias;

import cpu.Interpreter;

public class Add extends AbstractInstruccion {

	private Interpreter inter = super.getInterpreter();

	@Override
	public void execute() {
		inter.push(inter.pop() + inter.pop());
		super.incrementaIp();
	}
}
