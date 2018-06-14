package states;

public class New_Release implements Movie {

	private String title;

	public New_Release(String title) {
		this.title = title;
	}

	@Override
	public double getPrice(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getPoints(int daysRented) {
		if (daysRented > 1)
			return 1;
		return 0;
	}

}
