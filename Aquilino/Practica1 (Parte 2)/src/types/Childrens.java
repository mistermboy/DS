package types;

public class Childrens implements MovieType{

	@Override
	public double getPrice(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getPoints(int daysRented) {
		return 1;
	}

}
