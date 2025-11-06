package holamundo;
import java.util.Scanner;
import java.util.ArrayList;

public class ListaDeTareas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> tareas = new ArrayList<>();
		
		while (true) {
			System.out.println("--- LISTA MENÚ ---");
			System.out.println("1. Añadir nueva tarea.");
			System.out.println("2. Ver todas las tareas.");
			System.out.println("3. Eliminar Tarea.");
			System.out.println("4 Salir.");
			System.out.println("Elige una opción:");
			int opcion = scanner.nextInt();
			scanner.nextLine();
			
			if (opcion == 1) {
				System.out.println("Qué tarea quieres añadir?");
				String addTarea = scanner.nextLine();
				tareas.add(addTarea);
				System.out.println("Tarea añadida!");
			} else if (opcion == 2) {
//				LLAMAMOS AL ESPECIALISTA
//				for (int i = 0; i < tareas.size(); i++) {
//					String verTareas = tareas.get(i);
//					System.out.println(i + 1 + ". " + verTareas);
//				}
				System.out.println("--- Mis Tareas ---");
				mostrarTareas(tareas);
			} else if (opcion == 3) {
				System.out.println("--- Qué número quieres borrar? ---");
//				LLAMAMOS AL ESPECIALISTA
//				for (int i = 0; i < tareas.size(); i++) {
//					String verTareas = tareas.get(i);
//					System.out.println(i + 1 + ". " + verTareas);
//				}
				mostrarTareas(tareas);
				int tareaABorrar = scanner.nextInt();
				tareaABorrar -= 1;
				tareas.remove(tareaABorrar);
				scanner.nextLine();
				System.out.println("Tarea eliminada!");
			} else if (opcion == 4) {
				System.out.println("Hasta luego!");
				break;
			} else {
				System.out.println("Elige una de las opciones");
			}
		}
		scanner.close();
	}
	
	public static void mostrarTareas(ArrayList<String> lista) {
		
		for (int i = 0; i < lista.size(); i++) {
			String verTarea = lista.get(i);
			System.out.println(i + 1 + ". " + verTarea);
		}
//		CUANDO ES VOID NO SE USA RETURN!!!!
//		EL METODO RETORNARÁ AUTOMÁTICAMENTE EL VALOR AL LLEGAR AL CIERRE }
	}

}
