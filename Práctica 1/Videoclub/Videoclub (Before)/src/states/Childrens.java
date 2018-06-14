package states;

public class Childrens implements Movie {

	private String title;

	public Childrens(String title) {
		this.title = title;
	}

	@Override
	public double getPrice(int daysRented) {
		double amount = 1.5;
		if (daysRented > 3)
			amount += (daysRented - 3) * 1.5;
		return amount;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getPoints(int daysRented) {
		return 0;
	}

}
