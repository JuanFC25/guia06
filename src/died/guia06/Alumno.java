package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	private Integer creditos;

	//constructores
	
	public Alumno() {
		this.cursando=new ArrayList<Curso>();
		this.aprobados=new ArrayList<Curso>();
		
		
	}
	
	public Alumno(String nombre,Integer nroLibreta,Integer cred) {
		this.creditos=cred;
		this.nombre=nombre;
		this.nroLibreta=nroLibreta;
		this.cursando=new ArrayList<Curso>();
		this.aprobados=new ArrayList<Curso>();
	}
	
	
	//metodos
	
	//testeado
	public Integer creditosObtenidos() {
		Integer sumaPuntos=0;
		for(Curso unCurso: aprobados) {
			if(unCurso!=null) {
				sumaPuntos=sumaPuntos+unCurso.getCreditos();
			}
		}
		return sumaPuntos;
	}

	//testeado
	public void aprobar(Curso c) {
		if(cursando.contains(c)) {
			cursando.remove(c);
			aprobados.add(c);
			System.out.println("Curso Aprobado");
		}
		System.out.println("Usted no esta cursando el curso seleccionado.");
	}

	//testeado
	public void inscripcionAceptada(Curso c) {
		if(cursando.contains(c)) {
			System.out.println("Usted esta inscripto en el curso.");
		}
		else {
			System.out.println("Usted no esta inscripto en el curso.");
		}
		
	}
	
	//testeado
	public boolean cumpleConCreditos(Integer creditosNec) {
		boolean resultado=false;
		if(this.creditos>=creditosNec) {
			resultado=true;
		}
		return resultado;
	}
	
	//testeado
	public boolean comprobarCicloLec(Integer CicloLec) {
		int contador=0;
		boolean resultado=false;
		for(Curso unCurso: cursando) {
			if(unCurso!=null) {
				if(unCurso.getCicloLec().equals(CicloLec)) {
					contador++;
				}
			}
		}
		if(contador<3) resultado=true;
		return resultado;
	}
	
	//testeado
	public boolean equals(Alumno a) {
		boolean resultado=false;
		if(nroLibreta.equals(a.nroLibreta)) {
			resultado=true;
		}
		return resultado;
	}

	public void InscribirCurso(Curso c) {
		cursando.add(c);
	}

	@Override
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}

	public List<Curso> getAprobados() {
		return this.aprobados;
	}
	public List<Curso> getCursados() {
		return this.cursando;
	}
	
	@Override
	public String toString() {
		return (this.nombre + " N° libreta: " + this.nroLibreta);
	}
	
	public Integer getNLibreta() {
		return nroLibreta;
	}
}
