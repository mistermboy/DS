package nodos;

import visitor.PrintVisitor;

public class Read implements Sentencia {
	public Variable var;

	public Read(Variable var) {
		this.var = var;
	}

	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}
}
