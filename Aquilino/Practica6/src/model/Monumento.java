package model;

public class Monumento {

	private String nombre;
	private String autor;
	private String direcci�n;

	public Monumento(String nombre, String autor, String direcci�n) {
		setNombre(nombre);
		setAutor(autor);
		setDirecci�n(direcci�n);
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

	public String getDirecci�n() {
		return direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}
}
