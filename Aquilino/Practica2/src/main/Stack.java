package main;

public class Stack {

	private int[] pila = new int[32];
	private int sp = 0;

	public void push(int valor) {
		pila[sp] = valor;
		sp++;
	}

	public int pop() {
		sp--;
		return pila[sp];
	}

}
