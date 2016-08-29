package Modelo;

import java.sql.SQLException;
import java.sql.Statement;
import BaseDatos.ConexionPhpMyAdmin;
import POJO.Departamento;

public class ModeloDepartamento {
	
	private Departamento depto = new Departamento();
	private ConexionPhpMyAdmin con = new ConexionPhpMyAdmin();
	private int x;
	
	@SuppressWarnings({ "static-access", "unused" })
	public int agregarDepartamento(){
		x = 0;
		
		if (con != null){
			
			
			try {
				
				Statement alta = con.getModeloConexion().createStatement();
				
				int a = alta.executeUpdate("INSERT INTO Departamento(Departamento) VALUES ('"+depto.getDepartamento()+"')");
				
				x = 1;
				
				return x;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
}


