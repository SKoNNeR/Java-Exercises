package holamundo;

public class HolaMundo {

	public static void main(String[] args) {
		
		double cuentaTotal = 85.50;
		double porcentajePropina = 0.15;
		double cantidadPropina = cuentaTotal * porcentajePropina;
		double totalAPagar = cuentaTotal + cantidadPropina;
		boolean pagarConTarjeta = true;
		
		int a = 5;
		int b = 2;
		
		System.out.println(a / b);
		System.out.println(a % b);
		
		
		System.out.println("La cuenta original es " + cuentaTotal);
		System.out.println("La propina sería de: " + cantidadPropina);
		System.out.println("El total a pagar sería: " + totalAPagar);
		System.out.println("Has pagado con tarjeta." + pagarConTarjeta);
	}

}
