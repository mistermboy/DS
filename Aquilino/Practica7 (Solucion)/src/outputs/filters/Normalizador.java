package outputs.filters;

import java.io.*;

import fileSystem.Output;

public class Normalizador implements Output {

	private Output output;

	public Normalizador(Output output) {
		this.output = output;
	}

	public void send(char c) throws IOException {
		if (c != '\r')
			output.send(c);
	}

	public void close() throws IOException {
		output.close();
	}
}
