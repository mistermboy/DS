public class RegularMovie implements Category {

	public double getPrice(int daysRented) {
		double result = 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}

	public int getPoints(int daysRented) {
		return 1;
	}

}
