package form.validators;

public class PredefinedValidator implements Validator {

	private String[] values;

	public PredefinedValidator(String... values) {
		this.values = values;
	}

	@Override
	public boolean isValid(String texto) {

		for (String valor : values) {
			if (texto.toLowerCase().equals(valor.toLowerCase())) {
				return true;
			}
		}
		return false;

	}

}
