package serpis.ad;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ArticuloDao {

	public static void Nuevo() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();
		Scanner tcl = new Scanner(System.in);
		System.out.println("Introduce un Nombre: ");
		String nombre = tcl.nextLine();
		System.out.println("Introduce un Categoria: ");
		long categoria = tcl.nextLong();
		System.out.println("Introduce un Precio: ");
		double precio = tcl.nextDouble();
		String sql = "INSERT INTO articulo (nombre, categoria, precio) VALUES ('" + nombre + "', '" + categoria + "', '" + precio + "')";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.executeUpdate();
		pst.close();
		connection.close();
		Listar();
		Menu.Volver();
	}

	public static void Editar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();
		Scanner tcl = new Scanner(System.in);
		System.out.print("Introduce id del dato a modificar: ");
		long id = tcl.nextLong();
		String sql = "SELECT * FROM articulo where ID =" + id;
		ResultSet rs = stp.executeQuery(sql);

		while (rs.next()) {
			String nombre = rs.getString("nombre");
			BigDecimal precio = rs.getBigDecimal("precio");
			long categoria = rs.getLong("categoria");
			System.out.println(
					"ID: " + id + " nombre: " + nombre + " 		categoria: " + categoria + " 		precio: " + precio);
		}
		
		tcl.nextLine();
		System.out.println("¿Qué deseas editar? Nombre/Categoria/Precio");
		String editar = tcl.nextLine().toLowerCase();

		if (editar.equals("nombre")) {
			System.out.println("Introduzca el nombre: ");
			String newN = tcl.nextLine();
			String entryN = "UPDATE articulo SET nombre = '" + newN + "' WHERE id = " + id;
			PreparedStatement pst = connection.prepareStatement(entryN);
			pst.executeUpdate();
			pst.close();
			System.out.println("Dato actualizado.");

		} else if (editar.equals("categoria")) {
			System.out.println("Introduzca la Categoria: ");
			long newC = tcl.nextLong();
			String entryC = "UPDATE articulo SET categoria = '" + newC + "' WHERE id = " + id;
			PreparedStatement pst = connection.prepareStatement(entryC);
			pst.executeUpdate();
			pst.close();
			System.out.println("Dato actualizado.");

		} else if (editar.equals("precio")) {
			System.out.println("Introduzca la Precio: ");
			String newP = tcl.nextLine();
			String entryP = "UPDATE articulo SET precio = '" + newP + "' WHERE id = " + id;
			PreparedStatement pst = connection.prepareStatement(entryP);
			pst.executeUpdate();
			pst.close();
			System.out.println("Dato actualizado.");
		}
		Listar();
		Menu.Volver();
		rs.close();
		stp.close();
		connection.close();
	}

	public static void Eliminar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();

		Scanner tcl = new Scanner(System.in);
		System.out.println("Introduce el numero de la id para eliminar: ");
		long id = tcl.nextLong();
		String sql = "DELETE FROM articulo where ID = ?";

		PreparedStatement pst = connection.prepareStatement(sql);

		pst.setLong(1, id);
		pst.executeUpdate();

		System.out.println("Dato eliminado.");
		Menu.Volver();
		stp.close();
		connection.close();
	}

	public static void Consultar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();
		Scanner tcl = new Scanner(System.in);
		System.out.println("Dato para consultar: ");
		long id = tcl.nextLong();
		String sql = "SELECT * FROM articulo where ID =" + id;
		ResultSet rs = stp.executeQuery(sql);

		while (rs.next()) {
			String nombre = rs.getString("nombre");
			BigDecimal precio = rs.getBigDecimal("precio");
			long categoria = rs.getLong("categoria");
			System.out.println(
					"ID: " + id + " nombre: " + nombre + " 		categoria: " + categoria + " 		precio: " + precio);
		}
		Menu.Volver();
		rs.close();
		stp.close();
		connection.close();
	}

	public static void Listar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();

		String sql = "SELECT * FROM articulo";
		ResultSet rs = stp.executeQuery(sql);
		while (rs.next()) {
			long id = rs.getLong("id");
			String nombre = rs.getString("nombre");
			BigDecimal precio = rs.getBigDecimal("precio");
			long categoria = rs.getLong("categoria");
			System.out.println("ID: " + id + " 	nombre: " + nombre + " 		categoria: " + categoria
					+ " 		precio: " + precio);
		}
		Menu.Volver();
		rs.close();
		stp.close();
		connection.close();
	}
}