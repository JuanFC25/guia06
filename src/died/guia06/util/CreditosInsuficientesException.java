package died.guia06.util;

public class CreditosInsuficientesException extends Exception{


	public CreditosInsuficientesException() {
		super("El alumno no cuenta con los creditos suficientes para este curso");
	}
	
	
	
}
