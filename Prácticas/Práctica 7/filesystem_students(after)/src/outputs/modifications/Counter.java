package outputs.modifications;

import java.io.IOException;

import outputs.Output;

public class Counter implements Output {

	private Output output;
	private int cont;

	public Counter(Output output) {
		this.output = output;
	}

	@Override
	public void send(char c) throws IOException {
		output.send(c);
		cont++;
	}

	public int getCounter() {
		return cont;
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
