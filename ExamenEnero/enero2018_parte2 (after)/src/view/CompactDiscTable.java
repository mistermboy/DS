package view;


import model.CompactDisc;

public class CompactDiscTable extends AbstractTable{
	
	
	private int longestTitle = 0, longestArtist = 0, longestGenre = 0;
	

	@Override
	public void draw() {
		for (CompactDisc cd : rowsCD)
			printRow(cd.getTitle(), cd.getArtist(), cd.getGenre());
	}

	@Override
	protected void computeRowWidths() {
		longestTitle = longestArtist = longestGenre = 0;
		for (CompactDisc disco : rowsCD) {
			if (disco.getTitle().length() > longestTitle)
				longestTitle = disco.getTitle().length();

			if (disco.getArtist().length() > longestArtist)
				longestArtist = disco.getArtist().length();
			
			if (disco.getGenre().length() > longestGenre)
				longestGenre = disco.getGenre().length();
		}
		
	}
	
	@Override
	protected void printHeader() 
	{	
		printSeparator();
		printRow("Título", "Artista", "Género");
		printSeparator();
	}

	private void printRow(String title, String artist, String genero) 
	{
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestArtist));
		System.out.print(" |");
		System.out.print(fillWithBlanks(genero, longestGenre));
		System.out.println(" |");
	}
	
	@Override
	protected void printSeparator() 
	{
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestArtist + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestGenre + 2));
		System.out.println("+");
	}



	
	
}
