package nodos;

import visitor.PrintVisitor;

public class Print implements Sentencia {
	public Expresion expr;

	public Print(Expresion expr) {
		this.expr = expr;
	}

	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}

}
