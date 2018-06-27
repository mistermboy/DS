package main;

import java.util.*;

import adapters.BookAdapter;
import model.*;
import server.*;
import view.Table;

public class AppVersion2 {
	public static void main(String[] args) {
		AppVersion2 store = new AppVersion2();
		store.openWindow();
	}

	public void openWindow() {
		Server server = new Server();

		List<Book> books = server.downloadBooks();

		// 1. Mostrando los datos del servidor
		Table table = new Table();
		for (Book b : books) {
			table.insertRow(new BookAdapter(b));
		}

		table.drawTable("Título", "Autor");

		// Mostrar sólo los libros en una tabla (que ponga "Título" y "Autor" en la
		// cabecera)

		/*
		 * +--------------------+-------------+ | Título | Autor |
		 * +--------------------+-------------+ | El Código Da Vinci | Dan Brown | |
		 * Design Patterns | Erich Gamma | +--------------------+-------------+
		 */

		server.uploadBooks(books);
	}
}
