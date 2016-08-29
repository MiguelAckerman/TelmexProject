package Modelo;

import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.ConexionPhpMyAdmin;
import POJO.Personal;

public class ModeloPersonal {
	
	private Personal personal = new Personal();
	private ConexionPhpMyAdmin con = new ConexionPhpMyAdmin();
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarPersonal (){
		
		x = 0;
		
		if (con != null){
			
			try {
				
				Statement alta = con.getModeloConexion().createStatement();
				
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

}
