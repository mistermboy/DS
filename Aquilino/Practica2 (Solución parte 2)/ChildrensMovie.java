public class ChildrensMovie implements Category {
	
	public double getPrice(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}

	public int getPoints(int daysRented) {
		return 1;
	}

}
