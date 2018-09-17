import types.Childrens;
import types.MovieType;
import types.NewRelease;
import types.Regular;

public class Movie	// Película
{
	
	public static final MovieType CHILDRENS = new Childrens();
	public static final MovieType NEW_RELEASE = new NewRelease();
	public static final MovieType REGULAR = new Regular();
	
	
	private String title;
	private MovieType movieType;
	
	
	public Movie(String title, MovieType movieType) 
	{
		this.title = title;
		this.movieType = movieType;
	}
	
	public MovieType getCategory() 
	{
		return movieType;
	}

	public void setCategory(MovieType movieType) 
	{
		this.movieType = movieType;
	}
	
	public String getTitle() 
	{
		return title;
	}	
	
	
	public double getPrice(int daysRented) {
		return movieType.getPrice(daysRented);
	}

	
	public int getPoints(int daysRented) {
		return movieType.getPoints(daysRented);
	}
	
	
}
