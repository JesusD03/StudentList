package ui;

import model.Curso;
import model.Estudiante;

public class Main {
	
	private static Curso curso;
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		curso = new Curso("APOII", 5);
		curso.addEstudiante(new Estudiante("A001", "pepito"));
		curso.addEstudiante(new Estudiante("A002", "juan"));
		curso.addEstudiante(new Estudiante("A003", "pedro"));
		curso.addEstudiante(new Estudiante("A004", "carlos"));
		curso.addEstudiante(new Estudiante("A005", "pablo"));
		System.out.println(curso.pintarEstudiantes());
		if(curso.eliminarEstudiantes("A003")==1) {
			System.out.println("se elimino al estudiante de la lista\n");
			System.out.println(curso.pintarEstudiantes());
		}else {
			System.out.println("no se encontro al estudiante\n");
		}
	}
	
}
