package outputs.modifications;

import java.io.IOException;

import outputs.Output;

public class NormalizeFile implements Output{
	
	private Output output;

	public NormalizeFile(Output o) {
		this.output=o;
	}

	@Override
	public void send(char c) throws IOException {
		if (c!='\r'){
			output.send(c);
		}
	}

	@Override
	public void close() throws IOException {
		output.close();
		
	}
	
	

}
