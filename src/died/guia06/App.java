package died.guia06;

public class App {

	public static void main(String[] args) {
		
		Alumno alumno1=new Alumno("Juan",25286,10);
		Alumno alumno2=new Alumno("Esteban",25486,10);
		Alumno alumno3=new Alumno("Horacio",25986,10);
		Alumno alumno4=new Alumno("Migel",25186,10);
		Alumno alumno5=new Alumno("Ramon",25386,10);
		Alumno alumno6=new Alumno("Lautaro",25126,0);
		Alumno alumno7=new Alumno("Ramiro",25512,10);
		Alumno alumno8=new Alumno("Nicolas",23941,10);
		Alumno alumno9=new Alumno("Exequiel",24912,10);
		Alumno alumno10=new Alumno("Mauro",24542,10);
		Alumno alumno11=new Alumno("CopiaAlumno1",25286,10);
		
		Curso DIED=new Curso(1111,"DIED",2020,20,6,0);
		Curso Economia=new Curso(1112,"Economia",2020,20,6,3);	
		Curso Diseño=new Curso(1113,"Diseño",2020,5,6,5);
		Curso Analisis=new Curso(1114,"Analisis",2020,20,6,0);
		
		
		//probar inscripcion correcta
		Diseño.inscribir(alumno1);
		Diseño.inscribir(alumno2);
		Diseño.inscribir(alumno3);
		
		
		//Falla por falla de creditos
		Diseño.inscribir(alumno6);
		
		//falla porque ya tiene 3 mat. en el mismo Ciclo Lec
		DIED.inscribir(alumno8);
		Economia.inscribir(alumno8);
		Analisis.inscribir(alumno8);
		
		Diseño.inscribir(alumno8);
		
		//Falla porque ya estan inscriptos
		Diseño.inscribir(alumno1);
		Diseño.inscribir(alumno2);
		Diseño.inscribir(alumno3);
		
		//se inscribe correctamente
		Diseño.inscribir(alumno4);
		Diseño.inscribir(alumno5);
		
		//falla por falta de cupo
		Diseño.inscribir(alumno7);

		//Prueba inscribir inscriptos por orden alfabetico
		Diseño.imprimirInscriptos();
		
	
		//Prueba inscribir inscriptos por Nro de Libreta
		Diseño.imprimirInscriptosPorNLibreta();
		
		//Alumno8 aprueba 2 materias y pide los creditos obtenidos
		alumno8.aprobar(Economia);
		alumno8.aprobar(DIED);
		System.out.println(alumno8.creditosObtenidos());
		
		
		//Alumno 1 aprueba Diseño, permitiendo que el alumno8 se pueda inscribir
		//el alumno8 al aprobar dos materias ya no tiene la restriccion del ciclo lectivo
		
		alumno1.aprobar(Diseño);
		alumno8.InscribirCurso(Diseño);
		Diseño.inscribir(alumno8);
		Diseño.imprimirInscriptos();
		
		//Alumno2 aprueba Diseño, liberando un cupo,Alumno1 intenta inscribirse pero ya tiene el curso aprobado
		
		alumno2.aprobar(Diseño);
		Diseño.inscribir(alumno1);
		Diseño.imprimirInscriptos();
		
		
		
		//tratar de inscribir alumno1 por el metodo inscribirAlumno(materia aprobada)
		try {
			Diseño.inscribirAlumno(alumno1);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//el alumno9 se puede inscribir pero el no el alumno10 porque se alcanzo el cupo maximo
		
		try {
			Diseño.inscribirAlumno(alumno9);
			Diseño.inscribirAlumno(alumno10);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//alumno6 no se puede inscribir por falta de creditos
		try {
			Diseño.aprobarCurso(alumno9);
			Diseño.inscribirAlumno(alumno6);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//hay cupo para el alumno10 pero ya tiene 3 mat. en el mismo ciclo lectivo
		try {
			DIED.inscribirAlumno(alumno10);
			Economia.inscribirAlumno(alumno10);
			Analisis.inscribirAlumno(alumno10);
			
			Diseño.inscribirAlumno(alumno10);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Diseño.imprimirInscriptos();
		
		//Comparar si dos Alumnos son iguales por el N° de libreta
		
		System.out.println(alumno1.equals(alumno11));
	}
}
