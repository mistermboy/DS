package model;

public class Restaurante {

	private String nombre;
	private String direcci�n;
	private String tel�fono;

	public Restaurante(String nombre, String direcci�n, String tel�fono) {
		setNombre(nombre);
		setDirecci�n(direcci�n);
		setTel�fono(tel�fono);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirecci�n() {
		return direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}

	public String getTel�fono() {
		return tel�fono;
	}

	public void setTel�fono(String tel�fono) {
		this.tel�fono = tel�fono;
	}

	// Marca el n�mero de tel�fono del restaurante para hacer una reserva
	public void llamar() {
		System.out.println("Llamando al " + tel�fono);
	}
}
