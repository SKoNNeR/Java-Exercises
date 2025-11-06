package laminibiblioteca;
import java.util.*;

public class BibliotecaApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Libro> estanteria = new ArrayList<>();
		
		menu(scanner, estanteria);
		scanner.close();
	}
	
	public static void mostrarLibro(ArrayList<Libro> estanteria) {
		for (int i = 0; i < estanteria.size(); i++) {
			Libro libroActual = estanteria.get(i);
			libroActual.mostrarLibro();	
		}
	}
	
	public static void addLibro(ArrayList<Libro> estanteria, Scanner scanner) {
		System.out.println("Cual es el nombre del libro?");
		String nameLibro = scanner.nextLine();
		
		System.out.println("Cual es el nombre del autor?");
		String nameAutor = scanner.nextLine();
		
		int newYear = 0;
		boolean esValido = false;
		
		do {
			try {
				System.out.println("Introduce el año de publicación:");
				String newOption = scanner.nextLine();
				newYear = Integer.parseInt(newOption);
				esValido = true;
			} catch (NumberFormatException e) {
				System.out.print("Error: Año no válido.");
			}
			
		} while (esValido == false);
		Libro newLibro = new Libro(nameLibro, nameAutor, newYear);
		estanteria.add(newLibro);
		System.out.println("Libro añadido!");
		
	}
	
	public static void menu(Scanner scanner, ArrayList<Libro> estanteria) {
		int option = 0;
		do {
			System.out.println("--- BibliotecaApp ---");
			System.out.println("1. Añadir Libro.");
			System.out.println("2. Listar Libros.");
			System.out.println("3. Salir");
			option = opcionMenu(scanner);
			switch (option) {
			case 1:
				addLibro(estanteria, scanner);
				break;
			case 2:
				mostrarLibro(estanteria);
				break;
			case 3:
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Introduce una opción valida.");
			}
		} while (option != 3);
	}
	
	public static int opcionMenu(Scanner scanner) {
		int option = 0;
		boolean esVerdad = false;
		
		do {
			try {
				System.out.println("Intruduce una opción:");
				String newOption = scanner.nextLine();
				option = Integer.parseInt(newOption);
				esVerdad = true;
			} catch (NumberFormatException e) {
				System.out.println("Error: No has seleccionado una opción correcta.");
			}
			
		} while (esVerdad == false);
		return option;
	}
}
