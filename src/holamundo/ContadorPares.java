package holamundo;

public class ContadorPares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contadorPares = 0;
		
		for (int i = 1; i <= 50; i++) {
			if ( i % 2 == 0) {
				contadorPares++;
			}		
		}
		System.out.println(contadorPares);
	}
}
