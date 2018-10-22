package database;

import google.maps.Coordenadas;

import java.util.*;

import model.*;

// Clase que simula el acceso al a Base de Datos
public class Database {

	public Collection<Monumento> selectMonumentos() {
		List<Monumento> monumentos = new ArrayList<Monumento>();
		monumentos.add(new Monumento("Coliseo", "Vespasiano", "Avenida del Coliseo 1. Roma"));
		monumentos.add(new Monumento("Fontana di Trevi", "Niccolo Salvi", "Piazza di Trevi. Roma"));
		return monumentos;
	}

	public Collection<Foto> selectFotos() {
		List<Foto> fotos = new ArrayList<Foto>();
		fotos.add(new Foto("Raúl", "El Coliseo de noche", new Coordenadas(20, 20)));
		fotos.add(new Foto("Raúl", "Un perro mordiendo a un turista", new Coordenadas(40, 40)));
		return fotos;
	}

	public Collection<Restaurante> selectRestaurantes() {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		restaurantes.add(new Restaurante("El Gladiador", "Calle del Triunfo 2. Roma", "555 123 456"));
		restaurantes.add(new Restaurante("Mario", "Via della Dataria . Roma", "555 123 457"));
		return restaurantes;
	}
}
