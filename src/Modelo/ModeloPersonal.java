package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import BaseDatos.ConexionSQL;
import POJO.Personal;

public class ModeloPersonal {
	
	//private Personal personal = new Personal();
	private ConexionSQL conexion = new ConexionSQL();
	//private ConexionPSQL conexion = new ConexionPSQL();
	
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarPersonal (Personal personal){
		
		x = 0;
		
		if (conexion != null){
			
			try {
				
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO Personal(expPersonal,nombrePersonal,aPaternoPersonal,aMaternoPersonal,areaPersonal, codigoDepartamento) "
						+ "VALUES('"+ String.valueOf(personal.getExp()) +"','"+ String.valueOf(personal.getNombre()) +"','"+ String.valueOf(personal.getaPaterno())  +"','"+ String.valueOf(personal.getaMaterno()) +"','"+ String.valueOf(personal.getArea())+ "','" + String.valueOf(personal.getCodigo()) +"')");
				
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
	
@SuppressWarnings({ "static-access", "unused" })
public int editarPersonal (Personal personal){
		
		x = 0;
		
		if (conexion != null){
			
			try {
				
				Statement editar = conexion.getModeloConexion().createStatement();
				
				int e = editar.executeUpdate("UPDATE Personal SET nombrePersonal = '"+ String.valueOf(personal.getNombre()) +"', aPaternoPersonal = '"+ String.valueOf(personal.getaPaterno())  +"' , aMaternoPersonal = '"+ String.valueOf(personal.getaMaterno()) +"', areaPersonal = '"+ String.valueOf(personal.getArea())+ "', codigoDepartamento = '" + String.valueOf(personal.getCodigo()) +"' WHERE expPersonal = '"+ String.valueOf(personal.getExp()) +"'");
				
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
	
	@SuppressWarnings({ "static-access", "unused" })
	public int eliminarPersonal(String expediente){
		
		x = 0;
		
		if(conexion != null){
			
			try {
				
				Statement elimina = conexion.getModeloConexion().createStatement();
				
				int eli = elimina.executeUpdate("DELETE FROM Personal WHERE expPersonal = '" + expediente.trim() + "'");
				
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
		String columnas [] = {"Expediente","Nombre","Area"};
		
		DefaultTableModel catalogoPersonal = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[3];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM PERSONAL"); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("exppersonal");
				catalogo[1]=resultados.getString("nombrepersonal");
				catalogo[2]=resultados.getString("areapersonal");
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

		String [] datos = new String [6];
		
		if(conexion != null)
		{
			try 
			{
				Statement consulta = conexion.getModeloConexion().createStatement();
				
				ResultSet rs = consulta.executeQuery("SELECT * FROM Personal WHERE exppersonal = '"+expediente+"'");
				
				while(rs.next())
				{
					datos[0]=rs.getString("areaPersonal");
					datos[1]=rs.getString("codigoDepartamento");
					datos[2]=rs.getString("nombrePersonal");
					datos[3]=rs.getString("aPaternoPersonal");
					datos[4]=rs.getString("aMaternoPersonal");
					datos[5]=rs.getString("expPersonal");
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
	
	
	
}
