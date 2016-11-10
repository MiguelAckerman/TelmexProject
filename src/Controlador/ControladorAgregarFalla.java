package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.ModeloCatalogoFallas;
import POJO.CatalogoFalla;
import Vista.VistaAgregarFallta;

public class ControladorAgregarFalla implements ActionListener{
	
	private CatalogoFalla    pFalla = new CatalogoFalla();
	private ModeloCatalogoFallas modFa;
	private VistaAgregarFallta   vsFa;
	
	public ControladorAgregarFalla (ModeloCatalogoFallas modFa, VistaAgregarFallta vsFa){
		this.modFa = modFa;
		this.vsFa = vsFa;
		ActionListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getSource().equals(vsFa.agregarBtn)){
			
			pFalla.setCodigo(String.valueOf(vsFa.codigoFld.getText()));
			
			System.out.println("El usuario es: " + String.valueOf(vsFa.codigoFld.getText()));
			
			pFalla.setDescripcion(String.valueOf(vsFa.descripcionFld.getText()));
			
			System.out.println("La contraseña es:" + String.valueOf(vsFa.descripcionFld.getText()));
			
			if (modFa.AgregarFalla(pFalla)==1){
				
				JOptionPane.showMessageDialog(vsFa, "un mensaje de bien");
				
			} else {
				System.out.println("no se dio de alta");
			}
			
		}
		
	}
	
	private void ActionListener(ControladorAgregarFalla atiende) {
		vsFa.agregarBtn.addActionListener(atiende);
	}
	
	

}
