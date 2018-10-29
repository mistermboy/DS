package outputs.decorators;

import java.io.IOException;

import outputs.Output;

public class Encript implements Output {

	private Output output;
	
	public Encript(Output output) {
		this.output = output;
	}
	
	@Override
	public void send(char c) throws IOException{
		if(Character.isLetterOrDigit(c)) {
			output.send((char) (c+1));
		}else
			output.send(c);
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
