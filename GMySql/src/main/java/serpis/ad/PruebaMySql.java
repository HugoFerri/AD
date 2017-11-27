package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaMySql {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String DB_URL = "jdbc:mysql://localhost/dbprueba";
		String USER = "root";
		String PASS = "sistemas";
		String sql;
		   
		Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt = connection.createStatement();

	    Class.forName("com.mysql.cj.jdbc.Driver");

	    sql = "SELECT * FROM categoria";
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()){
	         int id  = rs.getInt("id");
	         String nombre = rs.getString("nombre");

	         System.out.println("ID: " + id + " nombre: " + nombre);
	      }
	    
	      rs.close();
	      stmt.close();
	      connection.close();
	}
}