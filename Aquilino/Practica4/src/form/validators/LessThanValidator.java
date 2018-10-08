package form.validators;

public class LessThanValidator implements Validator {

	private int max;

	public LessThanValidator(int max) {
		this.max = max;
	}

	@Override
	public boolean isValid(String texto) {
		return Integer.parseInt(texto) < max ? true : false;
	}

}
