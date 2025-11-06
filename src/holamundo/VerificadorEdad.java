package holamundo;

public class VerificadorEdad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int edad = 70;
		
		if (edad >= 65) {
			System.out.println("Enhorabuena, te puedes jubilar!");
		} else if (edad >= 18 || edad < 65) {
			System.out.println("Tienes la edad para trabajar, te queda un largo camino..");
		} else {
			System.out.println("Eres menor de edad, disfruta de la vida mientras puedas.");
		}

	}

}
