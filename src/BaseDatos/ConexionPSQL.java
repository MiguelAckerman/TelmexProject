package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPSQL {
	
	private static String server;
	private static String user;
	private static String pass;
	private static String driver;
	
	public static Connection getModeloConexion()
	{
		
		server = "jdbc:postgresql://localhost:5432/TF_01";
		user   = "postgres";
		pass   = "pgadmin";
		driver = "org.postgresql.Driver";
	
		Connection conexion = null;
		
		try
		{
			//Class.forName(driver).newInstance();
			Class.forName(driver);
			conexion = DriverManager.getConnection(server,user,pass);	
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
