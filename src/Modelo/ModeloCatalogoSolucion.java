package Modelo;

import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.ConexionPhpMyAdmin;
import POJO.CatalogoSolucion;

public class ModeloCatalogoSolucion {
	
	private ConexionPhpMyAdmin con = new ConexionPhpMyAdmin();
	private CatalogoSolucion catSolucion = new CatalogoSolucion();
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarSolicion(){
		x = 0;
		
		if(con != null){
			
			try {
				
				Statement alta = con.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO catalogoSoluciones (codigoSolucion,descripcionSolucion) VALUES ('"+catSolucion.getCodigo()+"','"+catSolucion.getDescripción()+"')");
				
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
