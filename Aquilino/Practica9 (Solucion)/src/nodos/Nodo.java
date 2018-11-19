package nodos;

import visitor.*;

public interface Nodo {
	Object accept(Visitor v, Object param);
}
