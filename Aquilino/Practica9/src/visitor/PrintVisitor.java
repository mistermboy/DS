package visitor;

import nodos.Asignacion;
import nodos.ConstanteInt;
import nodos.Division;
import nodos.Print;
import nodos.Producto;
import nodos.Programa;
import nodos.Read;
import nodos.Sentencia;
import nodos.Suma;
import nodos.Variable;

public class PrintVisitor {
	public void visit(Programa programa, Object o) {
		for (Sentencia sentencia : programa.sentencias)
			sentencia.accept(this, null);
	}

	public void visit(Print print, Object o) {
		System.out.print("print ");
		print.expr.accept(this, null);
		System.out.println(";");
	}

	public void visit(Asignacion asigna, Object o) {
		asigna.variable.accept(this, null);
		System.out.print(" = ");
		asigna.expr.accept(this, null);
		System.out.println(";");
	}

	public void visit(Read read, Object o) {
		System.out.print("read ");
		read.var.accept(this, null);
		System.out.println(";");
	}

	public void visit(Suma suma, Object o) {
		suma.left.accept(this, null);
		System.out.print(" + ");
		suma.right.accept(this, null);
	}

	public void visit(Division div, Object o) {
		div.left.accept(this, null);
		System.out.print(" / ");
		div.right.accept(this, null);
	}

	public void visit(Producto prod, Object o) {
		prod.left.accept(this, null);
		System.out.print(" * ");
		prod.right.accept(this, null);
	}

	public void visit(Variable var, Object o) {
		System.out.print(var.name);
	}

	public void visit(ConstanteInt cte, Object o) {
		System.out.print(cte.valor);
	}
}
