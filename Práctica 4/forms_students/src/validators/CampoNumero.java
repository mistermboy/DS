package validators;

public class CampoNumero implements Validator {

	@Override
	public boolean isValid(String values) {
		for (char ch : values.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

}
