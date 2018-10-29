package outputs;

import java.io.IOException;
import java.io.StringWriter;

public class Internet implements Output {

	private StringWriter stringWriter = new StringWriter();
	
	public Internet(String url) {
		stringWriter.append("\n--- START Internet[" + url + "]\n");
	}

	@Override
	public void send(char c) {
		stringWriter.append(c);
	}

	@Override
	public void close() throws IOException{
		System.out.println(stringWriter.toString());
		System.out.println("--- END   Internet");
	}
	

}
