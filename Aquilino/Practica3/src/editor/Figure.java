package editor;

public interface Figure {

	void draw();

	void move(int x, int y);

	boolean isContent(int x, int y);
}
