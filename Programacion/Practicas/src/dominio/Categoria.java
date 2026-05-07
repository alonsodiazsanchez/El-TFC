package dominio;

public class Categoria{
	//Definimos los atributos
	
	private String nombre;
	private String descripcion;
	
	//Creamos el Contructor
	public Categoria(String nombre, String descripcion) {
		this.nombre= nombre;
		this.descripcion = descripcion;
	}

	//Creamos los setters y los gettres
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//Creamos el toString
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
