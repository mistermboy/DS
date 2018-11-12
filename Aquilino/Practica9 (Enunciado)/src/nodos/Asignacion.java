package nodos;

public class Asignacion implements Sentencia {
	public Variable variable;
	public Expresion expr;

	public Asignacion(Variable variable, Expresion expr) {
		this.variable = variable;
		this.expr = expr;
	}

}
