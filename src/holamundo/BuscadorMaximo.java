package holamundo;

public class BuscadorMaximo {

	public static void main(String[] args) {
		int[] misNumeros = {5, -10, 150, 25, 3};
		
		int numeroMasAlto = encontrarMaximo(misNumeros);
		
		System.out.println("El número más alto es: " + numeroMasAlto);

	}
	
	
	public static int encontrarMaximo(int[] arrayNumeros) {
		
		int maximoTemporal = arrayNumeros[0];
		
		for (int i = 1; i < arrayNumeros.length; i++) {
			if (arrayNumeros[i] > maximoTemporal ) {
				maximoTemporal = arrayNumeros[i];
			}
		}
		return maximoTemporal;
	}
}
