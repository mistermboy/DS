package model;

public class Restaurante {

	private String nombre;
	private String dirección;
	private String teléfono;

	public Restaurante(String nombre, String dirección, String teléfono) {
		setNombre(nombre);
		setDirección(dirección);
		setTeléfono(teléfono);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	// Marca el número de teléfono del restaurante para hacer una reserva
	public void llamar() {
		System.out.println("Llamando al " + teléfono);
	}
}
