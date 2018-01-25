package form;

import java.util.ArrayList;
import java.util.List;

public class Formulario {

	private List<Field> fields = new ArrayList<Field>();

	public void addField(Field field) {
		fields.add(field);
	}

	public void askUser() {
		for (Field field : fields) {
			field.pideDatos();
			// System.out.println(field.getValue());
		}
	}

}
