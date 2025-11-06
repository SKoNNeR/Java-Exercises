package holamundo;

public class Coche {
	
	// 1. CAMPOS (FIELDS)
	private String marca;
	private String modelo;
	private int year;
	
	
	// 2. CONSTRUCTOR
	public Coche(String marca, String modelo, int year) {
		this.marca = marca;
		this.modelo = modelo;
		this.year = year;
	}
	
	
	// 3. MÉTODOS (METHODS)
	public void mostrarInfo() {
		System.out.println("Coche: " + this.marca + " " + this.modelo + ", Año: " + this.year);
	}
	
	// GETTERS //
	public String getMarca() {
		return this.marca;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public int getYear() {
		return this.year;
	}
	
	
	
	// --- SETTERS --- //	
	public void setMarca(String nuevaMarca) {
		this.marca = nuevaMarca;
	}
	
	public void setModelo(String nuevoModelo) {
		this.modelo = nuevoModelo;
	}
	
	public void setYear(int nuevoYear) {
		if (nuevoYear > 1900) {  // CHECK IF HIGHER OF 1900
			this.year = nuevoYear;
		} else {
			System.out.println("El año introducido no es correcto.");
		}
		
	}
}

