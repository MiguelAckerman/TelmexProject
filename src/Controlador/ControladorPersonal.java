package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Modelo.ModeloPersonal;
import Vista.VistaPersonal;

public class ControladorPersonal implements ActionListener, MouseListener{

	private ModeloPersonal modPer;
	private VistaPersonal vsPer;
	private POJO.Personal personal = new POJO.Personal();
	private int banderaBtn =  0;
	
	public ControladorPersonal(ModeloPersonal modPer, VistaPersonal vsPer){
		this.modPer = modPer;
		this.vsPer = vsPer;
		this.vsPer.tablaCliente.setModel(modPer.tablaCatPersonal());
		ActionListener(this);
		Mouselistener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource().equals(vsPer.agregarBtn)){
			
			banderaBtn = 1;
			
			vsPer.expedienteTxt.setText("");
			vsPer.nomTxt.setText("");
			vsPer.apTxt.setText("");
			vsPer.amTxt.setText("");
			vsPer.areaTxt.setText("");
			vsPer.codDepTxt.setText("");
			
			vsPer.expedienteTxt.setEditable(true);
			vsPer.nomTxt.setEditable(true);
			vsPer.apTxt.setEditable(true);
			vsPer.amTxt.setEditable(true);
			vsPer.areaTxt.setEditable(true);
			vsPer.codDepTxt.setEditable(true);
			
			vsPer.aceptarBtn.setVisible(true);
			
		}
		
		if(evento.getSource().equals(vsPer.editarBtn)){
			
			banderaBtn = 2;
			
			vsPer.nomTxt.setEditable(true);
			vsPer.apTxt.setEditable(true);
			vsPer.amTxt.setEditable(true);
			vsPer.areaTxt.setEditable(true);
			vsPer.codDepTxt.setEditable(true);
			
			vsPer.aceptarBtn.setVisible(true);
			vsPer.cancelarBtn.setVisible(true);
			
		}
		
		if(evento.getSource().equals(vsPer.aceptarBtn)){
			
			switch (banderaBtn) {
			
			case 1: //AGREGAR
				
				personal.setExp(String.valueOf(vsPer.expedienteTxt.getText()));
				personal.setNombre(String.valueOf(vsPer.nomTxt.getText()));
				personal.setaPaterno(String.valueOf(vsPer.apTxt.getText()));
				personal.setaMaterno(String.valueOf(vsPer.amTxt.getText()));
				personal.setArea(String.valueOf(vsPer.areaTxt.getText()));
				personal.setCodigo(String.valueOf(vsPer.codDepTxt.getText()));
				
				if(modPer.agregarPersonal(personal) == 1){
					
					JOptionPane.showMessageDialog(null, "Personal dado de alta con exito", null, JOptionPane.OK_OPTION);
					
					vsPer.tablaCliente.setModel(modPer.tablaCatPersonal());
					
					vsPer.expedienteTxt.setText("");
					vsPer.nomTxt.setText("");
					vsPer.apTxt.setText("");
					vsPer.amTxt.setText("");
					vsPer.areaTxt.setText("");
					vsPer.codDepTxt.setText("");
					vsPer.expedienteTxt.setEditable(false);
					vsPer.nomTxt.setEditable(false);
					vsPer.apTxt.setEditable(false);
					vsPer.amTxt.setEditable(false);
					vsPer.areaTxt.setEditable(false);
					vsPer.codDepTxt.setEditable(false);
					
					vsPer.aceptarBtn.setVisible(false);
					vsPer.cancelarBtn.setVisible(false);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Error, intentelo más tarde", null, JOptionPane.ERROR_MESSAGE);
				}
				
			break;
			
			case 2: //EDITAR
			
				personal.setExp(String.valueOf(vsPer.expedienteTxt.getText()));
				personal.setNombre(String.valueOf(vsPer.nomTxt.getText()));
				personal.setaPaterno(String.valueOf(vsPer.apTxt.getText()));
				personal.setaMaterno(String.valueOf(vsPer.amTxt.getText()));
				personal.setArea(String.valueOf(vsPer.areaTxt.getText()));
				personal.setCodigo(String.valueOf(vsPer.codDepTxt.getText()));
				
				if(modPer.editarPersonal(personal) == 1){
					
					JOptionPane.showMessageDialog(null, "Personal modificado con exito", null, JOptionPane.PLAIN_MESSAGE);
					
					vsPer.tablaCliente.setModel(modPer.tablaCatPersonal());
					
					vsPer.expedienteTxt.setText("");
					vsPer.nomTxt.setText("");
					vsPer.apTxt.setText("");
					vsPer.amTxt.setText("");
					vsPer.areaTxt.setText("");
					vsPer.codDepTxt.setText("");
					vsPer.expedienteTxt.setEditable(false);
					vsPer.nomTxt.setEditable(false);
					vsPer.apTxt.setEditable(false);
					vsPer.amTxt.setEditable(false);
					vsPer.areaTxt.setEditable(false);
					vsPer.codDepTxt.setEditable(false);
					
					vsPer.aceptarBtn.setVisible(false);
					vsPer.cancelarBtn.setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "Error, intentelo más tarde", null, JOptionPane.ERROR_MESSAGE);
				}
				
			break;
			
			
			default:
			
			}
			
		}
		
		if(evento.getSource().equals(vsPer.eliminarBtn)){
			
			int filas = vsPer.tablaCliente.getSelectedRow();
			
			if(filas > -1){
				
				String valTab = String.valueOf(vsPer.tablaCliente.getValueAt(filas, 0));
				
				if(modPer.eliminarPersonal(valTab) == 1){
					vsPer.tablaCliente.setModel(modPer.tablaCatPersonal());
					JOptionPane.showMessageDialog(null, "Dado de baja con exito!");
				} else {
					JOptionPane.showMessageDialog(null, "Error, intentelo más tarde", null, JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
		if(evento.getSource().equals(vsPer.cancelarBtn)){
			
			vsPer.expedienteTxt.setText("");
			vsPer.nomTxt.setText("");
			vsPer.apTxt.setText("");
			vsPer.amTxt.setText("");
			vsPer.areaTxt.setText("");
			vsPer.codDepTxt.setText("");
			vsPer.expedienteTxt.setEditable(false);
			vsPer.nomTxt.setEditable(false);
			vsPer.apTxt.setEditable(false);
			vsPer.amTxt.setEditable(false);
			vsPer.areaTxt.setEditable(false);
			vsPer.codDepTxt.setEditable(false);
			
			vsPer.aceptarBtn.setVisible(false);
			vsPer.cancelarBtn.setVisible(false);
			
			vsPer.tablaCliente.clearSelection();
			
		}
		
	}
	
	
	private void ActionListener(ControladorPersonal atiendeBtn) {
		vsPer.agregarBtn.addActionListener(atiendeBtn);
		vsPer.editarBtn.addActionListener(atiendeBtn);
		vsPer.aceptarBtn.addActionListener(atiendeBtn);
		vsPer.eliminarBtn.addActionListener(atiendeBtn);
		vsPer.cancelarBtn.addActionListener(atiendeBtn);
	}
	
	

	private void Mouselistener(ControladorPersonal atiendeclick) {
		vsPer.tablaCliente.addMouseListener(atiendeclick);
	}

	
	//es el que se hace uso
	public void mouseClicked(MouseEvent click) {
		
		if(click.getButton() == 1){
			int filas = vsPer.tablaCliente.getSelectedRow();
			
			if(filas > -1){
				
				String valTab = String.valueOf(vsPer.tablaCliente.getValueAt(filas, 0));
				
				String datos [] = modPer.consultaDatos(valTab);
				
				vsPer.areaTxt.setText(datos[0]);
				vsPer.codDepTxt.setText(datos[1]);
				vsPer.nomTxt.setText(datos[2]);
				vsPer.apTxt.setText(datos[3]);
				vsPer.amTxt.setText(datos[4]);
				vsPer.expedienteTxt.setText(datos[5]);
				
			}
		}
		
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
