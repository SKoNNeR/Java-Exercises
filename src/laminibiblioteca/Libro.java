package laminibiblioteca;

public class Libro {
	private String titulo;
	private String autor;
	private int yearPublicacion;
	
	
	public Libro(String titulo, String autor, int yearPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.yearPublicacion = yearPublicacion;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getYearPublicacion() {
		return this.yearPublicacion;
	}
	
	public void mostrarLibro() {
		System.out.println(getTitulo() + "(" + getAutor() + ", " + getYearPublicacion() + ")"  );	
	}
	
}
