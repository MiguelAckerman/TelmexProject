package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionPSQL;
import POJO.Orden;

public class ModeloFallaSolucion {
	
	private ConexionPSQL conexion = new ConexionPSQL();
	public int x = 0;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int nuevaOrden(Orden orden){
		
		if(conexion != null){
			
			try {
				
				Statement nueva = conexion.getModeloConexion().createStatement();
				
				int a = nueva.executeUpdate("INSERT INTO personalequipofallasolucion (codigopef,exppersonal,noinventarioequipo,codigofalla,codigosolucion,fecharecibido, fechaliquidacion)"
						+ " VALUES ("+orden.getCodigopef()+", '"+orden.getExppersonal()+"', "+orden.getNoinventarioequipo()+", '"+orden.getCodigofalla()+"', '"+orden.getCodigosolucion()+"', '"+orden.getFecharecibido()+"', '"+orden.getFechaliquidacion()+"')");
				
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return x;
	}//SE AGREGA NUEVA ORDEN DE TRABAJO
	
	
	@SuppressWarnings("static-access")
	public DefaultTableModel tablaCatEquipo()
	{
		String columnas [] = {"Codigo","Exp. Empleado","No inventario Equipo","Codigo Falla","Codigo Solución"};
		
		DefaultTableModel catalogoEquipo = new DefaultTableModel(null, columnas);
		
		Object catalogo [] = new String[5];
		
		try
		{	
			Statement consultaDatos = conexion.getModeloConexion().createStatement();
			
			ResultSet resultados = consultaDatos.executeQuery("SELECT * FROM personalequipofallasolucion ORDER BY DESC"); 
			
			while(resultados.next())
			{
				catalogo[0]=resultados.getString("codigopef");
				catalogo[1]=resultados.getString("exppersonal");
				catalogo[2]=resultados.getString("noinventarioequipo");
				catalogo[3]=resultados.getString("codigofalla");
				catalogo[4]=resultados.getString("codigosolucion");
				catalogoEquipo.addRow(catalogo);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return catalogoEquipo;
	}//TABLA MODELO DONDE VISALIZAMOS LAS ORDENES 

}
