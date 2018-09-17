import java.util.*;

// Cliente del videoclub

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String status() {
		double totalPrice = 0;
		int totalPoints = 0;
		String result = "Alquileres de: " + getName() + "\n";

		for (Rental rental : rentals) {

			// 1) Calcula el importe de cada alquiler
			double price = 0;
			switch (rental.getMovie().getCategory()) {
			case Movie.NEW_RELEASE:
				price += rental.getDays() * 3;
				break;
			case Movie.REGULAR:
				price += 2;
				if (rental.getDays() > 2)
					price += (rental.getDays() - 2) * 1.5;
				break;
			case Movie.CHILDRENS:
				price += 1.5;
				if (rental.getDays() > 3)
					price += (rental.getDays() - 3) * 1.5;
				break;
			}

			// 2) Cada alquiler da 1 punto. Punto extra para novedades alquiladas 2 o más días
			int points = 1;
			if ((rental.getMovie().getCategory() == Movie.NEW_RELEASE) && rental.getDays() > 1)
				points = 2;

			// 3) Acumula los totales
			totalPrice += price;
			totalPoints += points;

			// 4) Muestra el importe de esta película alquilada
			result += "\t" + rental.getMovie().getTitle() + "\t" + price + " €\n";
		}

		result += "La deuda es de " + totalPrice + " €\n";
		result += "Has obtenido " + totalPoints + " puntos en tu tarjeta";

		return result;
	}
}
