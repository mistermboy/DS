package instructions;
import vm.*;

public class Load extends AbstractInstruction {

	protected void doExecute(State context) {
		context.push(context.read(context.pop()));
	}
}
