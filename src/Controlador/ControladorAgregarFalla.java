package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ModeloCatalogoFallas;
import POJO.CatalogoFalla;
import Vista.VistaAgregarFallta;

public class ControladorAgregarFalla implements ActionListener{
	
	private CatalogoFalla    pFalla = new CatalogoFalla();
	private ModeloCatalogoFallas modFa;
	private VistaAgregarFallta   vsFa;
	private String a,b;
	
	public ControladorAgregarFalla (ModeloCatalogoFallas modFa, VistaAgregarFallta vsFa){
		this.modFa = modFa;
		this.vsFa = vsFa;
		ActionListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getSource().equals(vsFa.agregarBtn)){
			
			
			a = vsFa.codigoFld.getText().toString();
			
			b = vsFa.descripcionFld.getText().toString();
	
			System.out.println(a + "  " + b);
			
			pFalla.setCodigo(a);
			
			pFalla.setDescripción(b);
			
			if (modFa.AgregarFalla(pFalla)==1){
				
				
				
			} else {
				System.out.println("no se dio de alta");
			}
			
		}
		
	}
	
	private void ActionListener(ControladorAgregarFalla atiende) {
		vsFa.agregarBtn.addActionListener(atiende);
	}
	
	

}
