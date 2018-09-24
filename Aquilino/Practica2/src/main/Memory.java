package main;

public class Memory {

	private int[] memoria = new int[1024];

	private int ip = 0;

	public void incrementaIp() {
		ip++;
	}

	public void setIp(int value) {
		ip = value;
	}

	public void setMemoria(int direccion, int value) {
		memoria[direccion] = value;
	}

	public int getMemoria(int direccion) {
		return memoria[direccion];
	}

	public int getIp() {
		return ip;
	}

}
