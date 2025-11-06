package EjerciciosRapidos.Animales;

import java.util.ArrayList;

public class Zoologico {
	public static void main(String[] args) {
		
		ArrayList<Animal> animalesDelZoo = new ArrayList<>();
		animalesDelZoo.add(new Perro("Willy"));
		animalesDelZoo.add(new Perro("Toby"));
		animalesDelZoo.add(new Perro("Alaska"));
		
		for (Animal a : animalesDelZoo) {
			System.out.println();
			a.hacerSonido();
		}
		
//		Perro ricky = new Perro("Ricky");
//		Gato olivia = new Gato("Olivia");
//		
//		ricky.hacerSonido();
//		olivia.hacerSonido();
			
	}

}
