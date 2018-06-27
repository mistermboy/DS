package main;

import java.util.*;

import adapters.BookAdapter;
import adapters.CompactDiscAdapter;
import model.*;
import server.*;
import view.Table;

public class AppVersion3 
{
	public static void main(String[] args) 
	{
		AppVersion3 store = new AppVersion3();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();
		List<Book> books = server.downloadBooks();

		// 1. Mostrando los datos del servidor
		Table table = new Table();
		for (Book b : books) {
			table.insertRow(new BookAdapter(b));
		}
		for (CompactDisc disc : discs) {
			table.insertRow(new CompactDiscAdapter(disc));
		}
		table.drawTable("Título", "Autor");

		// Mostrar en una misma tabla los discos y los libros
		// (que ponga "Título" y "Autor" en la cabecera)
		
		/*
			+--------------------+----------------+
			| Título             | Autor          |
			+--------------------+----------------+
			| Despacito          | Luis Fonsi     |
			| Dragon's Kiss      | Marty Friedman |
			| El Código Da Vinci | Dan Brown      |
			| Design Patterns    | Erich Gamma    |
			+--------------------+----------------+
		 */

		server.uploadCompactDiscs(discs);
		server.uploadBooks(books);
	}
}
