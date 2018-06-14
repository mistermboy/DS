import states.Movie;

/**
 * Esta clase representa el alquiler de una película por parte de un cliente.
 */
public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public double getPrice() {
		return movie.getPrice(daysRented);
	}

	public int getFrequentRenterPoints() {
		return movie.getPoints(daysRented);
	}
}
