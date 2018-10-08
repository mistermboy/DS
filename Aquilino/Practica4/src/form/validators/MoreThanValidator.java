package form.validators;

public class MoreThanValidator implements Validator {

	private int min;

	public MoreThanValidator(int min) {
		this.min = min;
	}

	@Override
	public boolean isValid(String texto) {
		return Integer.parseInt(texto) > min ? true : false;
	}

}
