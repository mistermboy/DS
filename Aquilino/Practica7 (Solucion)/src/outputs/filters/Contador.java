package outputs.filters;

import java.io.*;

import fileSystem.Output;

public class Contador implements Output {

	private Output output;
	private int counter;

	public Contador(Output output) {
		this.output = output;
	}

	public void send(char c) throws IOException {
		output.send(c);
		counter++;
	}

	public int getCounter() {
		return counter;
	}

	public void close() throws IOException {
		output.close();
	}

}
