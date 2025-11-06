package holamundo;
import java.util.*;

public class MiniCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		menu(scanner);
		scanner.close();

	}
	
	public static void menu(Scanner scanner) {
		int option = 0;
		do {
			System.out.println("--- Menú Calculadora ---");
			System.out.println("1. Sumar A + B");
			System.out.println("2. Restar A - B");
			System.out.println("3. Multiplicar A * B");
			System.out.println("4. Dividir A / B");
			System.out.println("5. Salir");
			
			option = pedirOpcionMenu(scanner);
			switch (option) {
			case 1:
				sumar(scanner);
				break;
			case 2:
				restar(scanner);
				break;
			case 3:
				multiplicar(scanner);
				break;
			case 4:
				dividir(scanner);
				break;
			case 5:
				System.out.println("Hasta otra!");
				break;
			default:
				System.out.println("Error: Opción no válida. Elige del 1 al 5.");
				break;
			}	
					
		} while (option != 5);
	}
	
	public static int pedirOpcionMenu (Scanner scanner) {
		int opcion = 0;
		boolean esValido = false;
		
		do {
			try {
				System.out.println("Selecciona una opción:");
				String opcionUsuario = scanner.nextLine();
				opcion = Integer.parseInt(opcionUsuario);
				esValido = true;
			} catch (NumberFormatException e) {
				System.out.println("Introduce una opción valida.");
			}
			
		} while (esValido == false);
		return opcion;
	}
	
	public static double pedirNumero(Scanner scanner, String mensaje) {
		double numero = 0;
		boolean esValido = false;
		
		do {
			try {
				System.out.println(mensaje);
				String entradaDelUsuario = scanner.nextLine();
				
				numero = Double.parseDouble(entradaDelUsuario);
				
				esValido = true;
			
			} catch (NumberFormatException e) {
				System.out.println("Error: Eso no es un número. Intentalo de nuevo.");
			}
		} while (esValido == false);
		return numero;
	}
	
	public static void sumar(Scanner scanner) {
		// llama al especialista para A
		double a = pedirNumero(scanner, "Introducir valor de A:");
		
		// llama al especialista para B
		double b = pedirNumero(scanner, "Introducir valor de B:");
		
		// calcula y muestra:
		double resultado = a + b;
		System.out.println("El resultado de la suma es: " + resultado);
	}
	public static void restar(Scanner scanner) {
		double a = pedirNumero(scanner, "Introduce el valor de A:");
		double b = pedirNumero(scanner, "Intruduce el valor de B:");
		double resultado = a - b;
		System.out.println("El resultado de la resta es: " + resultado);
	}
	public static void multiplicar(Scanner scanner) {
		double a = pedirNumero(scanner, "Introducir el valor de A: ");
		double b = pedirNumero(scanner, "Introducir el valor de B: ");
		double resultado = a * b;
		System.out.println("El resultado de la multiplicación es: " + resultado);
	}
	public static void dividir(Scanner scanner) { 
		double a = pedirNumero(scanner, "Introduce el valor de A: ");
		double b = pedirNumero(scanner, "Introduce el valor de B: ");
		if (b == 0) {
			System.out.println("No se puede dividir entre 0. Introduce un número valido.");
		} else {
			double resultado = a / b;
			System.out.println("El resultado de la división es: " + resultado);
		}
	}
}
