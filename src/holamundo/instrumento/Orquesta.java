package holamundo.instrumento;
import java.util.*;

public class Orquesta {

	public static void main(String[] args) {
		ArrayList<Instrumento> orquesta = new ArrayList<>();
		
		orquesta.add(new Violin("Stradivarius", 4));
		orquesta.add(new Trompeta("Yamaha", 3));
		orquesta.add(new Violin("Guarneri", 4));
		
		for (int i = 0; i < orquesta.size(); i++) {
			Instrumento instrumentoActual = orquesta.get(i);
			instrumentoActual.afinar();
			System.out.println("---------------");
			instrumentoActual.tocar();
			System.out.println("---------------");
		}
	}
}
