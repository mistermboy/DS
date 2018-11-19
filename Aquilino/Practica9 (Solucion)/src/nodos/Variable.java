package nodos;

import visitor.*;

public class Variable implements Expresion {
    public String name;
    public Variable(String name) {
        this.name = name;
    }
    
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
