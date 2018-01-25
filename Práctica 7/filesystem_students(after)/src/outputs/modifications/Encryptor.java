package outputs.modifications;

import java.io.IOException;

import outputs.Output;

public class Encryptor implements Output{
	
	private Output output;

	public Encryptor(Output o) {
		this.output=o;
	}

	@Override
	public void send(char c) throws IOException {
		output.send((char) (Character.isLetterOrDigit(c) ? c + 1 : c));
	}

	@Override
	public void close() throws IOException {
		output.close();
		
	}
	
	

}
