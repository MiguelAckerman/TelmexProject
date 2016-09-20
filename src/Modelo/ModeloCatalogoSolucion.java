package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionPSQL;
import POJO.CatalogoSolucion;

public class ModeloCatalogoSolucion {
	
	
	private ConexionPSQL conexion = new ConexionPSQL();
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarSolicion(CatalogoSolucion catSo){
		x = 0;
		
		if(conexion != null){
			
			try {
				
				Statement alta = conexion.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO catalogoSoluciones (codigoSolucion,descripcionSolucion) VALUES ('"+catSo.getCodigo()+"', '"+catSo.getDescripción()+"')");
				
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			return x;
		}
		return x;
	}//FINALIZA METODO OARA DAR DE ALTA UNA SOLUCIÓN
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatSolucion()
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
	public DefaultTableModel tablaCatSolucionPorCodigo(String codigo)
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
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT codigoFalla, descripcionFalla FROM catalogoFalla WHERE codigoFalla = " + codigo);
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
				
				ResultSet rs = consulta.executeQuery("SELECT descripcionsolucion FROM catalogosoluciones WHERE codigosolucion = '"+codigo+"'");
				
				while(rs.next())
				{
					datos[0]=rs.getString("descripcionsolucion");//RECORREMOS EL RESULTADO Y BUSCAMOS LA COLUMNA QUE QUEREMOS
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
