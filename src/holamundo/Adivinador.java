package holamundo;
//import java.util.Scanner;
//import java.util.InputMismatchException;
import java.util.*; // carga toda la librería de java.util


public class Adivinador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int numeroSecreto = (int)(Math.random() * 100) + 1;
		int numeroDelUsuario = 0;
		
		System.out.println("He pensado un número del 1 al 100, intenta adivinarlo");
		
		while (numeroDelUsuario != numeroSecreto) {
			try {
				// Código peligroso que podría lanzar una Excepción
				System.out.println("Introduce un número:");
				numeroDelUsuario = scanner.nextInt();
				System.out.println("Has dicho: " + numeroDelUsuario);
				
				if (numeroDelUsuario < numeroSecreto) {
					System.out.println("Número demasiado bajo");
				} else if (numeroDelUsuario > numeroSecreto) {
					System.out.println("Número demasiado alto");
				}
				
			} catch (InputMismatchException e) {
				// Código que se ejecuta SOLO si se lanza esa Excepción
				System.out.println("Error: Eso no es un número!");
				scanner.nextLine();
				
			} finally {
				// Código que se ejecuta SIEMPRE
				System.out.println("El bloque try-catch ha terminado.");
			}
			
			
			
		}
		System.out.println("Enhorabuena! Has acertado! El número es: " + numeroDelUsuario);
		scanner.close();
	}

}
