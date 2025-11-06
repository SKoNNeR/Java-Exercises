package ejercicio.poo1.poo1;

public class UsoProducto {
	public static void main(String[] args) {
		Producto tecladoUSB= new Producto("AX3399-1", "Razer Blackwidow", 15.0, 100);
		System.out.println(tecladoUSB.getStock());
		
		tecladoUSB.vender(100);
		System.out.println(tecladoUSB.getStock());
		
		tecladoUSB.reponer(50);
		System.out.println(tecladoUSB.getStock());
		
		System.out.println("Nombre del producto: " + tecladoUSB.getNombre() + " y un stock de: " + tecladoUSB.getStock() + " unidades.");
	}
}

class Producto {
	private String codigo;
	private String nombre;
	private double precio;
	private int cantidadStock;
	
	public Producto(String codigo, String nombre, double precio, int cantidadStock) {
		this.codigo= codigo;
		this.nombre= nombre;
		this.precio= precio;
		this.cantidadStock= cantidadStock;
		
	}
	
	public void vender(int cantidad) {
		if (cantidad<=cantidadStock) this.cantidadStock-= cantidad;
		else System.out.println("Cantidad insuficiente. Venta cancelada.");
	}
	public void reponer(int cantidad) {
		this.cantidadStock+= cantidad;
	}
	
	// getters
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public int getStock() {
		return cantidadStock;
	}
	
	// setters
	public void setPrecio(double precio) {
		this.precio= precio;
	}
}