package validators;

public class OrValidator extends CompoundValidator implements Validator {

	public OrValidator(Validator... validators) {
		super(validators);
	}

	@Override
	public boolean isValid(String values) {
		for (Validator v : validators) {
			if (v.isValid(values)) {
				return true;
			}
		}
		return false;
	}

}
