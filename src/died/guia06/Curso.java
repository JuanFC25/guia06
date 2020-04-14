package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import died.guia06.util.*;
import java.util.List;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id,String nombre,Integer cicloLec,Integer cupo, 
			Integer cred,Integer credReq) {
		this.id=id;
		this.nombre=nombre;
		this.cicloLectivo=cicloLec;
		this.cupo=cupo;
		this.creditos=cred;
		this.creditosRequeridos=credReq;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	

	/**
	 * Este mettodo, verifica si el alumno se puede inscribir y si es asi≠ lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que esta inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno esta inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simult√°neo a no m√°s de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	
	//testeado(sin excepcion)
	public Boolean inscribir(Alumno a) {
	
		try {
			if(a.cumpleConCreditos(creditosRequeridos) && inscriptos.size()< this.cupo && 
			   a.comprobarCicloLec(this.cicloLectivo)) {
					if(!inscriptos.contains(a) && !a.cursoYaAprobado(this)){
					log.registrar(this, "inscribir ",a.toString());
					inscriptos.add(a);
					a.InscribirCurso(this);
					
					return true;
				}
			}
		
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error con el archivo registro. No se realizo la inscripcion, intente nuevamente");
			return false;
		} 
		
		return false;
	}
	
	
	public void imprimirInscriptosPorNLibreta() {
		try {
			log.registrar(this, "imprimir listado N∞ Libreta",this.inscriptos.size()+ " registros ");
			CompararNLibreta comparador=new CompararNLibreta();
			Collections.sort(inscriptos,comparador);
			System.out.println("");
			System.out.println("Alumnos inscriptos por Nro de Libreta:");
			for(Alumno unAlumno: this.inscriptos) {
				if(unAlumno!=null) {
					System.out.println(unAlumno.toString());
				}
			}
			System.out.println("");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error con el archivo registro. No se realizo la inscripcion, intente nuevamente");
		}
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	
	//testeado(sin excepcion)
	public void imprimirInscriptos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			Collections.sort(inscriptos);
			System.out.println("");
			System.out.println("Alumnos inscriptos por orden alfabetico:");
			for(Alumno unAlumno: this.inscriptos) {
				if(unAlumno!=null) {
					System.out.println(unAlumno.toString());
				}
			}
			System.out.println("");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error con el archivo registro. No se realizo la inscripcion, intente nuevamente");
		}
	}
	

	public Integer getCicloLec() {
		return this.cicloLectivo;
	}

	public Integer getCreditos() { 
		return this.creditos;
	}
	
	public List<Alumno> getInscriptos() { 
		return this.inscriptos;
	}

	public void aprobarCurso(Alumno a){
		inscriptos.remove(a);
	}
	
	//nuevo metodo
	
	public void inscribirAlumno(Alumno a) throws RegistroAuditoriaException,
	CreditosInsuficientesException,MasDeTresMatPorCicloException,CupoLlenoException,CursoYaAprobadoException{
		try {
			if(!(inscriptos.size()<cupo)) throw new CupoLlenoException();
			if(a.cursoYaAprobado(this)) throw new CursoYaAprobadoException();
			if(!a.cumpleConCreditos(creditosRequeridos)) throw new CreditosInsuficientesException();
			if(!a.comprobarCicloLec(cicloLectivo)) throw new MasDeTresMatPorCicloException();
			log.registrar(this, "inscribir ",a.toString());
			inscriptos.add(a);
			a.InscribirCurso(this);
		} catch (IOException e) {
			throw new RegistroAuditoriaException();
		}
	}
	
}
