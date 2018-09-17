package main;

import java.util.*;

import model.*;
import server.*;
import view.AbstractTable;
import view.BookTable;
import view.CompactDiscTable;
import view.MobileTable;
import view.ModelTable;

public class AppVersion2 
{
	public static void main(String[] args) 
	{
		AppVersion2 store = new AppVersion2();
		store.openWindow();
	}

	public void openWindow() 
	 {
		Server server = new Server();

		List<Mobile> mobiles = server.downloadMobiles();
		List<CompactDisc> discs = server.downloadCompactDiscs();
		List<Book> books = server.downloadBooks();

		// ---------------------------------------------------------------------------------
		// A) Mostrar los móviles en una tabla (que ponga "Modelo" y "Marca" en la cabecera)
		
		/*
			+-----------+---------+
			| Modelo    | Marca   | 
			+-----------+---------+
			| Galaxy S8 | Samsung | 
			| iPhone 8  | Apple   | 
			+-----------+---------+
		*/
		
		AbstractTable table = new MobileTable();
		for (Mobile b : mobiles) {
			table.insertRow(b);
		}
		table.drawTable();

		// ---------------------------------------------------------------------------------
		// B) Mostrar los discos en una tabla (que ponga "Título", "Artista" y 
		//    "Género" en la cabecera)
		
		/*
			+---------------+----------------+--------+
			| Título        | Artista        | Género | 
			+---------------+----------------+--------+
			| Despacito     | Luis Fonsi     | Latino | 
			| Dragon's Kiss | Marty Friedman | Metal  | 
			+---------------+----------------+--------+ 
		 */

		table = new CompactDiscTable();
		for (CompactDisc d : discs) {
			table.insertRow(d);
		}
		table.drawTable();
		// ---------------------------------------------------------------------------------
		// C) Mostrar los libros en una tabla (que ponga "Título", "Autor",
		//    "Editorial" e "Idioma" en la cabecera)
		
		/*
			+--------------------+-------------+----------------+---------+
			| Título             | Autor       | Editorial      | Idioma  |
			+--------------------+-------------+----------------+---------+
			| El Código Da Vinci | Dan Brown   | Planeta        | Español |
			| Design Patterns    | Erich Gamma | Addison-Wesley | Español |
			+--------------------+-------------+----------------+---------+
		*/

		table = new BookTable();
		for (Book b : books) {
			table.insertRow(b);
		}
		table.drawTable();

		// ---------------------------------------------------------------------------------
		// D) Mostrar los discos, móviles y libros en una tabla de 3 columnas 
		//    (que ponga "Título", "Propietario" e "Información" en la cabecera)
		//    - Los móviles muestran su modelo, marca y la tercera columna en blanco.
		//    - Los discos muestran su título, artista y género en cada columna.
		//    - Los libros muestran su título, autor e idioma

		/*
			+--------------------+----------------+-------------+
			| Título             | Propietario    | Información |
			+--------------------+----------------+-------------+
			| Galaxy S8          | Samsung        |             |
			| iPhone 8           | Apple          |             |
			| Despacito          | Luis Fonsi     | Latino      |
			| Dragon's Kiss      | Marty Friedman | Metal       |
			| El Código Da Vinci | Dan Brown      | Español     |
			| Design Patterns    | Erich Gamma    | Español     |
			+--------------------+----------------+-------------+
		*/

		table = new ModelTable();
		for (Mobile m : mobiles) {
			table.insertRow(m);	
		}
		for (CompactDisc cd : discs) {
			table.insertRow(cd);
		}
		for (Book b : books) {
			table.insertRow(b);
		}
		table.drawTable();

		server.uploadMobiles(mobiles);
		server.uploadCompactDiscs(discs);
		server.uploadBooks(books);
	}
}
