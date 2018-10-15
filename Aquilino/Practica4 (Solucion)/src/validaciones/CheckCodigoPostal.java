package validaciones;

import validaciones.composite.*;

public class CheckCodigoPostal extends CheckAll  {

	public CheckCodigoPostal() {
		super(new CheckNumber(), new CheckLength(5));
	}
}
