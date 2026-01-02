package arrayElAtaqueCircular;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ElAtaqueCircular {
	public static void main(String[] args) {
		ArrayList<Damageable> enemigos= new ArrayList<Damageable>();
		
		enemigos.add(new Goblin("Borkle", 40));
		enemigos.add(new Orco("Gorrum", 120));
		enemigos.add(new Dragon("Smaug",500));
		
		enemigos.add(new Muro(1000));
		
		int fuerzaAtaque= 50;
		
		try {
			fuerzaAtaque= Integer.parseInt(JOptionPane.showInputDialog("Introduce el daño Infernal"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "No has introducido un daño infernal valido.\nPor Defecto se asignará 50 dmg");
		}
		for (Damageable d: enemigos) {
			if (d instanceof Enemigo) {
				Enemigo e= (Enemigo) d;
				System.out.println(e.toString());
				e.warCry();
				System.out.println();
			} else {				
				System.out.println("Soy un enemigo inerte un (Muro) con una vida de: " + d.getVida()+ "\n");
			}
		}
		
		for(Damageable d: enemigos) {
			d.recibirDamage(fuerzaAtaque);
		}
		System.out.println("Ataques Realizados!!");
		
		for (Damageable d: enemigos) {
			if (d.getVida()<=0) {
				if (d instanceof Enemigo) {					
					System.out.println("El enemigo " + ((Enemigo)d).getNombre() + " ha muerto.");
				} else {
					System.out.println("Un muro ha sido destruido.");
				}
			}
		}
		
		enemigos.removeIf(borrarMuertos -> borrarMuertos.getVida()<=0);
		
		System.out.println("\nSobrevivientes!!");
		for (Damageable d: enemigos) { 
			if (d instanceof Enemigo) {
				System.out.println("Quedan vivos: " + ((Enemigo)d).getNombre() + " con un total de vida: " + d.getVida());
			} else {
				System.out.println("El muro sigue en pie con un total de vida: " + d.getVida());
			}
		}
		
	}
}

abstract class Enemigo implements Damageable {
	private String nombre;
	private int vida;
	
	public Enemigo (String nombre, int vida) {
		this.nombre= nombre;
		this.vida= vida;
	}
	
	/* --------------------- SETTERS --------------------- */
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public void setVida(int vida) {
		this.vida= vida;
	}
	
	/* --------------------- GETTERS --------------------- */
	public String getNombre() {
		return nombre;
	}
	public int getVida() {
		return vida;
	}
	
	/* --------------------- OVERRIDE TOSTRING --------------------- */
	@Override
	public String toString() {
		return "Nombre: " + nombre + " vida: " + vida + "pts";
	}
	
	/* --------------------- MÉTODOS --------------------- */
	public void recibirDamage(int damage) {
		if (vida >= damage) this.vida-= damage;
		else this.vida= 0;
	}
	
	public abstract void warCry();
}

class Dragon extends Enemigo {

	public Dragon(String nombre, int vida) {
		super(nombre, vida);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void recibirDamage(int damage) {
		int reducedDmg= damage/2;
		super.recibirDamage(reducedDmg);
	}

	@Override
	public void warCry() {
		// TODO Auto-generated method stub
		System.out.println("El Dragón escupe fuego mientras ruge");
	}
}

class Goblin extends Enemigo {

	public Goblin(String nombre, int vida) {
		super(nombre, vida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void warCry() {
		// TODO Auto-generated method stub
		System.out.println("El Goblin chilla histéricamente");
	}
	
}

class Orco extends Enemigo {

	public Orco(String nombre, int vida) {
		super(nombre, vida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void warCry() {
		// TODO Auto-generated method stub
		System.out.println("El Orco gruñe con fuerza");
	}
	
}

class Muro implements Damageable {
	private int vida;
	
	public Muro (int vida) {
		this.vida= vida;
	}
	
	@Override
	public void recibirDamage(int damage) {
		// TODO Auto-generated method stub
		if (vida>= damage) this.vida-= damage;
		else this.vida=0;
	}

	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return vida;
	}
	
}