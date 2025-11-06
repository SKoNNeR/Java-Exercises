package pooExercises.poo5;

import java.util.Scanner;

public class Uso_Sucursal_y_Paquetes {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Introduce la dirección de la sucursal");
		String direccion= scanner.nextLine();
		
		System.out.println("Introduce la ciudad de la sucursal");
		String ciudad= scanner.nextLine();
		
		Sucursal sucursal1= new Sucursal(direccion, ciudad);
		
		System.out.println("¿Cuántos paquetes quieres enviar?");
		int numPaquetesEnviar= scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numPaquetesEnviar; i++) {
			System.out.println("Introduce la referencia de envío:");
			String refEnvio= scanner.nextLine();
			
			System.out.println("Introduce el peso del paquete:");
			double peso= scanner.nextDouble();
			scanner.nextLine();
			
			System.out.println("Introduce prioridad: 0 para Normal, 1 para Alta, 2 para Urgente");
			int prioridad= scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Introduce el DNI del remitente:");
			String dni= scanner.nextLine();
			
			Paquete paquete= new Paquete(refEnvio, peso, prioridad, dni);
			
			double precio= sucursal1.calculaPrecioEnvio(paquete);
			
			System.out.println("Datos del Envío");
			System.out.println("Sucursal ID: " + sucursal1.getNumSucursal() );
			System.out.println("Dirección de la Sucursal: " + sucursal1.getDireccion());
			System.out.println("Ciudad de la Sucursal " + sucursal1.getCiudad());
			System.out.println("Referencia paquete: " + paquete.getRefEnvio());
			System.out.println("Peso del paquete: " + paquete.getPeso());
			System.out.println("Prioridad del paquete: " + paquete.getPrioridad());
			System.out.println("Precio del envio: " + precio);
			
		}
		
		scanner.close();
	}
}

class Sucursal {
	private int numSucursal;
	private String direccion;
	private String ciudad;
	private static int conteoSucursales= 1;
	
	public Sucursal(String direccion, String ciudad) {
		this.direccion= direccion;
		this.ciudad= ciudad;
		numSucursal= conteoSucursales;
		conteoSucursales++;
	}
	
	// getters
	public int getNumSucursal() {
		return numSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	
	public double calculaPrecioEnvio(Paquete p) {
		double precioBase= p.getPeso()*2;
		switch(p.getPrioridad()) {
		case 1 -> precioBase+= 10;
		case 2 -> precioBase+= 20;
		}
		return precioBase;
	}
}

class Paquete {
	private String refEnvio;
	private double peso;
	private String dni;
	private int prioridad;
	
	public Paquete(String refEnvio, double peso, int prioridad, String dni) {
		this.refEnvio= refEnvio;
		this.peso= peso;
		this.dni= dni;

		if (prioridad < 0 || prioridad > 2) {
			System.out.println("Error: Prioridad Invalida, ajustando envío por defecto a Normal.");
			this.prioridad=0;
		} else {
			this.prioridad= prioridad;
		}
	}
	
	// setters
	public void setPeso(double peso) {
		if(peso!=0) this.peso= peso;
		else System.out.println("Error: Peso inválido.");
	}
	public void setPrioridad(int prioridad) {
		if (prioridad==0) this.prioridad=0;
		else if (prioridad==1) this.prioridad=1;
		else if (prioridad==2) this.prioridad=2;
		else {
			System.out.println("ERROR: Prioridad invalida. Añadiendo paquete en prioridad por Defecto: Normal.");
			this.prioridad= 0;
		}
	}
	
	// getters
	public double getPeso() {
		return peso;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public String getRefEnvio() {
		return refEnvio;
	}
	public String getDni() {
		return dni;
	}
}
