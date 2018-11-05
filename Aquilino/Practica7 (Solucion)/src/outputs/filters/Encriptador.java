package outputs.filters;

import java.io.*;

import fileSystem.Output;

public class Encriptador implements Output {

	private Output output;

	public Encriptador(Output output) {
		this.output = output;
	}

	public void send(char c) throws IOException {
		output.send((char) (Character.isLetterOrDigit(c) ? c + 1 : c));
	}

	public void close() throws IOException {
		output.close();
	}

}
