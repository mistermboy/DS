package outputs.decorators;

import java.io.IOException;

import outputs.Output;

public class Normalice implements Output {

	private Output output;
	
	public Normalice(Output output) {
		this.output = output;
	}

	@Override
	public void send(char c) throws IOException{
		 if(c != '\r')
			output.send(c);
	}

	@Override
	public void close() throws IOException {
		output.close();
	}

}
