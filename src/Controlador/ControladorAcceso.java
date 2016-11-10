package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.ModeloAcceso;
import POJO.Usuario;
import Vista.VistaAcceso;

public class ControladorAcceso implements ActionListener{

	private ModeloAcceso modAcc;
	private VistaAcceso visAcc;
	//private Usuario usuario = new Usuario();
	String usuario;
	String contra;
	
	public ControladorAcceso(ModeloAcceso modAcc, VistaAcceso visAcc){
		this.modAcc = modAcc;
		this.visAcc = visAcc;
		ActionListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource().equals(visAcc.entrarBtn)){
			
			//usuario.setNombre(String.valueOf(visAcc.usuarioTxt.getText()));
			//usuario.setContrasenia(String.valueOf(visAcc.contraPfld.getText().toString()));
			
			usuario = String.valueOf(visAcc.usuarioTxt.getText());
			contra = String.valueOf(visAcc.contraPfld.getText());
			
			if(modAcc.acceso(usuario, contra) == true){
				
				JOptionPane.showMessageDialog(null, "Bienvenido","OK", JOptionPane.OK_OPTION);
				//FALTA PORNER LA NUEVA REDIRRECIÓN AL MENÚ
				
			} else{
				JOptionPane.showMessageDialog(null, "ERROR","Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
	
	private void ActionListener(ControladorAcceso atiende) {
		
		visAcc.entrarBtn.addActionListener(atiende);
	}
	
}
