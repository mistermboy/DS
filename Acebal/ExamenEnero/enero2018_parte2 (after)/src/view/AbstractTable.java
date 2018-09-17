package view;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.CompactDisc;
import model.Mobile;

public abstract class AbstractTable {

	protected List<CompactDisc> rowsCD = new ArrayList<>();
	protected List<Mobile> rowsMobile = new ArrayList<>();
	protected List<Book> rowsBook = new ArrayList<>();

	// -- Métodos públicos
	// -------------------------------------------------------------
	public void insertRow(Book b) {
		rowsBook.add(b);
	}

	public void insertRow(CompactDisc cd) {
		rowsCD.add(cd);
	}

	public void insertRow(Mobile m) {
		rowsMobile.add(m);
	}

	public void drawTable() {
		computeRowWidths();
		printHeader();
		draw();
		printSeparator();
		System.out.println();

	}

	// -- Métodos privados
	// -------------------------------------------------------------

	protected abstract void computeRowWidths();

	protected abstract void draw();

	protected abstract void printHeader();

	protected abstract void printSeparator();

	/**
	 * Si el ancho del texto recibido como parámetro es menor que el deseado añade
	 * espacios hasta que el texto tenga el número de caracteres deseado.
	 * 
	 * Ejemplo: fillWithBlanks("abc", 5) -> "abc " (añade dos espacios)
	 */
	public static String fillWithBlanks(String text, int width) {
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo: createDashedLine(5) -> "-----"
	 */
	protected String createDashedLine(int ancho) {
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}

}
