package nodos;

import java.util.*;

import visitor.*;

public class Programa implements Nodo {
    public List<Sentencia> sentencias;
    
    public Programa(List<Sentencia>  sentencias) {
        this.sentencias = sentencias;
    }
    
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
