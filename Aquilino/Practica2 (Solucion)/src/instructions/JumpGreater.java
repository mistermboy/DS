package instructions;
import vm.*;

public class JumpGreater implements Instruction {
	public JumpGreater(int direccion) {
		this.direccion = direccion;
	}

	@Override
	public void execute(State state) {
		int b = state.pop();
		int a = state.pop();
		if (a > b)
			state.setIP(direccion);
		else
			state.setIP(state.getIP() + 1);
	}

	private int direccion;
}
