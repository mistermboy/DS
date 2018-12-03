package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import editor.actions.Delete;
import editor.actions.Insert;
import editor.actions.Open;
import editor.actions.Replace;

public class Editor {
	private BufferedReader in;
	private StringBuilder texto;

	private ActionManager actionManager = new ActionManager(this);

	public void interprete() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		texto = new StringBuilder("");

		do {
			System.out.print("> ");

			String[] line = in.readLine().split(" ");

			// No se comprueba que el número de palabras sea el adecuado

			if (line[0].equals("salir"))
				return;

			if (line[0].equals("abre")) {
				actionManager.execute(new Open(line[1]));
			} else if (line[0].startsWith("ins")) {
				actionManager.execute(new Insert(line));
			} else if (line[0].startsWith("borr")) {
				actionManager.execute(new Delete());
			} else if (line[0].startsWith("reem")) {
				actionManager.execute(new Replace(line[1], line[2]));
			} else if (line[0].startsWith("graba")) {
				actionManager.record(line[1]);
			} else if (line[0].startsWith("para")) {
				actionManager.stop();
			} else if (line[0].startsWith("ejecuta")) {
				actionManager.executeMacro(line[1]);
			} else {
				System.out.println("Instrucción desconocida");
			}

			System.out.println(texto);

		} while (true);
	}

	public StringBuilder getTexto() {
		return texto;
	}

	public void setTexto(StringBuilder texto) {
		this.texto = texto;
	}

}
