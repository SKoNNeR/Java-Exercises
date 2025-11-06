package holamundo;
import java.util.Scanner;

public class GestorDeNotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Cuantas notas vas a introducir?");
		int numeroDeNotas = scanner.nextInt();
		
		double[] notas = new double[numeroDeNotas];
		
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Introduce la nota del alumno " + (i + 1) + ":");
			notas[i] = scanner.nextDouble();
		}
		
		System.out.println("Todas las notas han sido entregadas.");
		
		while (true) {
			System.out.println("--- MENÚ ---");
			System.out.println("1. Calcular la nota media.");
			System.out.println("2. Calcular la nota más alta.");
			System.out.println("3. Mostrar la nota más baja.");
			System.out.println("4. Salir del programa.");
			System.out.println("Elige una opción:");
			int opcion = scanner.nextInt();
			if (opcion == 1 ) {
				double mediaFinal = calcularMedia(notas);
				System.out.println("La media es: " + mediaFinal);
			} else if (opcion == 2) {
				double notaMasAlta = encontrarNotaMasAlta(notas);
				System.out.println("La nota más alta es: " + notaMasAlta);
			} else if (opcion == 3) {
				double notaMasBaja = encontrarNotaMasBaja(notas);
				System.out.println("La nota más baja es: " + notaMasBaja);
			} else if (opcion == 4) {
				System.out.println("Hasta luego!");
				break;
			} else {
				System.out.println("Opción no valida, selecciona del 1 al 4");
			}
		}
		scanner.close();
	}
	
	public static double calcularMedia(double[] arrayDeNotas) {
		double suma = 0.0;
		
		for (int i = 0; i < arrayDeNotas.length; i++) {
			suma += arrayDeNotas[i];
		}
		
		double calcularMedia = suma / arrayDeNotas.length;
		return calcularMedia;
	}

	public static double encontrarNotaMasAlta(double[] arrayDeNotas) {
		double maximoTemporal = arrayDeNotas[0];
		
		for (int i = 0; i < arrayDeNotas.length; i++) {
			if (arrayDeNotas[i] > maximoTemporal) {
				maximoTemporal = arrayDeNotas[i];
			}
		}
		return maximoTemporal;
	}
	
	public static double encontrarNotaMasBaja(double[] arrayDeNotas) {
		double minimoTemporal = arrayDeNotas[0];
		
		for (int i = 0; i < arrayDeNotas.length; i++) {
			if (arrayDeNotas[i] < minimoTemporal) {
				minimoTemporal = arrayDeNotas[i];
			}
		}
		return minimoTemporal;
	}
}
