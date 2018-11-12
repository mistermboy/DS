package nodos;

import visitor.PrintVisitor;

public class Variable implements Expresion {
	public String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}
}
