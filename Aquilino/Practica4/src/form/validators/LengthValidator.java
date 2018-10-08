package form.validators;

public class LengthValidator implements Validator {

	private int length;

	public LengthValidator(int length) {
		this.length = length;
	}

	@Override
	public boolean isValid(String texto) {
		return texto.toCharArray().length == length ? true : false;
	}

}
