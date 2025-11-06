package holamundo;

public class control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int edad = 18;
		
		if (edad >= 18) {
			System.out.println("Eres mayor de edad.");
		} else {
			System.out.println("Eres menor de edad.");
		}

		
		int nota = 9;
		
		if (nota < 5) {
			System.out.println("Suspenso!");
		} else if (nota < 9) {
			System.out.println("Aprobado!");
		} else {
			System.out.println("Sobresaliente!!");
		}
	}

}
