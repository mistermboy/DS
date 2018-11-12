package nodos;

import visitor.PrintVisitor;

public class Asignacion implements Sentencia {
	public Variable variable;
	public Expresion expr;

	public Asignacion(Variable variable, Expresion expr) {
		this.variable = variable;
		this.expr = expr;
	}

	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}

}
