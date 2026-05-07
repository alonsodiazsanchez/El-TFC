package dominio;

public class Usuario {
	
	//Creamos los atributos
	private String nombre;
	private String email;
	private String contrasenia;
	
	//Creamos el contructor
	public Usuario(String nombre ,String email, String contrasenia) {
		this.nombre= nombre;
		this.email=email;
		this.contrasenia= contrasenia;
	}

	//Creamos los settres y gettres
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	//Metodo inscribir
	public void inscribirEvento(Evento evento) {
		evento.getAsistentes().add(this);
		System.out.println("Usuario inscrito al evento: " + evento);
	}
	
	//Metodo de cancelar la Inscripcion
	public void cancelarInscripcion(Evento evento) {
		evento.getAsistentes().remove(this);
		System.out.println("Usuario desinscripto al evento: " + evento);
	}

	//Creamos el metodo toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", contrasenia=" + contrasenia + "]";
	}
	
	
}
