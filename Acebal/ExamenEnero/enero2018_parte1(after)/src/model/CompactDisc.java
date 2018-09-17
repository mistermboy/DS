package model;

public class CompactDisc 
{
	public CompactDisc(String title, String artist) 
	{
		setTitle(title);
		setArtist(artist);
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getArtist() 
	{
		return artist;
	}

	public void setArtist(String artist) 
	{
		this.artist = artist;
	}
	
	private String title;
	private String artist;	
}
