package main;

import java.io.*;

import outputs.*;
import outputs.modifications.Counter;
import outputs.modifications.Encryptor;
import outputs.modifications.Fork;
import outputs.modifications.NormalizeFile;
import outputs.modifications.RemoveSpaceLine;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();
		
		
		//Modificacion 1 
		system.copyFile("privado.txt", new FileOutput("a.txt")); // Que “a.txt” quede sin encriptar
		system.copyFile("privado.txt", new Encryptor(new FileOutput("b.txt"))); // Que “b.txt” quede encriptado
		
		//Modificacion 2
		system.copyFile("privado.txt",new NormalizeFile(new Internet("1.1.1.1"))); // Este envío normalizado (sin ‘\r’)
		system.copyFile("privado.txt",new RemoveSpaceLine(new Internet("1.1.1.2"))); // Este envío sin espacios repetidos
		system.copyFile("privado.txt",new NormalizeFile( new RemoveSpaceLine(new Internet("1.1.1.3")))); // Este envío normalizado y sin espacios repetidos
		
		//Modificacion 3
		Counter counter1 = new Counter(new Internet("1.1.1.1"));
		Counter counter2 = new Counter(new Bluetooth("1.1.1.1"));
		Counter counter3 = new Counter(new FileOutput("c.txt"));
		system.copyFile("privado.txt",counter1);
		System.out.println("Se han enviado " + counter1.getCounter() + "# caracteres");
		system.copyFile("privado.txt",counter2);
		System.out.println("Se han enviado " + counter2.getCounter() + "# caracteres");
		system.copyFile("privado.txt",counter3);
		System.out.println("Se han enviado " + counter3.getCounter() + "# caracteres");
		
		//Modificacion 4
		Counter despues = new Counter((new Internet("1.1.1.1")));
		Counter antes = new Counter(new NormalizeFile(despues));
		system.copyFile("privado.txt", antes);
		System.out.println("Inicialmente había " +antes.getCounter() + "# caracteres");
		System.out.println("Después de normalizar, se han enviado " + despues.getCounter() + "# caracteres");
		
		Counter despues1 = new Counter((new Internet("1.1.1.1")));
		Counter antes1 = new Counter(new RemoveSpaceLine(despues1));
		system.copyFile("privado.txt", antes1);
		System.out.println("Inicialmente había " +antes1.getCounter() + "# caracteres");
		System.out.println("Después de quitar espacios, se han enviado " + despues1.getCounter() + "# caracteres");
		
		//Modificación 5
		system.copyFile("privado.txt", new Encryptor(new Fork(new Internet("1.1.1.1"), new Bluetooth("Galaxy S")))); // Se envíaencriptadoa ambos
		
	}

}
