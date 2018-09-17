package adapters;

import model.Book;

public class BookAdapter implements ModelAdapter{
	
	private Book book;
	
	public BookAdapter(Book book) {
		this.book = book;
	}

	@Override
	public String getInfo1() {
		return book.getTitle();
	}

	@Override
	public String getInfo2() {
		return book.getAuthor();
	}

}
