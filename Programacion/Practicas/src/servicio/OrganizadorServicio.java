package servicio;

import java.util.Scanner;

import dominio.Organizador;
import dominio.Usuario;
import persistencia.OrganizadorDao;

public class OrganizadorServicio implements IOrganizadorServicio{
	private final Scanner sc;
	private OrganizadorDao organizadorDao;
	
	public OrganizadorServicio(Scanner sc) {
		this.sc = sc;
		this.organizadorDao = new OrganizadorDao();
	}

	@Override
	public Organizador hacerLogin() {
		//Pedimos el nombre y la contrasenia
		System.out.println("Dame el nombre del organizador");
		String nombreOrganizador = sc.nextLine();
		System.out.println("Dame el contraseña del organizador");
		String contraseniaOrganizador = sc.nextLine();
		//Creamos al organizador
		Organizador organizador = organizadorDao.login(nombreOrganizador, contraseniaOrganizador);
		//Devolvemos el organizador
		return organizador;
	}

	@Override
	public void registrarOrganizador() {
		//Pedimos el nombre, el email, la contrasenia y telefono
		System.out.println("Dame el nombre del organizador");
		String nombreOrganizador = sc.nextLine();
		System.out.println("Dame el correo del organizador");
		String emailOrganizador = sc.nextLine();
		System.out.println("Dame el contraseña del organizador");
		String contraseniaOrganizador = sc.nextLine();
		System.out.println("Dame el telefono del organizador");
		String telefonoOrganizador = sc.nextLine();
		
		//Creamos el organizador
		Organizador organizador = new Organizador(nombreOrganizador,emailOrganizador,contraseniaOrganizador,telefonoOrganizador);
		
		//Guardaos la respuesta en un booleano
		organizadorDao.registrar(organizador);
		
		
		
	}
	
}
