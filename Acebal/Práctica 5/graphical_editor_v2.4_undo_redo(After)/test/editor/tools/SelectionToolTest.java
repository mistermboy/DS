package editor.tools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import editor.Editor;
import editor.figures.*;

public class SelectionToolTest 
{
	private Editor editor;
	private Rectangle r1, r2, r3;
	
	@Before
	public void setUp()
	{
		editor = new Editor();
		r1 = new Rectangle(100, 80, 150, 120); // de la (100, 80) a la (250, 200)
		r2 = new Rectangle(135, 120, 190, 60); // de la (135, 120) a la (325, 180)
		r3 = new Rectangle(800, 600, 200, 220); // de la (800, 600) a la (1000, 820
		editor.getDrawing().addFigure(r1);
		editor.getDrawing().addFigure(r2);
		editor.getDrawing().addFigure(r3);
	}
	
	@Test
	public void testSelectSingleFigure() 
	{
		editor.clickedOn(120, 90);
		assertEquals(r1, editor.getDrawing().getCurrentSelection());
		editor.clickedOn(880, 625);
		assertEquals(r3, editor.getDrawing().getCurrentSelection());
		// comprueba que también se seleccione si pulsamos justo en uno de los bordes
		editor.clickedOn(880, 600);
		assertEquals(r3, editor.getDrawing().getCurrentSelection());
		editor.clickedOn(800, 710);
		assertEquals(r3, editor.getDrawing().getCurrentSelection());
		// o exactamente en un vértice
		editor.clickedOn(1000, 820);
		assertEquals(r3, editor.getDrawing().getCurrentSelection());
		// en el caso de figuras que se solapan, el editor debe seleccionar la última
		// figura añadida (la que está encima de las otras que hubiera en el mismo punto)
		editor.clickedOn(160, 145);
		assertEquals(r2, editor.getDrawing().getCurrentSelection());		
	}
	
	@Test
	public void testClickOnNoFigure()
	{
		editor.clickedOn(80, 80);
		assertNull(editor.getDrawing().getCurrentSelection());
		editor.clickedOn(120, 90);
		assertEquals(r1, editor.getDrawing().getCurrentSelection());
		// cuando hay una figura seleccionada, al pulsar fuera (en un punto donde no
		// haya ninguna figura) se limpia la selección actual (pasa a no haber ninguna
		// figura seleccionada en el editor)
		editor.clickedOn(80, 80);
		assertNull(editor.getDrawing().getCurrentSelection());		
	}
	
	@Test
	public void testMoveFigure()
	{
		editor.clickedOn(120, 90);
		editor.movedTo(180, 105);
		// se tiene que haber movido 60 píxeles a la derecha y 15 hacia abajo,
		// respecto de la posición original (180 - 120 y 105 - 90, respectivamente)
		assertEquals(160, r1.getX());
		assertEquals(95, r1.getY());
		// seguimos moviendo el cursor, sin soltar el botón...
		editor.movedTo(80, 185);
		// ahora debería haberse movido 100 hacia arriba y 80 hacia abajo
		// (lo que movimos el cursor desde la última posición)
		assertEquals(60, r1.getX());
		assertEquals(175, r1.getY());
		// añadimos una serie de movimientos intermedios...
		editor.movedTo(300, 50);
		editor.movedTo(715, 88);
		editor.movedTo(2, 1024);
		editor.movedTo(80, 185); // el mismo punto de más arriba
		editor.released();
		// debería seguir en la misma posición que en la última comprobación
		assertEquals(60, r1.getX());
		assertEquals(175, r1.getY());
	}
	
	@Test
	public void testUndoMove()
	{
		// posición inicial: (800, 600)
		assertEquals(800, r3.getX());
		assertEquals(600, r3.getY());
		editor.clickedOn(850, 625);
		// hacemos una serie de movimientos intermedios que no deberían tener
		// efecto al deshacer (se deshace el movimiento completo)
		editor.movedTo(825, 600);
		editor.movedTo(1000, 1825);
		editor.movedTo(20, 38);
		// último movimiento antes de soltar
		editor.movedTo(750, 525);
		assertEquals(700, r3.getX());
		assertEquals(500, r3.getY());
		editor.released(); // movimiento 1: (700, 500) / dx = -100; dy = -100
		// otro movimiento formado por varios movimientos intermedios
		editor.clickedOn(725,  505);
		editor.movedTo(634, 18);
		editor.movedTo(988,  77);
		editor.movedTo(925, 705);
		editor.released(); // movimiento 2: (900, 700) / dx = 200; dy = 200
		assertEquals(900, r3.getX());
		assertEquals(700, r3.getY());
		// deshacemos el último movimiento
		editor.undo();
		assertEquals(700, r3.getX());
		assertEquals(500, r3.getY());
		// deshacemos el movimiento anterior
		editor.undo();
		assertEquals(800, r3.getX());
		assertEquals(600, r3.getY());
	}
}
