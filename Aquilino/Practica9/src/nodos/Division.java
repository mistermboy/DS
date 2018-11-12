package nodos;

import visitor.PrintVisitor;

public class Division implements Expresion {
	public Expresion left, right;

	public Division(Expresion left, Expresion right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}

}
