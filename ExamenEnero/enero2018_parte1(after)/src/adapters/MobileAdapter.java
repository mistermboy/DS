package adapters;

import model.Mobile;

public class MobileAdapter implements ModelAdapter{
	
	private Mobile mobile;
	
	public MobileAdapter(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String getInfo1() {
		return mobile.getModel();
	}

	@Override
	public String getInfo2() {
		return mobile.getBrand();
	}

}
