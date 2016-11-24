package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionSQL;
import POJO.Equipo;

public class ModeloEquipo {

	private ConexionSQL conexion = new ConexionSQL();

	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarEquipo(Equipo equipo){
		x = 0;
		
		if(conexion != null){
			
			try {
				
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO EQUIPO(noInventarioEquipo,tipoEquipo,noSerieEquipo,marcaEquipo,modeloEquipo) VALUES "
						+ "("+equipo.getNoInventario()+",'"+equipo.getTipo()+"',"+equipo.getNoSerie()+",'"+equipo.getMarca()+"','"+equipo.getModelo()+"')");
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			return x;
		}
		return x;
	}//METOD PARA DAR DE ALTA UN EQUIPO
	
	
	@SuppressWarnings({ "static-access", "unused" })
	public int modificaEquipo(Equipo equipo){
		x = 0;
		
		if(conexion != null){
			
			try {
				
				Statement modifica = conexion.getModeloConexion().createStatement();
		
				int m = modifica.executeUpdate("UPDATE EQUIPO SET tipoEquipo = '" +equipo.getTipo()+"', noSerieEquipo = '"+ equipo.getNoInventario() +"', marcaEquipo = '"+ equipo.getMarca() +"',"
						+ " modeloEquipo = '" + equipo.getModelo() +"' WHERE noInventarioEquipo = " + equipo.getNoInventario());
				
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return x;
	}//METODO PARA EDITAR UN EQUIPOS
	
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatEquipo()
	{
		String columnas [] = {"No. inventario","Tipo","No. Serie","Marca","Modelo"};
		
		DefaultTableModel catalogoEquipo = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[5];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM EQUIPO"); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("noinventarioequipo");
				catalogo[1]=resultados.getString("tipoequipo");
				catalogo[2]=resultados.getString("noserieequipo");
				catalogo[3]=resultados.getString("marcaequipo");
				catalogo[4]=resultados.getString("modeloequipo");
				catalogoEquipo.addRow(catalogo);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogoEquipo;
	}
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatEquipoPorNoInv(int noIn)
	{
		String columnas [] = {"No. inventario","Tipo","No. Serie","Marca","Modelo"};
		
		DefaultTableModel catalogoEquipo = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[5];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM EQUIPO WHERE noinventarioequipo = " +noIn); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("noinventarioequipo");
				catalogo[1]=resultados.getString("tipoequipo");
				catalogo[2]=resultados.getString("noserieequipo");
				catalogo[3]=resultados.getString("marcaequipo");
				catalogo[4]=resultados.getString("modeloequipo");
				catalogoEquipo.addRow(catalogo);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogoEquipo;
	}//MODELO DE LA TABLA POR NUMERO DE INVENTARIO
	
	
	@SuppressWarnings("static-access")
	public String [] consultaDatos(int noIn)
	{

		String [] datos = new String [5];
		
		if(conexion != null)
		{
			try 
			{
				Statement consulta = conexion.getModeloConexion().createStatement();
				
				ResultSet rs = consulta.executeQuery("SELECT * FROM Equipo WHERE noinventarioequipo = "+noIn);
				
				while(rs.next())
				{
					datos[0]=rs.getString("noInventarioEquipo");
					datos[1]=rs.getString("tipoEquipo");
					datos[2]=rs.getString("noSerieEquipo");
					datos[3]=rs.getString("marcaEquipo");
					datos[4]=rs.getString("modeloEquipo");
					
				}
				return datos;
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@SuppressWarnings({ "static-access", "unused" })
	public int eliminarEquipo(int id) {
		
		if (conexion != null){
		
			try {
				
				Statement elimina = conexion.getModeloConexion().createStatement();
				
				int a = elimina.executeUpdate("DELETE FROM Equipo WHERE id = " + id);
				
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
