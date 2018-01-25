package validators;

public class CampoTexto implements Validator {

	@Override
	public boolean isValid(String values) {
		for (char ch : values.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}
}
