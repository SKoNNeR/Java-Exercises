package BuscadorTareas;
import java.util.*;

public class BuscadorTareas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> listaDeTareas = new ArrayList<>();
		int resultadosEncontrados = 0;
		
		listaAdd(listaDeTareas);
		
		System.out.println("Qué quieres buscar?");
		String busqueda = scanner.nextLine();
		
		System.out.println("--- RESULTADOS ---");
		for (String tarea : listaDeTareas) {
			if (tarea.toLowerCase().contains(busqueda.toLowerCase())) {
				System.out.println(tarea);
				resultadosEncontrados++;
			}
			
		}
		
		if (resultadosEncontrados == 0) {
			System.out.println("No hay ninguna tarea con esos datos.");
		}
		
		scanner.close();
	}
	
	public static void listaAdd(ArrayList<String> listaDeTareas) {
		listaDeTareas.add("Pagar la factura de LUZ");
		listaDeTareas.add("Comprar LECHE y pan");
		listaDeTareas.add("Llamar al dentista");
		listaDeTareas.add("Terminar el informe de luz");
	}
}
