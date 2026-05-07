package servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

import java.util.Scanner;

import dominio.Categoria;
import dominio.Evento;
import dominio.Organizador;
import dominio.Usuario;
import persistencia.CategoriaDao;
import persistencia.EventoDao;

//Implementamos la interfaz con todos los metodos
public class EventoServicio implements IEventoServicio{
	private final Scanner sc;
	private EventoDao eventoDao;
	private CategoriaDao categoriaDao;
	
	public EventoServicio(Scanner sc) {
		this.sc = sc;
		this.eventoDao = new EventoDao();
		this.categoriaDao = new CategoriaDao();
	}

	
	@Override
	public void mostrarEventos() {
		//Creamos un for ecah para recorer todos los metodos
		for(Evento e:eventoDao.obtenerEventos().values()) {
			//Y los mostramos por pantalla
			System.out.println(e);
		}
		
	}

	@Override //Comprobar
	public void mostrarEventosUsuario(Usuario usuario) {
		//Creamos una variable que es un booleano donde esta en false
		 boolean usuarioInscripto = false;
		//Hacemos un for each para recorer los eventos
		for(Evento u:eventoDao.obtenerEventos().values()) {
			//Creamos una lista para guardar todos los Usuario 
			HashSet<Usuario> usuarioEvento = u.getAsistentes();
			//Si la lista tiene al usuario
			if(usuarioEvento.contains(usuario)) {
				//Sale que esta inscripto y al evento que esta
				System.out.println("El usuario esta inscrito en el evento " + u.getNombre());
				//Y la variable de tipo booleano la ponemos como true
				usuarioInscripto = true;

			}
			
		}
		
		//Si la variable es false
		if (!usuarioInscripto) {
			//Mostramos el siguiente mensaje
	        System.out.println("El usuario no se ha inscrito en ningún evento");
	    }
		
	}

	
	@Override
	public void inscribirUsuario(Usuario usuario) {
		System.out.println("Dame el nonbre del evento");
		//Pedimos el nombre del evento
		String nombreEvento = sc.nextLine();
		//Creamos un vento donde queremos obtener el nombre de los eventos
		Evento evento = eventoDao.obtenerEventos().get(nombreEvento);
		
		//Si el evento es distinto a null
		if(evento != null) {
			//Se escribe al evento
			usuario.inscribirEvento(evento);
			
		}else {
			//Si no no esta inscripto
			System.out.println("No esta esta inscripto");
		}
	}

	
	@Override
	public void cancelarInscripcion(Usuario usuario) {
		System.out.println("Dame el nonbre del evento");
		//Pedimos el nombre del evento
		String nombreEvento = sc.nextLine();
		//Creamos un vento donde queremos obtener el nombre de los eventos
		Evento evento = eventoDao.obtenerEventos().get(nombreEvento);
		//Si el evento es distinto a null
		if(evento != null) {
			//Cancelamos la inscripcion
			usuario.cancelarInscripcion(evento);
			//Si no
		}else {
			//Muestra que no esta inscripto
			System.out.println("No esta esta inscripto");
		}
	}
		
	

	@Override
	public void mostrarEventosOrganizador(Organizador organizador) {
		//Creamos una variable que es un booleano donde esta en false
		 boolean encontrado = false;
		//Hacemos el forEach para recorer los eventos
		for(Evento o:eventoDao.obtenerEventos().values()) {
			//Si el organizar¡dor es igual
			if(o.getOrganizador().equals(organizador)) {
				//Mustra los eventos del organizador
				System.out.println(o);
				//Y la variable de tipo booleano la ponemos como true
				  encontrado = true;
			}
		}
		//Si la variable es false
		if (!encontrado) {
	        System.out.println("No hay ningún evento para este organizador");
	    }
		
	}

	@Override
	public void crearEvento(Organizador organizador) {
		//Pedimos todos los atributos para un evento
		System.out.println("Introduce el nombre:");
		String nombre = sc.nextLine();

		System.out.println("Introduce la descripción:");
		String descripcion = sc.nextLine();

		System.out.println("Introduce la fecha (formato YYYY-MM-DD):");
		LocalDate fecha = LocalDate.parse(sc.nextLine());

		System.out.println("Introduce la hora (formato HH:MM):");
		LocalTime hora = LocalTime.parse(sc.nextLine());

		System.out.println("Introduce la duración:");
		int duracion = Integer.parseInt(sc.nextLine());

		System.out.println("Introduce la ubicación:");
		String ubicacion = sc.nextLine();

		String nombreCategoria;
		Categoria categoria = null;
		do {
			System.out.println("Introduce el nombre de la categoría:");
			nombreCategoria = sc.nextLine();
			
			if(categoriaDao.obtenerCategoria(nombreCategoria) != null) {
				categoria = categoriaDao.obtenerCategoria(nombreCategoria);
			}else {
				System.out.println("La categoria que estas buscando no se encuentra disponible por favor vuelve a introducirla de nuevo gracias");
			}
			
		}while(nombreCategoria == null);
		
		//Y creamos el evento con el metodo dentro de organizador
		eventoDao.insertarEvento(organizador.organizarEvento(nombre, descripcion, fecha, hora, duracion, ubicacion, categoria));
		System.out.println("Evento creado");
		
		
	}

}
