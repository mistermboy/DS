package estrategias;

public class Push extends AbstractInstruccion {

	private int value;

	public Push(int value) {
		this.value = value;
	}

	@Override
	public void execute() {
		super.getInterpreter().push(value);
		super.incrementaIp();
	}


}
