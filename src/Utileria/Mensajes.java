package Utileria;

import javax.swing.JOptionPane;

public class Mensajes {

	
	public void mensajeOk(){
		
		JOptionPane.showMessageDialog(null, "Operación realizada con exito!", "OK", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void mensajeError(){
		
		JOptionPane.showMessageDialog(null, "Algún error al procesar los datos", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensajeAtención(){
		
		JOptionPane.showMessageDialog(null, "Asegurese de revisar los datos", "Atención", JOptionPane.WARNING_MESSAGE);
	}
	
	public void mensajeNoDatos(){
		
		JOptionPane.showMessageDialog(null, "No existen datos con relación a la busqueda","", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
