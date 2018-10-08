package form.validators;

public class NumberValidator implements Validator {

	@Override
	public boolean isValid(String texto) {

		for (char ch : texto.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

}
