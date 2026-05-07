package dominio;

import java.time.LocalDate;
import java.time.LocalTime;

import persistencia.EventoDao;

public class Organizador extends Usuario {
	//Declaramos los atributos
	private String telefono;
	
	//Creamos el contructor
	public Organizador(String nombre, String email, String contrasenia,String telefono) {
		super(nombre, email, contrasenia);
		this.telefono = telefono;
		
		
	}

	//Creamos los setters y los gettres
	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	//Creamos el metodo organizarEvento
	public Evento organizarEvento(String nombre, String descripcion, LocalDate fecha, LocalTime hora, int duracion, String ubicacion,Categoria categoria) {
	    //Creamos un evento
		Evento evento = new Evento(nombre, descripcion, fecha, hora, duracion, ubicacion, categoria, this);
		//Retornamos el evento
		return evento;


	}


	//Creamos el toString
	@Override
	public String toString() {
		return "Organizador [telefono=" + telefono + "]";
	}

	
}
