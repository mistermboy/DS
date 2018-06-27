package view;


import model.Book;

public class BookTable extends AbstractTable {

	private int longestTitle = 0, longestauthor = 0, longesteditorial = 0, longestlanguage = 0;


	
	@Override
	protected void draw() {
		for (Book b : rowsBook)
			printRow(b.getTitle(), b.getAuthor(), b.getEditorial(), b.getLanguage());

	}
	
	
	@Override
	protected void computeRowWidths() {
		longestTitle = longestauthor = longesteditorial = longestlanguage = 0;
		for (Book b : rowsBook) {
			if (b.getTitle().length() > longestTitle)
				longestTitle = b.getTitle().length();

			if (b.getAuthor().length() > longestauthor)
				longestauthor = b.getAuthor().length();

			if (b.getEditorial().length() > longesteditorial)
				longesteditorial = b.getEditorial().length();

			if (b.getLanguage().length() > longestlanguage)
				longestlanguage = b.getLanguage().length();
		}

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestauthor + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longesteditorial + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestlanguage + 2));
		System.out.println("+");

	}

	private void printRow(String title, String author, String editorial, String language) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(author, longestauthor));
		System.out.print(" |");
		System.out.print(fillWithBlanks(editorial, longesteditorial));
		System.out.print(" |");
		System.out.print(fillWithBlanks(language, longestlanguage));
		System.out.println(" |");

	}

	@Override
	protected void printHeader() {
		printSeparator();
		printRow("Título", "Autor", "Editorial", "Idioma");
		printSeparator();

	}

}
