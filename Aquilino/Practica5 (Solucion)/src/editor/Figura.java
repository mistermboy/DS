package editor;

public interface Figura {
	public void dibujar();
	public boolean contiene(int x, int y);
	public void mover(int dx, int dy);
}
