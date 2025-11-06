package GestorInventario;

public class Producto {
	private String nombre;
	private int cantidad;
	private double precio;
	
	public Producto(String nombre, int cantidad, double precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public String getNombre() { 
		return this.nombre;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public double getPrecio() {
		return this.precio;
	}
	
	public void setCantidad(int nuevaCantidad) {
		if (nuevaCantidad >= 0) {
			this.cantidad = nuevaCantidad;
		} else {
			System.out.println("ERROR: Cantidad invalida.");
		}	
	}
	
	public void setPrecio(double nuevoPrecio) {
		if (nuevoPrecio > 0) {
			this.precio = nuevoPrecio;
		} else {
			System.out.println("ERROR: Precio erroneo.");
		}
	}
	
	public void mostrarInfo() {
		System.out.println("Producto: " + getNombre() + " (Stock: " + getCantidad() + ") - Precio: " + getPrecio() + "€");
	}
}
