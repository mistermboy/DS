package nodos;

import visitor.PrintVisitor;

public class ConstanteInt implements Expresion {
	public String valor;

	public ConstanteInt(String valor) {
		this.valor = valor;
	}

	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}
}
