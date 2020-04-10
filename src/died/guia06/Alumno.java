package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	private Integer creditos;

	public Integer creditosObtenidos() {
		Integer sumaPuntos=0;
		for(Curso unCurso: aprobados) {
			if(unCurso!=null) {
				sumaPuntos=sumaPuntos+unCurso.getCreditos();
			}
		}
		return sumaPuntos;
	}

	public void aprobar(Curso c) {
		if(cursando.contains(c)) {
			cursando.remove(c);
			aprobados.add(c);
			System.out.println("Curso Aprobado");
		}
		System.out.println("Usted no esta cursando el curso seleccionado.");
	}

	public void inscripcionAceptada(Curso c) {
		if(cursando.contains(c)) {
			System.out.println("Usted esta inscripto en el curso.");
		}
		else {
			System.out.println("Usted no esta inscripto en el curso.");
		}
		
	}
	
	public boolean cumpleConCreditos(Integer creditosNec) {
		boolean resultado=false;
		if(this.creditos>=creditosNec) {
			resultado=true;
		}
		return resultado;
	}
	
	public boolean comprobarCicloLec(Integer CicloLec) {
		int contador=0;
		boolean resultado=false;
		for(Curso unCurso: cursando) {
			if(unCurso!=null) {
				if(unCurso.getCicloLec() == CicloLec) {
					contador++;
				}
			}
		}
		if(contador<3) resultado=true;
		return resultado;
	}
	
	public boolean equals(Alumno a) {
		boolean resultado=false;
		if(this.nroLibreta==a.nroLibreta) {
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

}
