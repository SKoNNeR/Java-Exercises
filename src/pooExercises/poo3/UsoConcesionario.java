package pooExercises.poo3;

import java.util.Scanner;

public class UsoConcesionario {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		Coche[] coches= new Coche[3];
		
//		for (int i=0; i<coches.length; i++) {
//			System.out.println("Introduce la matrícula:");
//			String matricula= scanner.nextLine();
//			System.out.println("Introduce la marca:");
//			String marca= scanner.nextLine();
//			System.out.println("Introduce el modelo:");
//			String modelo= scanner.nextLine();
//			System.out.println("Introduce el precio:");
//			double precio= scanner.nextDouble();
//			scanner.nextLine();
//			
//			coches[i]= new Coche(matricula, marca, modelo, precio);
//		}
		
		coches[0] = new Coche("1234A", "Ford", "Fiesta", 15000);

		coches[1] = new Coche("5678B", "Toyota", "Corolla", 22000);

		coches[2] = new Coche("9012C", "Seat", "Ibiza", 13000);
		
		for (Coche c: coches) {
			System.out.println(c.toString());
		}
		
		for (int i=0; i<coches.length; i++) {
			if (coches[i] != null) {
				System.out.println(coches[i].toString());
			}
		}
		
		System.out.println("Introduce la matrícula para buscar:");
		String userSearch= scanner.nextLine();
		boolean encontrado= false;
		for (int i=0; i<coches.length; i++) {
			if (coches[i] != null) {
				if (userSearch.equals(coches[i].getMatricula())) {
					System.out.println("Vehículo encontrado!");
					System.out.println(coches[i]);
					encontrado= true;
				}	
			}
		}
		if (!encontrado) System.out.println("Vehículo no encontrado.");
		
		scanner.close();
	}
}

// clase
class Coche {
	
	// propiedades clase.
	private String matricula;
	private String marca;
	private String modelo;
	private double precio;
	
	// constructor
	public Coche(String matricula, String marca, String modelo, double precio) {
		this.matricula= matricula;
		this.marca= marca;
		this.modelo= modelo;
		this.precio= precio;
	}
	
	// showTime
//	public void getInfo() {
//		System.out.println("__ Coche __");
//		System.out.println(" Marca: " + marca);
//		System.out.println(" Modelo: " + modelo);
//		System.out.println(" Matrícula: " + matricula);
//		System.out.println(" Precio: " + precio + "€");
//	}
	
	// toString datosCoche
	public String toString() {
		return " Marca: " + marca + "\n Modelo: " + modelo + "\n Matrícula: " + matricula + "\n Precio: " + precio + "€\n";
	}
	
	// getters
	public String getMatricula() {
		return matricula;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public double getPrecio() {
		return precio;
	}
	
	// setters
	public void setMatricula(String matricula) {
		this.matricula= matricula;
	}
	public void setMarca(String marca) {
		this.marca= marca;
	}
	public void setModelo(String modelo) {
		this.modelo= modelo;
	}
	public void setPrecio(double precio) {
		if (precio>0) this.precio= precio;
		else System.out.println("Error: Precio incorrecto.");
	}
}