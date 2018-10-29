package outputs;

import java.io.FileWriter;
import java.io.IOException;

public class CopyFile implements Output {

	private FileWriter filewriter;

	public CopyFile(String output) {
		try {
			filewriter = new FileWriter(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void send(char c) {
		try {
			filewriter.append(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		filewriter.close();
	}

}
