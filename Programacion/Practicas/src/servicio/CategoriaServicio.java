package servicio;

import java.util.Scanner;

import dominio.Categoria;
import persistencia.CategoriaDao;

//Implementamos la interfaz con todos los metodos
public class CategoriaServicio implements ICategoriaServicio{
	private final Scanner sc;
	private CategoriaDao categoriaDao;
	
	public CategoriaServicio(Scanner sc) {
		this.sc = sc;
		this.categoriaDao = new CategoriaDao();
	}

	@Override
	public Categoria buscarCategoria() {

	    System.out.println("Introduce el nombre de la categoría:");
	    String nombreCategoria = sc.nextLine();

	        if (categoriaDao.obtenerCategoria(nombreCategoria) != null) {
	            System.out.println("La categoria " + nombreCategoria + " es: " + categoriaDao.obtenerCategoria(nombreCategoria));
	            	return categoriaDao.obtenerCategoria(nombreCategoria);
	        }
	    
	    return null;
	}
}
