package ejercicio.poo1.poo4;

import org.hamcrest.CustomTypeSafeMatcher;

public class UsoCompañia {
	public static void main(String[] args) {
		
	}
}



class Empleado {
	private Compañia miCompañia;
	private String nombreEmpleado;
	private double salario;
	private double salarioBase;
	private static int contadorEmpleados= 1;
	private int idEmpleado;
	
	public Empleado(Compañia c, String nombreEmpleado, double salario) {
		this.miCompañia= c;
		this.nombreEmpleado= nombreEmpleado;
		this.salario= salario;
		this.salarioBase= 1500;
		idEmpleado= contadorEmpleados;
		contadorEmpleados++;
	}
	
	// setters
	public void setSalario(double nuevoSalario) {
		if (nuevoSalario>=salarioBase) this.salario= nuevoSalario;  // no se puede bajar el suelo. protección del empleado.
	}
	
	// getters
	public String getNombre() {
		return nombreEmpleado;
	}
	private String getNombreCompañia() {
		return this.miCompañia.getNombreCompañia();
	}
	public String toString() {
		return "El ID del empleado es: " + this.idEmpleado + 
				"\nNombre: " + this.nombreEmpleado + 
				"\nSalario : " + this.salario + 
				"\nNombre Compañia: " + this.miCompañia.getNombreCompañia();
	}
}



class Compañia {
	private String nombreCompañia;
	private Empleado [] listaEmpleados[];
	private int posicionArray;
	
	public Compañia(String nombreCompañia, int numMaxEmpleados) {
		this.nombreCompañia= nombreCompañia;
		listaEmpleados[]= listaEmpleados[numMaxEmpleados];
	}
	
	// getters
	public String getNombreCompañia() {
		return nombreCompañia;
	}
	public void contratarEmpleado(String nombreEmpleado, double salario) {

	}
	
}

