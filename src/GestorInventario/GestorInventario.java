package GestorInventario;
import java.util.*;
import java.io.*;

public class GestorInventario {

	public static void main(String[] args) {
		ArrayList<Producto> inventario = new ArrayList<>();
		
		cargarInventario(inventario);
		
		try (Scanner scanner = new Scanner(System.in)) {
			menu(scanner, inventario);
		}

	}
	
	public static void menu(Scanner scanner, ArrayList<Producto> inventario) {
		int option = 0;
		do {
			System.out.println("-- Gestor de Inventario --");
			System.out.println("1. Añadir producto nuevo.");
			System.out.println("2. Listar productos.");
			System.out.println("3. Buscar producto por nombre.");
			System.out.println("4. Guardar Inventario.");
			System.out.println("5. Salir.");

			option = optionMenu(scanner);
			
			switch (option) {
			case 1:
				addProducto(inventario, scanner);
				break;
			case 2:
				listarProductos(inventario);
				break;
			case 3:
				buscarProducto(inventario, scanner);
				break;
			case 4:
				guardarInventario(inventario);
				break;
			case 5:
				System.out.println("Hasta luego!");
				break;
			default:
				System.out.println("Error: Elige una opción valida.");
				break;
			}
		} while (option != 5);
		
	}
	
	public static void cargarInventario(ArrayList<Producto> inventario) {
		String nombreArchivo = "src/GestorInventario/inventario.txt";
		
		try (FileReader fr = new FileReader(nombreArchivo);
				BufferedReader br = new BufferedReader(fr)) {
					String linea;
					
					while ((linea = br.readLine()) != null) {
						String[] partes = linea.split(",");
						String parte1 = partes[0];
						int parte2 = Integer.parseInt(partes[1]) ;
						double parte3 = Double.parseDouble(partes[2]);
						Producto newProducto = new Producto(parte1, parte2, parte3);
						inventario.add(newProducto);
					}
					
					System.out.println("Inventario cargado con éxito desde: " + nombreArchivo);
					
				} catch (FileNotFoundException e) {
					System.out.println("No se encontró: " + nombreArchivo + "Empezando con un inventario vacio.");
				} catch (IOException e){
					System.out.println("Error al leer el inventario: " + e.getMessage());
				} catch (NumberFormatException e) {
					System.out.println("Error: Formato de número incorrecto en el fichero. Inventario no cargado");
				}
	}
	
	
	public static void guardarInventario(ArrayList<Producto> inventario) {
		String nombreArchivo = "src/GestorInventario/inventario.txt";
		
		try (FileWriter fw = new FileWriter(nombreArchivo);
				BufferedWriter bw = new BufferedWriter(fw)) {
			for (Producto p : inventario) {
				String lineaDeTexto = (p.getNombre() + "," + p.getCantidad() + "," + p.getPrecio());
				bw.write(lineaDeTexto);
				bw.newLine();
			}
			System.out.println("Inventario guardaro con éxito: " + nombreArchivo + "!");
			
			
		} catch (IOException e) {
			System.out.println("ERROR: No se pudo guardar el inventario.");
			e.printStackTrace();
		}
	}
	
	public static void addProducto(ArrayList<Producto> inventario, Scanner scanner) {
		int newCantidad = 0;
		double newPrecio = 0.0;
		boolean cantidadValida = false;
		boolean precioValido = false;
		
		System.out.println("Introduce el Nombre del Producto: ");
		String newProducto = scanner.nextLine();
		
		do {
			try {
				System.out.println("Introduce la cantidad:");
				newCantidad = Integer.parseInt(scanner.nextLine());
				cantidadValida = true;
			} catch (NumberFormatException e) {
				System.out.println("Error: Cantidad Invalida.");
			}
		} while (cantidadValida == false);
	
		do {
			try {
				System.out.println("Introduce el precio:");
				newPrecio = Double.parseDouble(scanner.nextLine());
				precioValido = true;
			} catch (NumberFormatException e) {
				System.out.println("Error: Introduce un precio valido.");
			}
		} while (precioValido == false);
			
		if (newCantidad >= 0 && newPrecio > 0) {
			Producto newP = new Producto(newProducto, newCantidad, newPrecio);
			inventario.add(newP);
			System.out.println("Producto añadido correctamente.");
		} else {
			System.out.println("Error: La cantidad o el precio no son válidos.");
		}
	}
	
	public static void buscarProducto(ArrayList<Producto> inventario, Scanner scanner) {
		int resultadosEncontrados = 0;
		
		System.out.println("Qué quieres buscar?");
		String busqueda = scanner.nextLine();

		for (Producto p : inventario) {
			if (p.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
				p.mostrarInfo();
				resultadosEncontrados++;
			}
		}
		if (resultadosEncontrados == 0) {
			System.out.println("No se encontraron productos con ese nombre");
		}
	}
	
//	public static void listarProductos(ArrayList<Producto> inventario) {
//		for (int i = 0; i < inventario.size(); i++) {
//			Producto productoActual = inventario.get(i);
//			productoActual.mostrarInfo();
//		}
//	} MEJOR MANERA PARA RECORRER UNA LISTA, VER MÉTODO INFERIOR.
//	
	public static void listarProductos(ArrayList<Producto> inventario) {
		for (Producto p : inventario) {
			p.mostrarInfo();
		}
	}
	
	public static int optionMenu(Scanner scanner) {
		int option = 0;
		boolean esValido = false;
		
		do {
			try {
				System.out.println("Elige una opción:");
				String optionMenu = scanner.nextLine();
				option = Integer.parseInt(optionMenu);
				esValido = true;
			} catch (NumberFormatException e) {
				System.out.println("Error: Elige una opcón válida.");
			}
		} while (esValido == false);
		return option;
	}

}
