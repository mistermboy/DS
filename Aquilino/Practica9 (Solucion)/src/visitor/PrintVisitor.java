package visitor;

import nodos.*;

public class PrintVisitor implements Visitor {
	public Object visit(Programa programa, Object param) {
		for (Sentencia sentencia:programa.sentencias)
			sentencia.accept(this, null);
		return null;
	}

	public Object visit(Read read, Object param) {
		System.out.print("read ");
		read.var.accept(this, null);
		System.out.println(";");
		return null;
	}

	public Object visit(Asignacion asigna, Object param) {
		asigna.variable.accept(this, null);
		System.out.print(" = ");
		asigna.expr.accept(this, null);
		System.out.println(";");
		return null;
	}

	public Object visit(Print print, Object param) {
		System.out.print("print ");
		print.expr.accept(this, null);
		System.out.println(";");
		return null;
	}

	public Object visit(ConstanteInt cte, Object param) {
		System.out.print(cte.valor);
		return null;
	}

	public Object visit(Variable refVar, Object param) {
		System.out.print(refVar.name);
		return null;
	}

	public Object visit(Suma suma, Object param) {
		suma.left.accept(this, null);
		System.out.print(" + ");
		suma.right.accept(this, null);
		return null;
	}

	public Object visit(Producto prod, Object param) {
		prod.left.accept(this, null);
		System.out.print(" * ");
		prod.right.accept(this, null);
		return null;
	}

	public Object visit(Division div, Object param) {
		div.left.accept(this, null);
		System.out.print(" / ");
		div.right.accept(this, null);
		return null;
	}
}
