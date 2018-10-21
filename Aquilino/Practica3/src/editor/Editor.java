package editor;

import editor.tools.SelectionTool;

public class Editor {

	private Dibujo dibujo;
	private Tool actualTool;
	private Tool principalTool;

	public Editor(Dibujo dibujo) {
		setDibujo(dibujo);
		actualTool = principalTool = createDefaultTool();
	}

	public void setDibujo(Dibujo dibujo) {
		this.dibujo = dibujo;
	}

	public Dibujo getDibujo() {
		return dibujo;
	}

	public void dibujar() {
		dibujo.dibujar();
	}

	public void setTool(Tool tool) {
		actualTool = tool;
	}

	public void pinchar(int x, int y) {
		actualTool.pinchar(x, y);
	}

	public void mover(int x, int y) {
		actualTool.mover(x, y);
	}

	public void soltar(int x, int y) {
		actualTool.soltar(x, y);
	}

	public void addFigure(Figure figure) {
		dibujo.addFigure(figure);
	}

	public void finishTool() {
		actualTool = principalTool;
	}

	protected Tool createDefaultTool() {
		return new SelectionTool(this);
	}

	public Tool getDefaultTool() {
		return principalTool;
	}

}
