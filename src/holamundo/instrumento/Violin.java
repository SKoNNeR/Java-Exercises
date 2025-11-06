package holamundo.instrumento;

public class Violin extends Instrumento {
	private int numeroDeCuerdas;
	
	public Violin(String marca, int numeroDeCuerdas) {
		super(marca);
		
		this.numeroDeCuerdas = numeroDeCuerdas;
	}
	
	@Override
	public void tocar() {
		System.out.println("Suena una melodia de violín! (de la marca " + getMarca() + ")");
	}

}
