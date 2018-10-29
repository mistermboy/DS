package outputs.decorators;

import java.io.IOException;

import outputs.Output;

public class Counter implements Output {

	private Output output;
	private int counter = 0;

	public Counter(Output output) {
		this.output = output;
	}

	@Override
	public void send(char c) throws IOException{
		output.send(c);
		counter++;
	}

	public int getCounter() {
		return counter;
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
