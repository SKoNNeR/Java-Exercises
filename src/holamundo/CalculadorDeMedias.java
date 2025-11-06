package holamundo;

public class CalculadorDeMedias {
	
	// MÉTODO MAIN (El Jefe de Obra)
	public static void main(String[] args) {
		
		// 1. El Jefe prepara los datos.
		double[] notas = {7.5, 8.0, 4.5, 9.5, 6.0};
		
		// 2. El Jefe llama al especialista, le entrega los datos (notas)
        //    y espera a que le devuelva el resultado para guardarlo.
		double mediaFinal = calcularMedia(notas);
		
		// 3. El Jefe muestra el resultado final al usuario.
		System.out.println("La nota media es: " + mediaFinal);
		
	}
	
	// MÉTODO CALCULADOR (El Especialista)
    //                                  vvvvvvvvvvvvvvvvvvvvvvvvvvv
    // Declara que necesita un array de double para trabajar.
	public static double calcularMedia(double[] arrayDeNotas) {
		double suma = 0.0;
		
		// Trabaja SOLAMENTE con los datos que le han entregado (arrayDeNotas).
		for (int i = 0; i < arrayDeNotas.length; i++) {
			suma += arrayDeNotas[i];
		}
		
		// Calcula el resultado.
		double mediaCalculada = suma / arrayDeNotas.length;
		
		// Entrega (devuelve) el resultado final. NO lo imprime.
		return mediaCalculada;
	}

}
