package died.guia06.util;

public class RegistroAuditoriaException extends Exception{

	public RegistroAuditoriaException() {
		super("No se pudo registrar la operacion, intente nuevamente");
	}

}
