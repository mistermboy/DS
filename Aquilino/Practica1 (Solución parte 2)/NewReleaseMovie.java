public class NewReleaseMovie implements Category {

	public double getPrice(int daysRented) {
		return daysRented * 3;
	}

	public int getPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}
