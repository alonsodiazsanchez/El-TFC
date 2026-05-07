package servicio;

import java.util.Scanner;


import dominio.Usuario;
import persistencia.UsuarioDao;


public class UsuarioServicio implements IUsuarioServicio{
	private final Scanner sc;
	private UsuarioDao usuarioDao;
	
	public UsuarioServicio(Scanner sc) {
		this.sc = sc;
		this.usuarioDao = new UsuarioDao();
	}

	@Override
	public Usuario hacerLogin() {
		//Pedimos los datos del nombre y contrasenia
		System.out.println("Dame el nombre del usuario");
		String nombreUsuario = sc.nextLine();
		System.out.println("Dame el contraseña del usuario");
		String contraseniaUsuario = sc.nextLine();
		
		//Buscamos al Usuario dentro del login 
		Usuario usuario = usuarioDao.login(nombreUsuario, contraseniaUsuario);
		//Y devolvemos el usuario
		return usuario;
	}

	@Override
	public void registrarUsuario() {
		//Pedimos los datos del nombre,email y contrasenia
		System.out.println("Dame el nombre del usuario");
		String nombreUsuario = sc.nextLine();
		System.out.println("Dame el correo del usuario");
		String emailUsuario = sc.nextLine();
		System.out.println("Dame el contraseña del usuario");
		String contraseniaUsuario = sc.nextLine();
		
		//Creamos un Usuario con los datos introducidos
		Usuario usuario = new Usuario(nombreUsuario,emailUsuario,contraseniaUsuario);
		
		//Y lo registramos en el metodo de Persistencia del Usuario
		usuarioDao.registrar(usuario);
		
		
	}
	
}
