package editor.tools;

public interface Tool 
{
	void clickOn(int x, int y);
	void moveTo(int x, int y);
	void release();
}
