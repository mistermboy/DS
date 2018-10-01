import java.io.*;
import java.util.*;

public class Main {

	private static List<String[]> instrucciones = new ArrayList<String[]>();
	private static int ip = 0;

	private static int[] memoria = new int[1024];

	private static int[] pila = new int[32];
	private static int sp = 0;

	private static Scanner console = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		BufferedReader fichero = new BufferedReader(new FileReader("programa.txt"));

		String linea;
		while ((linea = fichero.readLine()) != null)
			cargaInstrucción(linea);
		fichero.close();

		ejecutaPrograma();
	}

	private static void cargaInstrucción(String linea) {
		if (linea.trim().length() == 0)
			return;

		String[] palabras = linea.split(" ");
		instrucciones.add(palabras);
	}

	private static void push(int valor) {
		pila[sp] = valor;
		sp++;
	}

	private static int pop() {
		sp--;
		return pila[sp];
	}

	private static void ejecutaPrograma() {
		while (ip < instrucciones.size()) {
			String[] instruccion = instrucciones.get(ip);

			if (instruccion[0].equals("push")) {
				push(Integer.parseInt(instruccion[1]));
				ip++;
			} else if (instruccion[0].equals("add")) {
				push(pop() + pop());
				ip++;
			} else if (instruccion[0].equals("sub")) {
				int b = pop();
				int a = pop();
				push(a - b);
				ip++;
			} else if (instruccion[0].equals("mul")) {
				push(pop() * pop());
				ip++;
			} else if (instruccion[0].equals("jmp")) {
				ip = Integer.parseInt(instruccion[1]);
			} else if (instruccion[0].equals("jmpg")) {
				int b = pop();
				int a = pop();
				if (a > b)
					ip = Integer.parseInt(instruccion[1]);
				else
					ip++;
			} else if (instruccion[0].equals("load")) {
				int direccion = pop();
				push(memoria[direccion]);
				ip++;
			} else if (instruccion[0].equals("store")) {
				int valor = pop();
				int direccion = pop();
				memoria[direccion] = valor;
				ip++;
			} else if (instruccion[0].equals("input")) {
				System.out.println("Escriba un entero:");
				push(console.nextInt());
				ip++;
			} else if (instruccion[0].equals("output")) {
				System.out.println(pop());
				ip++;
			}
		}
	}
}
