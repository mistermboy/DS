package adapters;

import model.CompactDisc;

public class CompactDiscAdapter implements ModelAdapter{
	
	private CompactDisc cd;
	
	public CompactDiscAdapter(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public String getInfo1() {
		return cd.getTitle();
	}

	@Override
	public String getInfo2() {
		return cd.getArtist();
	}

}
