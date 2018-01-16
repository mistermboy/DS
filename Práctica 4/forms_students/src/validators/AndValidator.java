package validators;

public class AndValidator extends CompoundValidator implements Validator {

	public AndValidator(Validator... validators) {
		super(validators);
	}

	public void addCondition(Validator validator) {
		super.addCondition(validator);
	}

	@Override
	public boolean isValid(String values) {
		for (Validator v : validators) {
			if (!v.isValid(values)) {
				return false;
			}
		}
		return true;
	}

}
