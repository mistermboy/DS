package nodos;

public class Producto implements Expresion {
	public Expresion left, right;

	public Producto(Expresion left, Expresion right) {
		this.left = left;
		this.right = right;
	}
}
