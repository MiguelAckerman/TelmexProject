package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BaseDatos.ConexionPSQL;
import POJO.Usuario;

public class ModeloAcceso {
	
	private ConexionPSQL conexion = new ConexionPSQL();
	
	@SuppressWarnings({ "static-access"})
	public boolean acceso(Usuario usuario){
	
		if(conexion != null){ //SI HAY CONEXIÓN ENTRA AL PROCEDIMIETNO
			
			try {
				
				Statement user = conexion.getModeloConexion().createStatement();
				
				ResultSet us = user.executeQuery("SELECT usuario FROM usuario WHERE usuario = '"+ usuario.getUsuario() +"'");
				
				if(us.equals(usuario.getUsuario().toString())){//CONSULTAMOS EL USUARIO Y SI COINCIDE CON EL POJO PASAMOS A COMPRAR LA CONTRASEÑA
					
					Statement pass = conexion.getModeloConexion().createStatement();
					
					ResultSet pwd = pass.executeQuery("SELECT contraseña FROM Usuario WHERE contraseña = '" + usuario.getContrasenia().toString() + "'");
					
					if(pwd.equals(usuario.getContrasenia().toString())){//CONSULTAMOS LA CONTRASEÑA Y SI COINCIDE CON EL POJO REGRESAMOS UN TRUE EN SEÑAL DE QUE EL USUARIO EXISTE    
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
