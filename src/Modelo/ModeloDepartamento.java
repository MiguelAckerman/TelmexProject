package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import BaseDatos.ConexionPSQL;
import POJO.Departamento;

public class ModeloDepartamento {
	
	private Departamento depto = new Departamento();
	//private ConexionPhpMyAdmin con = new ConexionPhpMyAdmin();
	private ConexionPSQL conexion = new ConexionPSQL();
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarDepartamento(){
		x = 0;
		
		if (conexion != null){
			
			try {
				
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO Departamento (Departamento) VALUES ('"+depto.getDepartamento()+"')");
				
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}//METOD PARA INSERTAR DATOS EN LA TABLA Departamento
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatDepartamento(int id)
	{
		String columnas [] = {"Id","Departamento"};
		//CREAMOS UN AREGLO CON Strings LOS CUALES REPRESENTAN LA CABECERA DE LAS COLUMNAS EN LA TABLA
		
		DefaultTableModel catalogoDepartamentos = new DefaultTableModel(null, columnas);
		//DEFINIMOS UN MODELO DE TABLA Y LE PASAMOS LAS COLUMNAS QUE ESTE CONTENDRA
		
		Object catalogo [] = new String[2];
		//DEFINIMOS UN OBJETO EL CUAL CONTENDRA NUESTROS RESULTADOS DE LA CONSULTA
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM Departamento WHERE id = " + id);
			//EN UN RESULTSET GUARDAMOS EL RESULTADO DEL QUERY 
			
			while(resultados.next())//RECORREMOS CADA RENGLON QUE NOS REGRESA EL QUERY
			{
				catalogo[0]=resultados.getString("id");
				catalogo[1]=resultados.getString("departamento");//OBTENEMOS CADA RESULTADO DE LAS COLUMNAS QUE SOLICITAMOS
				catalogoDepartamentos.addRow(catalogo);//AGREGAMOS EL OBJETO A LA TABLA
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();//ANALIZAR QUE REGREZAR EN CASO DE QUE NO ENCUENTRE NADA EL QUERY O ESTE MAL
		}
		return catalogoDepartamentos;//REGRESAMOS EL MODELO DE LA TABLA YA CON LOS REGISTROS LLENOS
	}//METDO DONDE CARGAMOS UNA TABLA CON EL DEPARTAMENTO

	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatDepartamentoporId()
	{
		String columnas [] = {"Id","Departamento"};
		//CREAMOS UN AREGLO CON Strings LOS CUALES REPRESENTAN LA CABECERA DE LAS COLUMNAS EN LA TABLA
		
		DefaultTableModel catalogoDepartamentos = new DefaultTableModel(null, columnas);
		//DEFINIMOS UN MODELO DE TABLA Y LE PASAMOS LAS COLUMNAS QUE ESTE CONTENDRA
		
		Object catalogo [] = new String[2];
		//DEFINIMOS UN OBJETO EL CUAL CONTENDRA NUESTROS RESULTADOS DE LA CONSULTA
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM Departamento ");
			//EN UN RESULTSET GUARDAMOS EL RESULTADO DEL QUERY 
			
			while(resultados.next())//RECORREMOS CADA RENGLON QUE NOS REGRESA EL QUERY
			{
				catalogo[0]=resultados.getString("id");
				catalogo[1]=resultados.getString("departamento");//OBTENEMOS CADA RESULTADO DE LAS COLUMNAS QUE SOLICITAMOS
				catalogoDepartamentos.addRow(catalogo);//AGREGAMOS EL OBJETO A LA TABLA
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();//ANALIZAR QUE REGREZAR EN CASO DE QUE NO ENCUENTRE NADA EL QUERY O ESTE MAL
		}
		return catalogoDepartamentos;//REGRESAMOS EL MODELO DE LA TABLA YA CON LOS REGISTROS LLENOS
	}//METDO DONDE CARGAMOS UNA TABLA CON EL DEPARTAMENTO ESPECIFICO

	
	@SuppressWarnings("static-access")
	public String [] consultaDatos(int id)
	{
		//DEFINIMOS UN ARREGLO PAREA ALMACENAR LOS RESULTADOS DEL QUERY
		String [] datos = new String [1];
		
		if(conexion != null)
		{
			try 
			{
				Statement consulta = conexion.getModeloConexion().createStatement();
				
				ResultSet rs = consulta.executeQuery("SELECT departamento FROM Departamento WHERE id = " + id);
				
				while(rs.next())
				{
					datos[0]=rs.getString("");
				}
				return datos;
				
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}
		return null;
	}//METODO DONDE CONUSLTAMOS LOS DATOS QUE QUEREMOS ESPESIFICAMENTE

	
}


