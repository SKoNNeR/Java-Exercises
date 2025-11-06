package holamundo.instrumento;

public class Instrumento {
	private String marca;
	
	public Instrumento(String marca) {
		this.marca = marca;
	}
		
	public String getMarca() {
		return this.marca;
	}
		
	public void afinar() {
		System.out.println("Afinando el instrumento...");
	}
	
	public void tocar() {
		System.out.println("El instrumento produce un sonido.");
	}

}
