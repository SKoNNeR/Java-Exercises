package EjerciciosRapidos;

public class SumaMatriz {
	public static void main(String[] args) {
		
		int[][] matriz = {								/// CREAMOS UN ARRAY BIDIMESIONAL CON DATOS
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		int sumaTotal = 0;								/// INICIALIZAMOS A 0 LA VARIABLE (LA ACTIVAMOS)
		
		for (int i=0; i < matriz.length; i++) {			/// CALCULARÁ LAS FILAS
			for (int j=0; j<matriz[i].length; j++) {	/// CALCULARÁ LAS COLUMNAS PERO ASIGNANDO LAS FILAS
				sumaTotal += matriz[i][j];				/// SUMARÁ CADA VALOR DEL ARRAY A sumaTotal
			}
		}
		System.out.println(sumaTotal);					/// IMPRIME RESULTADO DE sumaTotal
	}
}
