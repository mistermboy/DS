package nodos;

import visitor.PrintVisitor;

public class Suma implements Expresion {
	public Expresion left, right;

	public Suma(Expresion left, Expresion right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}
}
