package instructions;
import vm.*;

public class Sub extends AbstractInstruction {

	@Override
	protected void doExecute(State state) {
		int b = state.pop();
		int a = state.pop();
		state.push(a - b);
	}
}
