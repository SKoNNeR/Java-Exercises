package EjerciciosRapidos.Animales;

public class Perro extends Animal{
	
	public Perro(String nombre) {
		super(nombre);
	}
	
	@Override
	public void hacerSonido() {
		System.out.println(nombre);
		System.out.println("Guau Guau");
	}

}
