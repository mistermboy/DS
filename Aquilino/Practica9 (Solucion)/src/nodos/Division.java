package nodos;

import visitor.*;

public class Division implements Expresion {
	public Expresion left, right;

	public Division(Expresion left, Expresion right) {
		this.left = left;
		this.right = right;
	}

	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}}
