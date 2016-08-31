package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPhpMyAdmin {
	
	private static String server;
	private static String user;
	private static String pass;
	private static String driver;
	
	public static Connection getModeloConexion()
	{
		
		server = "jdbc:mysql://localhost/FT_01";
		user   = "root";
		pass   = "";//NO TIENE POR EL MOENTO
		driver = "com.mysql.jdbc.Driver";
	
		
		Connection conexion = null;
		
		try
		{
			Class.forName(driver).newInstance();
			conexion = (Connection) DriverManager.getConnection(server,user,pass);	
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
