package outputs.filters;

import java.io.*;

import fileSystem.Output;

public class EliminadorDeEspacios implements Output {

	private Output output;
	private char lastChar = 0;

	public EliminadorDeEspacios(Output output) {
		this.output = output;
	}

	public void send(char c) throws IOException {
		if (c == ' ' && lastChar == ' ')
			return;

		output.send(c);
		lastChar = c;
	}

	public void close() throws IOException {
		output.close();
	}

}
