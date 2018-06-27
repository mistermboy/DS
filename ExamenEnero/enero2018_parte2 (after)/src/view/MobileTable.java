package view;


import model.Mobile;

public class MobileTable extends AbstractTable{
	
	
	private int longestBrand = 0, longestModel = 0;
	


	@Override
	protected void draw() {
		for (Mobile m : rowsMobile)
			printRow(m.getBrand(), m.getModel());
		
	}
	
	@Override
	protected void computeRowWidths() {
		longestBrand = longestModel= 0;
		for (Mobile m : rowsMobile) {
			if (m.getBrand().length() > longestBrand)
				longestBrand = m.getBrand().length();

			if (m.getModel().length() > longestModel)
				longestModel = m.getModel().length();
		}
		
	}

	
	private void printRow(String brand, String model) {
		System.out.print(" | ");
		System.out.print(fillWithBlanks(brand, longestBrand));
		System.out.print(" |");
		System.out.print(fillWithBlanks(model, longestModel));
		System.out.println(" |");
		
	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestBrand + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestModel + 2));
		System.out.println("+");
		
	}

	@Override
	protected void printHeader() 
	{	
		printSeparator();
		printRow("Modelo", "Marca");
		printSeparator();
	}


}
