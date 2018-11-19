package visitor;

import java.io.*;
import java.util.*;

import nodos.*;

public class InterpreteVisitor implements Visitor {
	public Object visit(Programa programa, Object param) {
		for (Sentencia sentencia : programa.sentencias)
			sentencia.accept(this, null);
		return null;
	}

	public Object visit(Read read, Object param) {
		int valor;
		System.out.print("Introduzca el valor para la variable " + read.var.name + ": ");
		try {
			valor = Integer.parseInt(consola.readLine());
		} catch (Exception e) {
			valor = 0;
		}
		memory.put(read.var.name, valor);
		return null;
	}

	public Object visit(Asignacion asigna, Object param) {
		int valor = (Integer) asigna.expr.accept(this, null);
		memory.put(asigna.variable.name, valor);
		return null;
	}

	public Object visit(Print print, Object param) {
		System.out.println(print.expr.accept(this, null));
		return null;
	}

	public Object visit(ConstanteInt cte, Object param) {
		return Integer.parseInt(cte.valor);
	}

	public Object visit(Variable var, Object param) {
		Integer valor = memory.get(var.name);
		if (valor == null)
			valor = 0;
		return valor;
	}

	public Object visit(Suma suma, Object param) {
		return (Integer) suma.left.accept(this, null) + (Integer) suma.right.accept(this, null);
	}

	public Object visit(Producto prod, Object param) {
		return (Integer) prod.left.accept(this, null) * (Integer) prod.right.accept(this, null);
	}

	public Object visit(Division div, Object param) {
		return (Integer) div.left.accept(this, null) / (Integer) div.right.accept(this, null);
	}

	private BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
	private Map<String, Integer> memory = new HashMap<String, Integer>();

}
