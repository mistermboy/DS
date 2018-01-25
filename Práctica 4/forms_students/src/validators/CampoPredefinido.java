package validators;

public class CampoPredefinido implements Validator {

	private String[] valores;

	public CampoPredefinido(String... valores) {
		this.valores = valores;
	}

	@Override
	public boolean isValid(String values) {
		for (String valor : valores) {
			if (values.toLowerCase().equals(valor.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
