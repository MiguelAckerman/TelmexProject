package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionPSQL;
import BaseDatos.ConexionSQL;
import POJO.Usuario;

public class ModeloUsuario {
	
	//private ConexionPSQL conexion = new ConexionPSQL();
	private ConexionSQL conexion = new ConexionSQL();
	public int x = 0;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarUsuario(Usuario usuario){
		
		if(conexion != null){
			
			try {
				
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO Usuario () VALUES ()");
				
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return x;
	}//METODO DONDE AGREGAMOS UN NUEVO USUARIO
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaUsuario()
	{
		String columnas [] = {"ID","Nombre","Usuario"};
		
		DefaultTableModel catalogoUsuarios = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[3];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM Usuario"); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("id");
				catalogo[1]=resultados.getString("nombre");
				catalogo[2]=resultados.getString("usuario");
				catalogoUsuarios.addRow(catalogo);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogoUsuarios;
	}
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaUsuarioPorId(int id)
	{
		String columnas [] = {"ID","Nombre","Usuario"};
		
		DefaultTableModel catalogoUsuarios = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[3];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM Usuario WHERE id = " + id); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("id");
				catalogo[1]=resultados.getString("nombre");
				catalogo[2]=resultados.getString("usuario");
				catalogoUsuarios.addRow(catalogo);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogoUsuarios;
	}
	
	
	@SuppressWarnings({ "static-access", "unused" })
	public int revocarPermiso (int id){
		
		if(conexion != null){
			
			try {
				
				Statement revocar = conexion.getModeloConexion().createStatement();
				
				int a = revocar.executeUpdate("UPDATE Usuario SET estaus = 'B' WHERE id_usuario = "+id);
				
				x = 1;
				
				return x;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return x;
	}//METODO DONDE HACEMOS UN UPDATE AL COMPO ESTATUS Y DECIMOS QUE EL USUARIO ES INACTIVO O SE DIO DE BAJA
	
	@SuppressWarnings({ "static-access", "unused" })
	public int renovarPermiso (int id){
		
		if(conexion != null){
			
			try {
				
				Statement renovar = conexion.getModeloConexion().createStatement();
				
				int a = renovar.executeUpdate("UPDATE Usuario SET estaus = 'A' WHERE id_usuario = "+id);
				
				x = 1;
				
				return x;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return x;
	}//METODO DONDE HACEMOS UN UPDATE AL COMPO ESTATUS Y DECIMOS QUE EL USUARIO ES ACTIVO DE NUEVO

}
