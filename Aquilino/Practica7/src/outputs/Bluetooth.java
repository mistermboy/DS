package outputs;

import java.io.IOException;
import java.io.StringWriter;

public class Bluetooth implements Output {

	private StringWriter stringWriter = new StringWriter();

	public Bluetooth(String deviceName) {
		stringWriter.append("\n--- START Bluetooth[" + deviceName + "]\n");
	}

	@Override
	public void send(char c) {
		stringWriter.append(c);
	}

	@Override
	public void close() throws IOException {
		System.out.println(stringWriter.toString());
		System.out.println("--- END   Bluetooth");
	}

}
