package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import BaseDatos.ConexionPSQL;
import POJO.Equipo;

public class ModeloEquipo {
	
	private Equipo equipo = new Equipo();
	//private ConexionPhpMyAdmin con = new ConexionPhpMyAdmin();
	private ConexionPSQL conexion = new ConexionPSQL();
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	private int agregarEquipo(){
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
			
		}
		
		return x;
	}//METOD PARA DAR DE ALTA UN EQUIPO
	
	
	
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

		String [] datos = new String [1];
		
		if(conexion != null)
		{
			try 
			{
				Statement consulta = conexion.getModeloConexion().createStatement();
				
				ResultSet rs = consulta.executeQuery("SELECT noinventarioequipo FROM Equipo WHERE noinventarioequipo = "+noIn);
				
				while(rs.next())
				{
					datos[0]=rs.getString("noinventarioequipo");
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
	
	
	
	/* noinventarioequipo tipoequipo noserieequipo marcaequipo modeloequipo*/
	
}
