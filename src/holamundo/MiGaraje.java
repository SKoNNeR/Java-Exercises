package holamundo;
import java.util.ArrayList;

public class MiGaraje {

	public static void main(String[] args) {
		
		// PRIMER EJERCICIO ANTES DEL ARRAYLIST
//		Coche cocheDeJuan = new Coche("Toyota", "Corolla", 2022);
//		Coche cocheDeAna = new Coche("Ford", "Mustang", 1969);
//		
//		cocheDeJuan.mostrarInfo();
//		cocheDeAna.mostrarInfo();
//		
//		System.out.println("Solo el modelo del coche de ana es: " + cocheDeAna.getModelo());
//		
//		System.out.println("El coche de juane es: " + cocheDeJuan.getModelo());
//		
//		cocheDeJuan.setModelo("RAV4");
//		cocheDeJuan.setYear(1899);
//		System.out.println("Juan cambia su modelo por el: " + cocheDeJuan.getModelo() + " del año: " + cocheDeJuan.getYear());
//		
//		CocheDeportivo miFerrari = new CocheDeportivo("Ferrari", "488 Pista", 2020, 720);
//		
//		miFerrari.mostrarInfo(); // Debería mostrar la info con los CV
//
//		// Prueba que heredó los métodos de Coche:
//		System.out.println("La marca del Ferrari es: " + miFerrari.getMarca());
//		
//		CocheDeportivo mi2Ferrari = new CocheDeportivo("Ferrari 2", "488 Pista", 2020, 10);
//		mi2Ferrari.mostrarInfo(); // Debería mostrar la info con los CV
//		
//		
//		// Esto es Polimorfismo:
//		Coche miNuevoVehiculo = new CocheDeportivo("Lamborghini", "Huracan", 2023, 640);
//		
//		miNuevoVehiculo.mostrarInfo();
		// PRIMER EJERCICIO ANTES DEL ARRAYLIST
		
		
		
		// COMIENZA SEGUNDO EJERCICIO:
		// se usa un arraylist a una variable y se muestra después recorriendo
		// una lista con el for
		ArrayList<Coche> miGaraje = new ArrayList<>();
		
		Coche cocheDeJuan = new Coche("Toyota", "Corolla", 2022);
		Coche cocheDeIrene = new Coche("Renault", "Clio", 1999);
		CocheDeportivo miFerrari = new CocheDeportivo("Ferrari", "488 Pista", 2020, 720);
		
		miGaraje.add(cocheDeJuan);
		miGaraje.add(cocheDeIrene);
		miGaraje.add(miFerrari); // válido gracias al polimorfismo.
		
		System.out.println("Vehículos en mi Garaje");
		for(int i = 0; i < miGaraje.size(); i++) {
			Coche vehiculoActual = miGaraje.get(i); // sacamos un coche de la lista
			vehiculoActual.mostrarInfo(); // llamamos amétodo que muestra resultado en terminal
		}
	}
}

