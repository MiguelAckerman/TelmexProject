package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPhpMyAdmin {
	
	public static Connection getModeloConexion()
	{
		
		Connection conexion = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/FT_01","root","");	
		}
		catch (SQLException SQLe)
		{
			SQLe.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return conexion;
		
	}

	
}
