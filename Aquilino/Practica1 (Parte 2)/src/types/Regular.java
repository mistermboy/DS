package types;

public class Regular implements MovieType{

	@Override
	public double getPrice(int daysRented) {
		return (daysRented - 2) * 1.5 ;
	}

	@Override
	public int getPoints(int daysRented) {
		return 1;
	}
}