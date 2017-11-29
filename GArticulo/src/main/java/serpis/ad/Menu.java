package serpis.ad;

import java.sql.SQLException;
import java.util.Scanner;

	public class Menu {
		//TODO enumeracion para el menu
		public enum Opcion {Salir, Nuevo, Editar, Eliminar, Consultar, Listar};
		public static void Menu() throws SQLException {
			Scanner sc = new Scanner(System.in);
			
		      System.out.print("Bienvenido a las consultas\n 0. Salir\n 1. Nuevo\n 2. Editar\n 3. Eliminar\n 4. Consultar\n 5. Listar\n");
		      System.out.print("¿Que desea hacer? ");
		      int op = sc.nextInt();
		      
		      switch ( op ) {
		      case 0:
		           //Salir
		    	  System.exit(0);
		           break;
		      case 1:
		           //Crear un elemento en la BD
		           break;
		      case 2:
		    	  //Editar un elemento de la BD
		           break;
		      case 3:
		           //Elimino un elemento de la BD
		    	  ArticuloDao.EliminarId();
		           break;
		      case 4:
		           //Consultar un elemento de la BD
		    	  ArticuloDao.Consultar();
		           break;
		      case 5:
		           //Listar la BD
		    	  ArticuloDao.Listar();
		           break;
		      default:
		           System.out.println("Error");
		           break;
		      }
	}
}
