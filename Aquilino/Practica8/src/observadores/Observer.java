package observadores;

import encuesta.Pregunta;

public interface Observer {

	void notify(Pregunta pregunta);

}
