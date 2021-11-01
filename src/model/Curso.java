package model;

public class Curso {
	
	private String nombre;
	private int numEstudiantes;
	private Estudiante primerEstudiante;
	private Estudiante ultimoEstudiante;
	
	public Curso(String nombre, int numEsturiantes) {
		this.nombre = nombre;
		this.numEstudiantes = numEsturiantes;
	}
	//no se usa
	public Curso(String nombre, int numEsturiantes, Estudiante estudiante) {

	}

	public void addEstudiante(Estudiante newEstudiante) {
		if(primerEstudiante == null) {	//si la lista esta vacia
			primerEstudiante = newEstudiante;
			ultimoEstudiante = newEstudiante;
			primerEstudiante.setSiguiente(ultimoEstudiante);
			primerEstudiante.setAnterior(ultimoEstudiante);
			ultimoEstudiante.setSiguiente(primerEstudiante);
			ultimoEstudiante.setAnterior(primerEstudiante);
		}else {
			ultimoEstudiante.setSiguiente(newEstudiante);
			newEstudiante.setSiguiente(primerEstudiante);
			newEstudiante.setAnterior(ultimoEstudiante);
			ultimoEstudiante = newEstudiante;
		}
	}
	//no se usa
	public void addEstudianteOrdenadamente(Estudiante newEstudiante) {
		
	}
	// regresa 1 si logra eliminar el estudiante y -1 en caso de que no lo entcuentre
	public int eliminarEstudiantes(String codigo) {
		
		Estudiante eliminar = primerEstudiante;
		
		do {
			if(eliminar.getCodigo().equals(codigo)) {
				if(eliminar == primerEstudiante && eliminar.getSiguiente() == primerEstudiante) {// solo hay un elemento y es el que buscamos
					primerEstudiante = null;
					return 1;
				}else {
					if(eliminar == primerEstudiante && eliminar.getSiguiente() != primerEstudiante) { // si hay almenos de elementos y el que se quiere eliminar es el primero
						primerEstudiante = primerEstudiante.getSiguiente();
						primerEstudiante.setAnterior(ultimoEstudiante);
						ultimoEstudiante.setSiguiente(primerEstudiante);
					}else {// hay mas de dos elementos y el que se quiere eliminar no es el primero
						Estudiante temp = eliminar.getAnterior();
						eliminar = eliminar.getSiguiente();
						eliminar.setAnterior(temp);
						temp.setSiguiente(eliminar);
						return 1;
					}
				}
			}else {
				eliminar = eliminar.getSiguiente();
			}
		}while(eliminar!=primerEstudiante);
		
		return -1;
	}
	
	public String pintarEstudiantes() {
		
		String listaEstudiantes="";
		Estudiante temp = primerEstudiante;
		
		if(temp == null) {
			listaEstudiantes = "No hay estudiantes en la lista";
		}else {
			do {
				listaEstudiantes+= temp.toString()+"\n";
				temp = temp.getSiguiente();
			}while(temp!=primerEstudiante);
		}
		return listaEstudiantes;
		
	}
	
	public void pintarAtrasAdelanteEstudiantes() {
		
	}
	
	public void pintarGeneral() {
		
	}
	
	public void pintarEstudiantesRecursivo(Estudiante student) {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEstudiantes() {
		return numEstudiantes;
	}

	public void setNumEstudiantes(int numEstudiantes) {
		this.numEstudiantes = numEstudiantes;
	}

	public Estudiante getPrimerEstudiante() {
		return primerEstudiante;
	}

	public void setPrimerEstudiante(Estudiante primerEstudiante) {
		this.primerEstudiante = primerEstudiante;
	}
	
	public Estudiante getUltimoEstudiante() {
		return ultimoEstudiante;
	}

	public void setUltimoEstudiante(Estudiante ultimoEstudiante) {
		this.ultimoEstudiante = ultimoEstudiante;
	}
		
}
