package interfacesGraficas.interfaces8;

import java.awt.GraphicsEnvironment;

public class LetrasEnLocal {
	public static void main(String[] args) {
		GraphicsEnvironment g= GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fonts[]= g.getAvailableFontFamilyNames();
		
		for (int i=0; i<fonts.length; i++) {
			System.out.println(fonts[i]);
		}
		
	}
}

