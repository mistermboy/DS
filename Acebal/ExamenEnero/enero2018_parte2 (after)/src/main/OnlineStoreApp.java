package main;

import java.util.*;

import model.*;
import server.*;
import view.AbstractTable;
import view.CompactDiscTable;

public class OnlineStoreApp 
{
	public static void main(String[] args) 
	{
		OnlineStoreApp store = new OnlineStoreApp();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();

		// 1. Mostrando los datos del servidor
		AbstractTable table = new CompactDiscTable();
		for (CompactDisc disc : discs) {
			((CompactDiscTable) table).insertRow(disc);
		}
		table.drawTable();

		/*
		  	Se muestra por pantalla la siguiente tabla:
		 
			+---------------+----------------+
			| Título        | Artista        |
			+---------------+----------------+
			| Despacito     | Luis Fonsi     |
			| Dragon's Kiss | Marty Friedman |
			+---------------+----------------+
		 */
	
		// 2. Modificamos los datos
		System.out.println("Modificando los datos...");
		discs.get(0).setArtist("Metallica");
		discs.get(0).setTitle("For Whom the Bells Tolls");

		// 3. Presentamos los nuevos datos
		table = new CompactDiscTable();
		for (CompactDisc disco : discs) {
			((CompactDiscTable) table).insertRow(disco);
		}
		table.drawTable();

		/*
		  	Tras la modificación, ésta es la nueva ventana que se muestra:
		 
			+--------------------------+----------------+
			| Título                   | Artista        |
			+--------------------------+----------------+
			| For Whom the Bells Tolls | Metallica      |
			| Dragon's Kiss            | Marty Friedman |
			+--------------------------+----------------+
		 */
		
		// 4. Se suben al servidor
		server.uploadCompactDiscs(discs);
	}
}
