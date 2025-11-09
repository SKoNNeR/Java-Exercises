package pooExercises.poo7;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClaseAbstracta {
	public static void main(String[] args) {
		
		Empleado[] listaEmpleados = new Empleado[4];
		
		listaEmpleados[0]= new EmpleadoAsalariado("6546546Z", "Antonio", "López", new GregorianCalendar(2014, 01, 01), 1125);
		listaEmpleados[1]= new EmpleadoComision("7879879S", "Sandra", "Nieto", new GregorianCalendar(2011,1,1), 169, 7.10);
		listaEmpleados[2]= new EmpleadoComision();
		listaEmpleados[3]= new EmpleadoAsalariado();
		
		listaEmpleados[2].setDNI("4654654D");
		listaEmpleados[2].setNombre("Manuel");
		listaEmpleados[2].setApellidos("Ruíz");
		listaEmpleados[2].setFechaAlta(2010,0,20);
		EmpleadoComision empleadoComision2= (EmpleadoComision) listaEmpleados[2];
		empleadoComision2.setClientesCaptados(5);
		empleadoComision2.setGananciasPorCliente(6.90);
		
		listaEmpleados[3].setDNI("77879878F");
		listaEmpleados[3].setNombre("María");
		listaEmpleados[3].setApellidos("Ramos");
		listaEmpleados[3].setFechaAlta(2011, 5, 11);
		EmpleadoAsalariado empleadoAsalariado3= (EmpleadoAsalariado) listaEmpleados[3];
		empleadoAsalariado3.setSueldo(1055);
		
		Empleado.mostrarTodos(listaEmpleados);
		Empleado.getSueldoMayor(listaEmpleados);
		
		
	}
}

abstract class Empleado {
	private String dni;
	private String nombre;
	private String apellidos;
	private GregorianCalendar fechaAlta;
	private int day;
	private int month;
	private int year;
	private String date;
	
	public Empleado() {
		
	}
	
	public Empleado(String dni, String nombre, String apellidos, GregorianCalendar fechaAlta) {
		this.dni= dni;
		this.nombre= nombre;
		this.apellidos= apellidos;
		this.fechaAlta= fechaAlta;
		day= fechaAlta.get(Calendar.DAY_OF_MONTH);
		month= fechaAlta.get(Calendar.MONTH)+1;
		year= fechaAlta.get(Calendar.YEAR);
		date= day + "-" + month + "-" + year;
	}
	
	// GETTERS
	public abstract double getSalario();
	
	public static void mostrarTodos(Empleado[] arrayEmpleados) {
		for (Empleado e: arrayEmpleados) {
			System.out.println(e.imprimir() + " con un sueldo de " + e.getSalario() + "€");
		}
	}
	public static void getSueldoMayor(Empleado[] arrayEmpleados) {
		double sueldoMasAlto= arrayEmpleados[0].getSalario();
		Empleado empleadoGanador= arrayEmpleados[0];
		
		for (int i=0; i<arrayEmpleados.length; i++) {
			double sueldoActual= arrayEmpleados[i].getSalario();
			if (sueldoActual > sueldoMasAlto) {
				sueldoMasAlto= sueldoActual;
				empleadoGanador= arrayEmpleados[i];
			}
		}
		System.out.println("El sueldo más alto lo tiene: " + empleadoGanador.imprimir() + " con un sueldo: " + empleadoGanador.getSalario());
	}
	
	public String imprimir() {
		return "DNI: " + dni + " Nombre: " + nombre + " " + apellidos + " Fecha de Alta: " + date;
	}
	public int getYear() {
		return year;
	}
	public String getDNI() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	// SETTERS
	public void setDNI(String dni) {
		this.dni= dni;
	}
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos= apellidos;
	}
	public void setFechaAlta(int year, int month, int day) {
		this.fechaAlta= new GregorianCalendar(year, month, day);
		this.day= fechaAlta.get(Calendar.DAY_OF_MONTH);
		this.month= fechaAlta.get(Calendar.MONTH)+1;
		this.year= fechaAlta.get(Calendar.YEAR);
		this.date= day + "-" + month + "-" + year;
	}
}

class EmpleadoAsalariado extends Empleado {
	private double sueldoBase;
	
	public EmpleadoAsalariado() {
		super();
	}
	
	public EmpleadoAsalariado(String dni, String nombre, String apellidos, GregorianCalendar fechaAlta) {
		super(dni, nombre, apellidos,fechaAlta);
		sueldoBase= 1500;
	}
	public EmpleadoAsalariado(String dni, String nombre, String apellidos, GregorianCalendar fechaAlta, double sueldoBase) {
		super(dni, nombre, apellidos, fechaAlta);
		this.sueldoBase= sueldoBase;
	}
	
	public double getSalario() {
		Calendar calendarioHoy= Calendar.getInstance();
		int actualYear= calendarioHoy.get(Calendar.YEAR);
		int year= this.getYear();
		int diffYears= actualYear-year;
		if (diffYears>=9) return sueldoBase + ((sueldoBase*17)/100);
		else if (diffYears>=4 && diffYears<=8) return sueldoBase + ((sueldoBase*11)/100);
		else if (diffYears>2 && diffYears<=3) return sueldoBase + ((sueldoBase*7)/100);
		else return sueldoBase;		
	}
	public void setSueldo(double sueldoBase) {
		this.sueldoBase= sueldoBase;
	}
	
}

class EmpleadoComision extends Empleado {
	private final double sueldoComision= 950;
	private int clientesCaptados;
	private double gananciasPorCliente;
	
	public EmpleadoComision() {
		super();
	}

	public EmpleadoComision(String dni, String nombre, String apellidos, GregorianCalendar fechaAlta) {
		super(dni, nombre, apellidos, fechaAlta);
	}
	
	public EmpleadoComision(String dni, String nombre, String apellidos, GregorianCalendar fechaAlta, int clientesCaptados, double gananciasPorCliente) {
		super(dni, nombre, apellidos, fechaAlta);
		this.clientesCaptados= clientesCaptados;
		this.gananciasPorCliente= gananciasPorCliente;
	}

	public void setClientesCaptados(int clientesCaptados) {
		this.clientesCaptados= clientesCaptados;
	}
	public void setGananciasPorCliente(double ganancias) {
		this.gananciasPorCliente= ganancias;
	}

	@Override
	public double getSalario() {
		double suma= clientesCaptados*gananciasPorCliente;
		if (suma>sueldoComision) return Math.round(suma);
		else return sueldoComision;
	}
}