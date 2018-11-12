package nodos;

import visitor.PrintVisitor;

public interface Nodo {

	void accept(PrintVisitor printVisitor, Object o);

}
