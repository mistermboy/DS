package outputs.decorators;

import java.io.IOException;

import outputs.Output;

public class RepeatedSpaces implements Output {

	private char last;
	private Output output;

	public RepeatedSpaces(Output output) {
		this.output = output;
	}

	@Override
	public void send(char c) throws IOException{
		if (c == ' ' && last == ' ')
			return;
		last = c;
		output.send(c);
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
