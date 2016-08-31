package Modelo;

import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.ConexionPhpMyAdmin;
import POJO.CatalogoFalla;

public class ModeloCatalogoFallas {
	
	private ConexionPhpMyAdmin conexion = new ConexionPhpMyAdmin();
	
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int AgregarFalla(CatalogoFalla pFalla){
		x = 0;
		
		if (conexion != null ) {
			
			try {
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO CatalogoFalla(codigo_falla,descripcion_falla) VALUES('"+pFalla.getCodigo()+"','"+pFalla.getDescripción()+"')");
				
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			
			return x;
		}
		return x;
	}
	
	
}
