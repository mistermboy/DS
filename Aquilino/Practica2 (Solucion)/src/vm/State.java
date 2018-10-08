package vm;

// Versión sin control de errores

public class State {

	public int getIP() {
		return ip;
	}

	public void setIP(int ip) {
		this.ip = ip;
	}

	public void push(int value) {
		pila[sp++] = value;
	}

	public int pop() {
		return pila[--sp];
	}
	
	public int read(int direccion) {
		return memoria[direccion];
	}
	
	public void write(int direccion, int valor) {
		memoria[direccion] = valor;
	}

	private int[] memoria = new int[1024];
	private int[] pila = new int[32];

	private int ip = 0, sp = 0;
}
