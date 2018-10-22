package model;

public class Monumento {

	private String nombre;
	private String autor;
	private String dirección;

	public Monumento(String nombre, String autor, String dirección) {
		setNombre(nombre);
		setAutor(autor);
		setDirección(dirección);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
}
