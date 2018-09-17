package view;

import model.Book;
import model.CompactDisc;
import model.Mobile;

public class ModelTable extends AbstractTable{
	
	private int longestTitle = 0, longestPropietario = 0, longestInformacion = 0;
	
	@Override
	protected void draw() {
		for (CompactDisc cd : rowsCD)
			printRow(cd.getTitle(), cd.getArtist(), cd.getGenre());
		for (Mobile m : rowsMobile)
			printRow(m.getBrand(), m.getModel(), "");
		for (Book b : rowsBook)
			printRow(b.getTitle(), b.getAuthor(), b.getLanguage());
		
	}

	@Override
	protected void computeRowWidths() {
		longestTitle = longestPropietario = longestInformacion = 0;
		for (CompactDisc disco : rowsCD) {
			if (disco.getTitle().length() > longestTitle)
				longestTitle = disco.getTitle().length();

			if (disco.getArtist().length() > longestPropietario)
				longestPropietario = disco.getArtist().length();
			
			if (disco.getGenre().length() > longestInformacion)
				longestInformacion = disco.getGenre().length();
		}
		for (Mobile m : rowsMobile) {
			if (m.getBrand().length() > longestTitle)
				longestTitle = m.getBrand().length();

			if (m.getModel().length() > longestPropietario)
				longestPropietario = m.getModel().length();
		}
		for (Book b : rowsBook) {
			if (b.getTitle().length() > longestTitle)
				longestTitle = b.getTitle().length();

			if (b.getAuthor().length() > longestPropietario)
				longestPropietario = b.getAuthor().length();

			if (b.getLanguage().length() > longestInformacion)
				longestInformacion = b.getLanguage().length();
		}
		
		
	}
	
	@Override
	protected void printHeader() 
	{	
		printSeparator();
		printRow("Título", "Propietario", "Información");
		printSeparator();
	}

	private void printRow(String title, String artist, String genero) 
	{
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestPropietario));
		System.out.print(" |");
		System.out.print(fillWithBlanks(genero, longestInformacion));
		System.out.println(" |");
	}
	
	@Override
	protected void printSeparator() 
	{
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestPropietario + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestInformacion + 2));
		System.out.println("+");
	}



}
