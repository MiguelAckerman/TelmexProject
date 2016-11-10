package Utileria;

import javax.swing.JOptionPane;

public class Mensajes {

	
	public void mensajeOk(){
		
		JOptionPane.showMessageDialog(null, "Operaci�n realizada con exito!", "OK", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void mensajeError(){
		
		JOptionPane.showMessageDialog(null, "Alg�n error al procesar los datos", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensajeAtencion(){
		
		JOptionPane.showMessageDialog(null, "Asegurese de revisar los datos", "Atenci�n", JOptionPane.WARNING_MESSAGE);
	}
	
	public void mensajeNoDatos(){
		
		JOptionPane.showMessageDialog(null, "No existen datos con relaci�n a la busqueda","", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
