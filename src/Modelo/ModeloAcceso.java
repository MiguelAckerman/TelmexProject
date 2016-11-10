package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BaseDatos.ConexionPSQL;
import BaseDatos.ConexionSQL;
import POJO.Usuario;

public class ModeloAcceso {
	
	//private ConexionPSQL conexion = new ConexionPSQL();
	private ConexionSQL conexion = new ConexionSQL();
	private String usuarioAux;
	private String contraAux;
	
	@SuppressWarnings({ "static-access"})
	public boolean acceso(String usuario, String contra){
	
		if(conexion != null){ //SI HAY CONEXION ENTRA AL PROCEDIMIETNO
			
			usuarioAux = "";
			contraAux = "";
			
			try {
				
				Statement user = conexion.getModeloConexion().createStatement();
				
				ResultSet us = user.executeQuery("SELECT usuario FROM usuario WHERE usuario = '"+ usuario.trim() +"'");
				
				if(us.next()) {
					usuarioAux = us.getString("usuario");
				} else  {
					return false;
				}
				
				if(usuarioAux.equals(usuario)){//CONSULTAMOS EL USUARIO Y SI COINCIDE CON EL POJO PASAMOS A COMPRAR LA CONTRASEÑA
					
					Statement pass = conexion.getModeloConexion().createStatement();
					
					ResultSet pwd = pass.executeQuery("SELECT contrasenia FROM Usuario WHERE contrasenia = '" + contra.trim() + "'");
					
					if(pwd.next()){
						contraAux = pwd.getString("contrasenia");
					} else {
						return false;
					}
					
					if(contraAux.equals(contra)){//CONSULTAMOS LA CONTRASEÑA Y SI COINCIDE CON EL POJO REGRESAMOS UN TRUE EN SEA EL DE QUE EL USUARIO EXISTE    
						return true;
					}
		
				} else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			return false;
		}
		
		return false;
	}

}
