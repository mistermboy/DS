package nodos;

public class Suma implements Expresion {
	public Expresion left, right;

	public Suma(Expresion left, Expresion right) {
		this.left = left;
		this.right = right;
	}
}
