package editor;

public class Editor {

	public Editor(Dibujo dibujo) {
		setDibujo(dibujo);
	}

	public void setDibujo(Dibujo dibujo) {
		this.dibujo = dibujo;
	}

	public Dibujo getDibujo() {
		return dibujo;
	}

	private Dibujo dibujo;

	public void dibujar() {
		dibujo.dibujar();
	}
}
