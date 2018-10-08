package instructions;
import vm.*;

public class Jump implements Instruction {
	public Jump(int direccion) {
		this.direccion = direccion;
	}

	@Override
	public void execute(State state) {
		state.setIP(direccion);
	}

	private int direccion;
}
