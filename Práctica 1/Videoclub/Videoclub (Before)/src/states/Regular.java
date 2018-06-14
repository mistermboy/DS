package states;

public class Regular implements Movie {

	private String title;

	public Regular(String title) {
		this.title = title;
	}

	@Override
	public double getPrice(int daysRented) {
		double amount = 2;
		if (daysRented > 2)
			amount += (daysRented - 2) * 1.5;
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
