package instructions;
import vm.*;

public class Store extends AbstractInstruction {

	@Override
	protected void doExecute(State state) {
		int valor = state.pop();
		int direccion = state.pop();

		state.write(direccion, valor);
	}
}
