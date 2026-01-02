package inventarioRPG;

import java.util.Objects;

public class Producto implements Mostrable{
	
	/* --------------------- ATRIBUTOS --------------------- */
	private final int id;
	private final String nombre;
	private final double precio;
	
	/* --------------------- CONSTRUCTOR --------------------- */
	public Producto(int id, String nombre, double precio) {
		this.id= id;
		this.nombre= nombre;
		this.precio= precio;
	}
	
	/* --------------------- GETTERS --------------------- */
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Nombre: " + nombre + " | Precio: " + precio + " de oro.";
	}

	@Override
	public String showInfo() {
		// TODO Auto-generated method stub
		return toString();
	}
	
}
