package EjerciciosRapidos.Animales;

public class Gato extends Animal {
	
	public Gato (String nombre) {
		super(nombre);
	}
	
	@Override
	public void hacerSonido() {
		System.out.println(nombre);
		System.out.println("Miauu Miauu");
	}
	

}
