package holamundo;

public class Libro {
	private String titulo;
	private String autor;
	private int yearPublicacion;

	public Libro(String titulo, String autor, int yearPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.yearPublicacion = yearPublicacion;
	}
	
	public void mostrarLibro() {
		System.out.println("Nombre del libro: " + this.titulo + " Autor: (" + this.autor + ") Fecha publicacion: " + this.yearPublicacion);
	}
	
	
	// GETTERS
	public String getTitulo() {
		return this.titulo;
	}
	public String getAutor() {
		return this.autor;
	}
	public int getYearPublicacion() {
		return this.yearPublicacion;
	}
	
//	// SETTERS, pero no se usan ya que por diseño se ha confirmado que
	// por diseño una vez introducidos no se modifican.
//	public void setTitulo(String newTitulo) {
//		this.titulo = newTitulo;
//	}
//	public void setAutor(String newAutor) {
//		this.autor = newAutor;
//	}
//	public void setYearPublicacion(int newYearPublicacion) {
//		this.yearPublicacion = newYearPublicacion;
//	}
	
}
