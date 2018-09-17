public class Movie {
	private String title;
	private Category category;

	public Movie(String title, Category category) {
		this.title = title;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public int getPoints(int days) {
		return category.getPoints(days);
	}

	public double getPrice(int days) {
		return category.getPrice(days);
	}
}
