/*
 * @(#)NothingApp.java 5.1
 *
 */

package CH.ifa.draw.samples.nada;

import java.awt.Panel;

import CH.ifa.draw.application.DrawApplication;
import CH.ifa.draw.framework.Tool;

public class NadaApp extends DrawApplication {

	NadaApp() {
		super("Nothing");

	}

	// -- main -----------------------------------------------------------

	public static void main(String[] args) {
		DrawApplication window = new NadaApp();
		window.open();
	}

	protected void createTools(Panel palette) {
		super.createTools(palette);
		Tool herramienta = new EjemploTool(view());
		palette.add(createToolButton(IMAGES + "RECT", "Ejemplo Tool", herramienta));
		
		
	}

}
