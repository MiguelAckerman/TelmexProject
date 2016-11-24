package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Modelo.ModeloEquipo;
import POJO.Equipo;
import Vista.VistaEquipo;

public class ControladorEquipo implements ActionListener, MouseListener{
	
	private ModeloEquipo modEqui;
	private VistaEquipo vsEquipo;
	private Equipo equipo = new Equipo();
	
	public ControladorEquipo(ModeloEquipo modEqui, VistaEquipo vsEquipo){
		this.vsEquipo = vsEquipo;
		this.modEqui = modEqui;
		ActionListener(this);
		MouseListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource().equals(vsEquipo.agregarBtn)){
			
			vsEquipo.noInventarioTxt.setEditable(false);
			vsEquipo.noSerieTxt.setEditable(false);
			vsEquipo.modeloTxt.setEditable(false);
			vsEquipo.tipoCbx.setVisible(true);
			vsEquipo.marcaCbx.setVisible(true);
			
			vsEquipo.lblMarca.setVisible(false);
			vsEquipo.lblTipo.setVisible(false);
			vsEquipo.marcaTxt.setVisible(false);
			vsEquipo.tipoTxt.setVisible(false);
			
			//falta regla para validar vacios
			
			equipo.setNoInventario(String.valueOf(vsEquipo.noInventarioTxt.getText()));
			equipo.setTipo(String.valueOf(vsEquipo.tipoCbx.getSelectedItem()));
			equipo.setNoSerie(String.valueOf(vsEquipo.noSerieTxt.getText()));
			equipo.setMarca(String.valueOf(vsEquipo.marcaCbx.getSelectedItem()));
			equipo.setModelo(String.valueOf(vsEquipo.modeloTxt.getText()));
			
			if(modEqui.agregarEquipo(equipo) == 1){
				
				vsEquipo.noInventarioTxt.setText("");
				vsEquipo.noSerieTxt.setText("");
				vsEquipo.modeloTxt.setText("");
				
				
				vsEquipo.noInventarioTxt.setEditable(false);
				vsEquipo.noSerieTxt.setEditable(false);
				vsEquipo.modeloTxt.setEditable(false);
				
			} else {
				JOptionPane.showMessageDialog(null, "Erro!, intenetelo más tarde");
			}
			
		}
		
		if(evento.getSource().equals(vsEquipo.editarBtn)){
			
			
		}
		
		if(evento.getSource().equals(vsEquipo.aceptarBtn)){
			
			
		}
		
		if(evento.getSource().equals(vsEquipo.cancelarBtn)){
			
			vsEquipo.noInventarioTxt.setText("");
			vsEquipo.noSerieTxt.setText("");
			vsEquipo.modeloTxt.setText("");
			
			vsEquipo.noInventarioTxt.setEditable(false);
			vsEquipo.noSerieTxt.setEditable(false);
			vsEquipo.modeloTxt.setEditable(false);
			
			
			//falta ver la regla para cuanod cambie de editar a modo normal
		}
		
	}
	
	private void ActionListener(ControladorEquipo atiende) {
		
	}
	
	private void MouseListener(ControladorEquipo atiendeTabla) {
		
	}

	public void mouseClicked(MouseEvent click) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}


	public void mouseExited(MouseEvent e) {
		
	}
	
}
