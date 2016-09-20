package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionPSQL;
//import BaseDatos.ConexionPhpMyAdmin;
import POJO.CatalogoFalla;

public class ModeloCatalogoFallas {
	
	//private ConexionPhpMyAdmin conexion = new ConexionPhpMyAdmin();
	private ConexionPSQL conexion = new ConexionPSQL();
	
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int AgregarFalla(CatalogoFalla pFalla){
		x = 0;
		
		if (conexion != null ) {
			
			try {
				
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO CatalogoFalla(codigofalla,descripcionfalla) VALUES('"+pFalla.getCodigo()+"','"+pFalla.getDescripción()+"')");
				
				x = 1;
				
				return x;
				//SI HUBO CONEXIÓN Y SE EJECUTO EL QUERY CON EXITO
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			
			return x;
			//SI NO SE EJECUTO EL QUERY
		}
		return x;
		//SI NO HUBO CONEXIÓN
	}
	//FINALIZA METODO PARA DAR DE ALTA UN COCEPTO EN EL CATALOGO DE FALLAS
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatFalla()
	{
		String columnas [] = {"Codigo","Descripción"};
		//CREAMOS UN AREGLO CON Strings LOS CUALES REPRESENTAN LA CABECERA DE LAS COLUMNAS EN LA TABLA
		
		DefaultTableModel catalogoFalla = new DefaultTableModel(null, columnas);
		//DEFINIMOS UN MODELO DE TABLA Y LE PASAMOS LAS COLUMNAS QUE ESTE CONTENDRA
		
		Object catalogo [] = new String[2];
		//DEFINIMOS UN OBJETO EL CUAL CONTENDRA NUESTROS RESULTADOS DE LA CONSULTA
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT codigoFalla, descripcionFalla FROM catalogoFalla");
			//EN UN RESULTSET GUARDAMOS EL RESULTADO DEL QUERY 
			
			while(resultados.next())//RECORREMOS CADA RENGLON QUE NOS REGRESA EL QUERY
			{
				catalogo[0]=resultados.getString("codigoFalla");
				catalogo[1]=resultados.getString("descripcionFalla");//OBTENEMOS CADA RESULTADO DE LAS COLUMNAS QUE SOLICITAMOS
				catalogoFalla.addRow(catalogo);//AGREGAMOS EL OBJETO A LA TABLA
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();//ANALIZAR QUE REGREZAR EN CASO DE QUE NO ENCUENTRE NADA EL QUERY O ESTE MAL
		}
		return catalogoFalla;//REGRESAMOS EL MODELO DE LA TABLA YA CON LOS REGISTROS LLENOS
	}//FINALIZA EL METODO DONDE DAMOS HACEMOS UNA CONSULTA MASIVA DE DATOS
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatFallaPorCodigo(String codigo)
	{
		String columnas [] = {"Codigo","Descripción"};
		//CREAMOS UN AREGLO CON Strings LOS CUALES REPRESENTAN LA CABECERA DE LAS COLUMNAS EN LA TABLA
		
		DefaultTableModel catalogoFalla = new DefaultTableModel(null, columnas);
		//DEFINIMOS UN MODELO DE TABLA Y LE PASAMOS LAS COLUMNAS QUE ESTE CONTENDRA
		
		Object catalogo [] = new String[2];
		//DEFINIMOS UN OBJETO EL CUAL CONTENDRA NUESTROS RESULTADOS DE LA CONSULTA
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT codigoFalla, descripcionFalla FROM catalogoFalla WHERE codigoFalla = '" + codigo + "'");  
			//EN UN RESULTSET GUARDAMOS EL RESULTADO DEL QUERY 
			
			while(resultados.next())//RECORREMOS CADA RENGLON QUE NOS REGRESA EL QUERY
			{
				catalogo[0]=resultados.getString("codigoFalla");
				catalogo[1]=resultados.getString("descripcionFalla");//OBTENEMOS CADA RESULTADO DE LAS COLUMNAS QUE SOLICITAMOS
				catalogoFalla.addRow(catalogo);//AGREGAMOS EL OBJETO A LA TABLA
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();//ANALIZAR QUE REGREZAR EN CASO DE QUE NO ENCUENTRE NADA EL QUERY O ESTE MAL
		}
		return catalogoFalla;//REGRESAMOS EL MODELO DE LA TABLA YA CON LOS REGISTROS LLENOS
	}
	
	@SuppressWarnings("static-access")
	public String [] consultaDatos(String codigo)
	{
		//DEFINIMOS UN ARREGLO PAREA ALMACENAR LOS RESULTADOS DEL QUERY
		String [] datos = new String [1];
		
		if(conexion != null)
		{
			try 
			{
				Statement consulta = conexion.getModeloConexion().createStatement();
				
				ResultSet rs = consulta.executeQuery("SELECT descripcionFalla FROM catalogoFalla WHERE codigoFalla = '"+codigo+"'");
				
				while(rs.next())
				{
					datos[0]=rs.getString("descripcionFalla");//RECORREMOS EL RESULTADO Y BUSCAMOS LA COLUMNA QUE QUEREMOS
				}
				return datos;//REGRESAMOS EL ARREGLO CON EL RESULTADO QUE QUEREMOS
				
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return null;
	}//REGRESAMOS LA DESCRIPCIÓN DE LA FALLA SEGUN SEA EL CODIGO POR EL CUAL SE BUSCA
	
}
