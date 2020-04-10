package died.guia06;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;



class AlumnoTest {
	
	Alumno alumno1=new Alumno("Juan Caprin",25286,10);
	Curso DIED=new Curso(1111,"DIED",2020,20,6,0);
	Curso Economia=new Curso(1112,"Economia",2020,20,6,2);	
	Curso Diseño=new Curso(1113,"Diseño",2020,20,6,5);
	Curso Analisis=new Curso(1114,"Analisis",2020,20,6,0);
			
			
	
	
	@Test
	void testCreditosObtenidos() {
		Integer resultado=18;
		
		DIED.inscribir(alumno1);
		Economia.inscribir(alumno1);
		Diseño.inscribir(alumno1);
		alumno1.aprobar(DIED);
		alumno1.aprobar(Economia);
		alumno1.aprobar(Diseño);
		
		assertEquals(resultado,alumno1.creditosObtenidos());
	}

	@Test
	void testAprobado() {
		DIED.inscribir(alumno1);
		alumno1.aprobar(DIED);
		boolean aprobado= alumno1.getAprobados().contains(DIED);
		assertTrue(aprobado);
	}
	
	@Test
	void testNoAprobado() {
		DIED.inscribir(alumno1);
		boolean aprobado= alumno1.getAprobados().contains(DIED);
		assertFalse(aprobado);
	}

	@Test
	void testInscripcionAceptada() {
		DIED.inscribir(alumno1);
		boolean inscripto=alumno1.getCursados().contains(DIED);
		assertTrue(inscripto);
	}
	
	@Test
	void testInscripcionNoAceptada() {
		boolean inscripto=alumno1.getCursados().contains(DIED);
		assertFalse(inscripto);
	}

}
