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

	public static void Listar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();

	    String sql = "SELECT * FROM articulo";
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()){
	         long id  = rs.getLong("id");
	         String nombre = rs.getString("nombre");
	         BigDecimal precio = rs.getBigDecimal("precio");
	         long categoria = rs.getLong("categoria");

	         System.out.println("ID: " + id + " nombre: " + nombre + " precio: " + precio + " categoria: " + categoria);
	      }
	    
	      rs.close();
	      stmt.close();
	}
	
	public static void Consultar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el registro que deseas consultar: ");
		int idConsultar = sc.nextInt();
	    String sql = "SELECT * FROM articulo where id=" + idConsultar;
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()){
	         long id  = rs.getLong("id");
	         String nombre = rs.getString("nombre");
	         BigDecimal precio = rs.getBigDecimal("precio");
	         long categoria = rs.getLong("categoria");

	         System.out.println("ID: " + id + " nombre: " + nombre + " precio: " + precio + " categoria: " + categoria);
	      }

	    rs.close();
	    stmt.close();
	}
	
	public static void EliminarId() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el registro que deseas eliminar: ");
		int idEliminar = sc.nextInt();
		
		String sql = "DELETE FROM articulo WHERE id = ? ";
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setLong(1, idEliminar);
		pstmt.executeUpdate();
		
	    stmt.close();
	}
}
