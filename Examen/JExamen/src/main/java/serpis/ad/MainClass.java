package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TODO completar
public class MainClass {

	public static void main(String[] args) throws SQLException {
		
		//----- RESPETAR ESTE CODIGO ------
		
		Categoria categoria = load(1L); 
		categoria.setNombre(categoria.getNombre() + "#j");
		update(categoria);
		
		//----------------------------------
	}
	
	private static Categoria load(Object id) throws SQLException {
		Categoria categoria = new Categoria();
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		Statement stp = connection.createStatement();
		
		String sql = "SELECT * FROM categoria where ID =" + id;
		ResultSet rs = stp.executeQuery(sql);
		
		while (rs.next()) {
			categoria.setId(rs.getLong("id"));
			categoria.setNombre(rs.getString("nombre"));
			System.out.println("ID: " + id + " 	categoria: " + categoria);
		}
		
		rs.close();
		stp.close();
		connection.close();
		
		return categoria;
	}
	
	private static void update(Categoria categoria) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		
		String SQLUpdate = "UPDATE categoria SET nombre = ? WHERE id = 1";
		
		PreparedStatement  pst = connection.prepareStatement(SQLUpdate);
		
		pst.setString(1, categoria.getNombre());
		pst.executeUpdate();
		
		pst.close();
		connection.close();
	}

}
