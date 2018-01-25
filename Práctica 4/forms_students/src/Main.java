import form.Field;
import form.Formulario;
import validators.AndValidator;
import validators.CampoNumero;
import validators.CampoPredefinido;
import validators.CampoTexto;
import validators.GreaterThanValidator;
import validators.LessThanValidator;
import validators.OrValidator;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addField(new Field("Nombre", new CampoTexto()));
		formulario.addField(new Field("Apellido", new CampoTexto()));
		formulario.addField(new Field("Telefono", new CampoNumero()));
		formulario.addField(new Field("Ciudad", new CampoPredefinido("Santander", "Oviedo", "Cadiz")));
		
		formulario.addField(new Field("20y80",new AndValidator(new GreaterThanValidator(20),new LessThanValidator(80))));
		formulario.addField(new Field("20o80",new OrValidator(new LessThanValidator(20),new GreaterThanValidator(80))));

		formulario.askUser();
	}
}
