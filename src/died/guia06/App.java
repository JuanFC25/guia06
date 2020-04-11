package died.guia06;

public class App {

	public static void main(String[] args) {
		
		Alumno alumno1=new Alumno("Juan",25286,10);
		Alumno alumno2=new Alumno("Esteban",25486,10);
		Alumno alumno3=new Alumno("Horacio",25986,10);
		Alumno alumno4=new Alumno("Migel",25186,10);
		Alumno alumno5=new Alumno("Ramon",25386,10);
		Curso DIED=new Curso(1111,"DIED",2020,20,6,0);
		DIED.inscribir(alumno1);
		DIED.inscribir(alumno2);
		DIED.inscribir(alumno3);
		DIED.inscribir(alumno4);
		DIED.inscribir(alumno5);
		DIED.imprimirInscriptos();
		System.out.println("");
		DIED.imprimirInscriptosPorNLibreta();
		System.out.println("");
		DIED.imprimirInscriptos();
		
		
		
		
		
	}
}
