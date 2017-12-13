package serpis.ad;

import java.sql.SQLException;
import java.util.*;

public class Menu {
	public static void Menu() throws SQLException {
		Scanner tcl = new Scanner(System.in);
		int n = 0;

		System.out.println("0.Salir");
		System.out.println("1.Nuevo");
		System.out.println("2.Editar");
		System.out.println("3.Eliminar");
		System.out.println("4.Consultar");
		System.out.println("5.Listar");

		try {

			System.out.println("Elige una opción: ");
			n = tcl.nextInt();

			switch (n) {
			case 0:
				System.out.println("Salir");
				break;
			case 1:
				ArticuloDao.Nuevo();
				break;
			case 2:
				ArticuloDao.Editar();
				break;
			case 3:
				ArticuloDao.Eliminar();
				break;
			case 4:
				ArticuloDao.Consultar();
				break;
			case 5:
				ArticuloDao.Listar();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Debes insertar un número de la lista.");
			Menu();
		}
	}

	public static void Volver() throws SQLException {
		Scanner tcl = new Scanner(System.in); 
		System.out.println("¿Quieres volver al menu? Y/N");
		String resultado = tcl.nextLine().toLowerCase();
		if (resultado.equals("y")) {
			Menu.Menu();
		}
		else {
			System.out.println("Programa Acabado");
			System.exit(0);
		}
	}
}