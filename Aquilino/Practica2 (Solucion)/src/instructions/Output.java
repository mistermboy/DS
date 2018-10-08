package instructions;
import vm.*;

public class Output extends AbstractInstruction {

	@Override
	protected void doExecute(State state) {
		System.out.println(state.pop());
	}
}
