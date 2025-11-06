package EjerciciosRapidos;

public class SumaArray {
	public static void main(String[] args) {
		int[] numerosEnteros = {5,10,15,20,25};
		int suma = 0;
		
		for (int i=0; i<numerosEnteros.length; i++) {
			suma += numerosEnteros[i];  				// EQUIVALE A suma = suma + numerosEnteros[i];
		}
		System.out.println(suma);
	}
}
