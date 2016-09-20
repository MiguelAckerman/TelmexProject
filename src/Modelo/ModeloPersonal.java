package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionPSQL;
import POJO.Personal;

public class ModeloPersonal {
	
	private Personal personal = new Personal();
	//private ConexionPhpMyAdmin con = new ConexionPhpMyAdmin();
	private ConexionPSQL conexion = new ConexionPSQL();
	
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarPersonal (){
		
		x = 0;
		
		if (conexion != null){
			
			try {
				
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO Personal(expPersonal,nombrePersonal,aPaternoPersonal,aMaternoPersonal,areaPersonal) "
						+ "VALUES('"+personal.getExp()+"','"+personal.getNombre()+"','"+personal.getaPaterno()+"','"+personal.getaMaterno()+"','"+personal.getArea()+"')");
				
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
	

	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatPersonal()
	{
		String columnas [] = {"Expediente","Nombre","Ap Paterno","Ap Materno","Area"};
		
		DefaultTableModel catalogoPersonal = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[5];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM PERSONAL"); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("exppersonal");
				catalogo[1]=resultados.getString("nombrepersonal");
				catalogo[2]=resultados.getString("apaternopersonal");
				catalogo[3]=resultados.getString("amaternopersonal");
				catalogo[4]=resultados.getString("areapersonal");
				catalogoPersonal.addRow(catalogo);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogoPersonal;
	}
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatPersonalPorExpediende(String expediente)
	{
		String columnas [] = {"Expediente","Nombre","Ap Paterno","Ap Materno","Area"};
		
		DefaultTableModel catalogoPersonal = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[5];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM PERSONAL WHERE exppersonal = '"+expediente+"'"); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("exppersonal");
				catalogo[1]=resultados.getString("nombrepersonal");
				catalogo[2]=resultados.getString("apaternopersonal");
				catalogo[3]=resultados.getString("amaternopersonal");
				catalogo[4]=resultados.getString("areapersonal");
				catalogoPersonal.addRow(catalogo);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogoPersonal;
	}
	
	
	@SuppressWarnings("static-access")
	public String [] consultaDatos(String expediente)
	{

		String [] datos = new String [1];
		
		if(conexion != null)
		{
			try 
			{
				Statement consulta = conexion.getModeloConexion().createStatement();
				
				ResultSet rs = consulta.executeQuery("SELECT exppersonal FROM Personal WHERE exppersonal = '"+expediente+"'");
				
				while(rs.next())
				{
					datos[0]=rs.getString("exppersonal");
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
	
	/*exppersonal nombrepersonal apaternopersonal amaternopersonal areapersonal*/
	
}
