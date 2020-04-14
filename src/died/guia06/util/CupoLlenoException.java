package died.guia06.util;

public class CupoLlenoException extends Exception{

	public CupoLlenoException() {
		super("El curso ha alcanzado su capacidad maxima");
	}
}
