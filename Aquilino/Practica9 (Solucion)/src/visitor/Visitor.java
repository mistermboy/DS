package visitor;

import nodos.*;

public interface Visitor {
	Object visit(Programa p, Object param);

	Object visit(Read r, Object param);

	Object visit(Asignacion r, Object param);

	Object visit(Print p, Object param);

	Object visit(Variable r, Object param);

	Object visit(ConstanteInt s, Object param);

	Object visit(Suma s, Object param);

	Object visit(Producto s, Object param);

	Object visit(Division s, Object param);
}
