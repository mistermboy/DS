package nodos;

import java.util.List;

import visitor.PrintVisitor;

public class Programa implements Nodo {
	public List<Sentencia> sentencias;

	public Programa(List<Sentencia> sentencias) {
		this.sentencias = sentencias;
	}

	@Override
	public void accept(PrintVisitor printVisitor, Object o) {
		printVisitor.visit(this, o);
	}
}
