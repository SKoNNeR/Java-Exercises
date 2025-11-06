package holamundo;
import java.util.*;


public class BibliotecaApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Libro> estanteria = new ArrayList<>();
		int opcion = 0;
		
		// MENU
		while (true) {
			System.out.println("--- Biblioteca ---");
			System.out.println("1. Añadir libro.");
			System.out.println("2. Mostrar todos los libros.");
			System.out.println("3. Salir.");
			
			// SOLICITAMOS UNA OPCIÓN
			try {
				System.out.println("Introduce una de las opciones: ");
				opcion = scanner.nextInt();
				scanner.nextLine();
							
				// COMPROBAMOS OPCION SELECCIONADA Y EJECUTAMOS OPCIÓN
				if (opcion == 1) {
					addNewLibro(scanner, estanteria);	
				} else if (opcion == 2) {
					mostrarLibros(estanteria);
				} else if (opcion == 3) {
					System.out.println("Hasta luego!");
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Eso no es un número.");
				scanner.nextLine();
			} finally {

			}
		}
		scanner.close();
	}
	
	public static void mostrarLibros(ArrayList<Libro> libros) {
		for (int i = 0; i < libros.size(); i++) {
			Libro libroActual = libros.get(i);
			libroActual.mostrarLibro();
		}
	}
	
	public static void addNewLibro(Scanner scanner, ArrayList<Libro> estanteria) {

		System.out.println("Nombre del Libro:");
		String nuevoTitulo = scanner.nextLine();

		
		System.out.println("Introduce el autor:");
		String nuevoAutor = scanner.nextLine();

		
		int nuevoYear = 0;
		boolean yearValidation = false;
		do {
			try {
				System.out.println("Introduce el Año de publicación:");
				nuevoYear = scanner.nextInt();
				scanner.nextLine();
				yearValidation = true;
			} catch (InputMismatchException e) {
				System.out.println("Error: Eso no es un número. Intentalo de nuevo");
				scanner.nextLine(); // limpiamos scanner
			}
			
		} while (yearValidation == false);
		
		Libro nuevoLibro = new Libro (nuevoTitulo, nuevoAutor, nuevoYear);
		estanteria.add(nuevoLibro);
		System.out.println("Libro añadido correctamente.");
	}
}
