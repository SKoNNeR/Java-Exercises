package pooExercises.poo6;

import javax.swing.JOptionPane;

public class UsoContraseña {
	public static void main(String[] args) {
		
		int numPass= Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas contraseñas quieres?"));
		int sizePass= Integer.parseInt(JOptionPane.showInputDialog("¿De qué tamaño quieres las contraseñas?"));
		
		PassGen[] passwords= new PassGen[numPass];
		
		for (int i=0; i< passwords.length; i++) {
			passwords[i]= new PassGen(sizePass);
		}
		
		for (PassGen p: passwords) {
			System.out.println(p.getPassLength());
			System.out.println(p.passSecurityCheck());
			System.out.println(p.getPass());
			System.out.println();
		}
		
	}
}

class PassGen {
	private int longitud;
	private String contraseñaGenerada;
	
	public PassGen(int longitud) {
		this.longitud= longitud;
		this.contraseñaGenerada= passMaker();
	}
	
	public String passMaker() {
		String newPass= "";
		int tipe;
		int numASCII=0;
				
		for (int i=0; i<this.longitud; i++) {
			tipe= (int)(Math.random() * (3 - 1 + 1) + 1);
			switch (tipe) {
			case 1 -> numASCII= (int)(Math.random() * (57 - 48 + 1) + 48);  	// números
			case 2 -> numASCII= (int)(Math.random() * (90 - 65 + 1) + 65);  	// mayusculas
			case 3 -> numASCII= (int)(Math.random() * (122 - 97 + 1) + 97); 	// minúsculas
			}
			newPass+= (char)numASCII;
		}	
		return newPass;
	}
	public String passSecurityCheck() {
		boolean security= false;
		int numCount=0 ,capCount=0 , lowCount= 0;
		for (int i=0; i<contraseñaGenerada.length(); i++) {
			int charToASCII = (int)contraseñaGenerada.charAt(i);
			if (charToASCII<=57 && charToASCII>=48) {
				numCount++;
			} else if (charToASCII<=90 && charToASCII>=65) {
				capCount++;
			} else if (charToASCII<=122 && charToASCII>=97) {
				lowCount++;
			}
		}
		if (numCount>=5 && capCount>=2 && lowCount>=1) security= true;
		if (security) return "La contraseña es segura.";
		else return "La contraseña NO es segura.";
	}
	
	public String getPass() {
		return this.contraseñaGenerada;
	}
	public int getPassLength() {
		return contraseñaGenerada.length();
	}
}
