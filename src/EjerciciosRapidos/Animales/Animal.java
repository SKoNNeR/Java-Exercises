package EjerciciosRapidos.Animales;

public class Animal {
	protected String nombre;
	
	public Animal(String nombre) {						/// CREAMOS CONSTRUCTOR CON PARAMETRO REQUERIDO.
		this.nombre = nombre;
	}
	
	public void hacerSonido() {
		System.out.println("El animal hace un sonido genérico.");
	}

}
