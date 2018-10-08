package instructions;
import vm.*;

public class Add extends AbstractInstruction {

	@Override
	protected void doExecute(State state) {
		state.push(state.pop() + state.pop());
	}
}
