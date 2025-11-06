package ejercicio.poo1.poo4;


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
				"\nNombre Compañia: " + this.getNombreCompañia();
	}
}



class Compañia {
	private String nombreCompañia;
	private Empleado[] listaEmpleados;
	private int posicionArray= 0;
	
	public Compañia(String nombreCompañia, int numMaxEmpleados) {
		this.nombreCompañia= nombreCompañia;
		this.listaEmpleados= new Empleado[numMaxEmpleados];
	}
	
	// getters
	public String getNombreCompañia() {
		return nombreCompañia;
	}
	public void contratarEmpleado(String nombreEmpleado, double salario) {
		Empleado nuevoContrato= new Empleado(this, nombreEmpleado, salario);
		listaEmpleados[posicionArray]= nuevoContrato;
		posicionArray++;
	}
	public void getTodosEmpleados() {
		for (int i=0; i<posicionArray; i++) {
				System.out.println(listaEmpleados[i].toString());
				System.out.println("--------------------------");
		}
	}
	public void getDatosEmpleados(String nombreEmpleado) {
		boolean encontrado= false;
		for (int i=0; i<posicionArray; i++) {
			if (nombreEmpleado.equalsIgnoreCase(listaEmpleados[i].getNombre())) {
				System.out.println("--- Usuario Encontrado ---");
				System.out.println(listaEmpleados[i].toString());
				System.out.println("--------------------------");
				encontrado= true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Empleado no encontrado.");
		}
	}
	
	// setters
	public void despedirEmpleado(String nombreEmpleado) {
		boolean encontrado= false;
		for (int i=0; i<posicionArray; i++) {
			if (nombreEmpleado.equalsIgnoreCase(listaEmpleados[i].getNombre())) {
				listaEmpleados[i]= listaEmpleados[posicionArray-1];
				listaEmpleados[posicionArray-1]= null;
				encontrado= true;
				break;
			}
		}
		if (encontrado) posicionArray--;
	}
	public void subirSalario(String nombreEmpleado, double salario) {
		boolean encontrado= false;
		for (int i=0; i<posicionArray; i++) {
			if (nombreEmpleado.equalsIgnoreCase(listaEmpleados[i].getNombre())) {
				listaEmpleados[i].setSalario(salario);
				encontrado= true;
				break;
			}
		}
		if (!encontrado) System.out.println("Empleado no encontrado.");
	}
}

