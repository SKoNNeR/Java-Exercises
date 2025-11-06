package holamundo.instrumento;

public class Trompeta extends Instrumento {
	private int numeroPistones;
	
	public Trompeta(String marca, int numeroPistones) {
		super(marca);
		
		this.numeroPistones = numeroPistones;	
	}
	
	@Override
	public void tocar() {
		System.out.println("Suena un solo de trompeta! (de la marca: " + getMarca() + ")");
	}
		
}
