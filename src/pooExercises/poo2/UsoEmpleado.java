package pooExercises.poo2;

import java.util.Scanner;

public class UsoEmpleado {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Introduce el nombre del Empleado:");
		String nombre= scanner.nextLine();
		
		System.out.println("Introduce el ID del Empleado:");
		int idEmpleado= scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Introduce el Salario Base del Empleado:");
		double salarioBase= scanner.nextDouble();
		scanner.nextLine();
		
		Empleado empleado1= new Empleado(nombre, idEmpleado, salarioBase);
		
		System.out.println("Introduce las deducciones:");
		double deducciones= scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Introduce las bonificaciones:");
		double bonificaciones= scanner.nextDouble();
		scanner.nextLine();
		
		double salarioNetoMes= empleado1.calcularSalarioBaseNeto(deducciones, bonificaciones);
		
		System.out.println("Nombre del empleado: " + empleado1.getNombre() + "\nID Empleado: " + empleado1.getIdEmpleado());
		
		System.out.println("Salario en Bruto: " + empleado1.getSalarioBase());
		System.out.println("Salario en Neto: " + salarioNetoMes);
				
		scanner.close();
	}
}

class Empleado {
	private String nombre;
	private int idEmpleado;
	private double salarioBase;
	
	public Empleado(String nombre, int idEmpleado, double salarioBase) {
		this.nombre= nombre;
		this.idEmpleado= idEmpleado;
		this.salarioBase= salarioBase;		
	}
	
	// getters
	public String getNombre() {
		return nombre;		
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	
	public double calcularSalarioBaseNeto(double deducciones, double bonificaciones) {
		return salarioBase - deducciones + bonificaciones;
	}
}