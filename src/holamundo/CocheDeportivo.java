package holamundo;

public class CocheDeportivo extends Coche {
	private int caballosDeFuerza;
	
	public CocheDeportivo(String marca, String modelo, int year, int caballos) {
		
		// llamamos al constroctor de COCHE, valores a heredar
		super(marca,modelo,year);
		
		// llamamos a los campos de cochedeportivo, campos nuevos
//		this.caballosDeFuerza = caballos;
		
		
//		llamamos al setter
		setCaballos(caballos);
	}
	
	@Override
	public void mostrarInfo() {
		// podemos incluso llamar a la versión del padre primero si queremos:
		// super.mostrarInfo();
		
		// O reescribirlo por completo:
		System.out.println("Deportivo: " + getMarca() + " " + getModelo() + ", CV: " + this.caballosDeFuerza);
		
	}
	
	public int getCaballos() {
		return this.caballosDeFuerza;
	}
	
	public void setCaballos(int nuevosCaballos) {
		int minCV = 400;
		if (nuevosCaballos > minCV) {
			this.caballosDeFuerza = nuevosCaballos;
		} else {
			System.out.println("Error: " + nuevosCaballos + " CV no es un valor válido.");
			System.out.println("Estableciendo un valor mínimo de " + minCV + " CV.");
			this.caballosDeFuerza = minCV;
		}
		
	}

}
