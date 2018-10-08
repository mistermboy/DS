package instructions;
import vm.*;

public class Push extends AbstractInstruction {

	public Push(int value) {
		this.value = value;
	}

	@Override
	protected void doExecute(State state) {
		state.push(value);
	}

	private int value;
}
