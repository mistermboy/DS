package outputs.modifications;

import java.io.IOException;

import outputs.Output;

public class RemoveSpaceLine implements Output{
	
	private Output output;
	private char previousChar=0;

	public RemoveSpaceLine(Output o) {
		this.output=o;
	}

	@Override
	public void send(char c) throws IOException {
		if (c == ' ' && previousChar == ' ')
			return;

		output.send(c);
		previousChar = c;

	}

	@Override
	public void close() throws IOException {
		output.close();
		
	}

}
