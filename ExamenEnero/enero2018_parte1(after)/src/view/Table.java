package view;

import java.util.*;

import adapters.ModelAdapter;

public class Table 
{
	
	private List<ModelAdapter> rows = new ArrayList<>();
	private int longestTitle = 0, longestArtist = 0;
	
	//-- Métodos públicos
	//-------------------------------------------------------------

	public void insertRow(ModelAdapter m) 
	{
		rows.add(m);
	}

	public void drawTable(String s1, String s2) 
	{
		computeRowWidths();

		printHeader(s1, s2);
		for (ModelAdapter m : rows)
			printRow(m.getInfo1(), m.getInfo2());
		printSeparator();
		System.out.println();

	}

	//-- Métodos privados
	//-------------------------------------------------------------

	private void computeRowWidths() 
	{
		longestTitle = longestArtist = 0;
		for (ModelAdapter m : rows) {
			if (m.getInfo1().length() > longestTitle)
				longestTitle = m.getInfo1().length();

			if (m.getInfo2().length() > longestArtist)
				longestArtist = m.getInfo2().length();
		}
	}

	private void printHeader(String s1, String s2) 
	{	
		printSeparator();
		printRow(s1, s2);
		printSeparator();
	}

	private void printRow(String title, String artist) 
	{
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestArtist));
		System.out.println(" |");
	}

	private void printSeparator() 
	{
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestArtist + 2));
		System.out.println("+");
	}

	/** 
	 * Si el ancho del texto recibido como parámetro es menor que el deseado
	 * añade espacios hasta que el texto tenga el número de caracteres deseado.
	 * 
	 * Ejemplo:
	 * 		fillWithBlanks("abc", 5)  ->   "abc  " (añade dos espacios)
	 */
	public static String fillWithBlanks(String text, int width) 
	{
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo:
	 * 		createDashedLine(5)  ->   "-----"
	 */
	private String createDashedLine(int ancho) 
	{
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}


}
