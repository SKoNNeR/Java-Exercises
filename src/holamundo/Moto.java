package holamundo;

public class Moto {
	private String marca;
	private String modelo;
	private int year;
	
	public Moto(String marca, String modelo, int year) {
		this.marca = marca;
		this.modelo = modelo;
		this.year = year;
	}

	public void mostrarInfo() {
		System.out.println("Marca: " + this.marca + " Modelo: " + this.modelo + " Año: " + this.year);
	}

}
