package instructions;

import java.util.*;

import vm.*;

public class Input extends AbstractInstruction {

	@Override
	protected void doExecute(State state) {
		System.out.println("Escriba un entero:");
		state.push(console.nextInt());
	}

	private Scanner console = new Scanner(System.in);
}
