package nodos;

import visitor.*;

public class Asignacion implements Sentencia {
	public Variable variable;
	public Expresion expr;

	public Asignacion(Variable variable, Expresion expr) {
		this.variable = variable;
		this.expr = expr;
	}
	
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
