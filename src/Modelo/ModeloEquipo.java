package Modelo;

import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.ConexionPhpMyAdmin;
import POJO.Equipo;

public class ModeloEquipo {
	
	private Equipo equipo = new Equipo();
	private ConexionPhpMyAdmin con = new ConexionPhpMyAdmin();
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	private int agregarEquipo(){
		x = 0;
		
		if(con != null){
			
			try {
				
				Statement alta = con.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO EQUIPO(noInventarioEquipo,tipoEquipo,noSerieEquipo,marcaEquipo,modeloEquipo) VALUES "
						+ "("+equipo.getNoInventario()+",'"+equipo.getTipo()+"',"+equipo.getNoSerie()+",'"+equipo.getMarca()+"','"+equipo.getModelo()+"')");
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return x;
	}
	


}
