package died.guia06;

import java.util.List;


public class Alumno {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	private Integer creditos;

	public int creditosObtenidos() {
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
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

}
