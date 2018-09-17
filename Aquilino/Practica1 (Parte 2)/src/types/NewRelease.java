package types;

public class NewRelease implements MovieType{

	@Override
	public double getPrice(int daysRented) {
		return (daysRented - 3) * 1.5 ;
	}

	@Override
	public int getPoints(int daysRented) {
		if(daysRented > 1)
			return 2;
		return 0;
	}
}
