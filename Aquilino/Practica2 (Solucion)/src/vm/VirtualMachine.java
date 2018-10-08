package vm;

import java.util.*;

public class VirtualMachine {
	private State state = new State();

	public VirtualMachine(List<Instruction> program) {
		this.program = program;
	}
	
	public void run() {
		while (state.getIP() < program.size())
			program.get(state.getIP()).execute(state);
	}

	private List<Instruction> program;
}

