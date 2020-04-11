package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	
	Alumno alumno1,alumno2,alumno3,alumno4,alumno5;
	Curso DIED,Economia,Diseño,Analisis;
	
	@BeforeEach
	void init() {
		alumno1=new Alumno("Juan",25286,10);
		alumno2=new Alumno("Esteban",25486,2);
		alumno3=new Alumno("Horacio",25986,10);
		alumno4=new Alumno("Migel",25186,10);
		alumno5=new Alumno("Ramon",25386,10);
		DIED=new Curso(1111,"DIED",2020,20,6,0);
		Economia=new Curso(1112,"Economia",2020,20,6,3);	
		Diseño=new Curso(1113,"Diseño",2020,1,6,5);
		Analisis=new Curso(1114,"Analisis",2020,20,6,0);
	}
	
	@Test
	void testInscribirFunciona() {
		assertTrue(DIED.inscribir(alumno1));
	}
	
	@Test
	void testInscribirFallaCondCred() {
		assertFalse(Economia.inscribir(alumno2));
	}
	
	@Test
	void testInscribirFallaCondCupo() {
		Diseño.inscribir(alumno1);
		assertFalse(Diseño.inscribir(alumno2));
	}
	
	@Test
	void testInscribirFallaCondCicloLec() {
		Diseño.inscribir(alumno1);
		Economia.inscribir(alumno1);
		DIED.inscribir(alumno1);
		assertFalse(Analisis.inscribir(alumno1));
	}
	
	@Test
	void testImprimirInscriptos() {
		List<Alumno> lista=new ArrayList<Alumno>();
		lista.add(alumno2);
		lista.add(alumno3);
		lista.add(alumno1);
		lista.add(alumno4);
		lista.add(alumno5);
		DIED.inscribir(alumno1);
		DIED.inscribir(alumno2);
		DIED.inscribir(alumno3);
		DIED.inscribir(alumno4);
		DIED.inscribir(alumno5);
		DIED.imprimirInscriptos();
		assertEquals(lista, DIED.getInscriptos());
	}
	

}
