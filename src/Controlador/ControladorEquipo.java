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
	private VistaEquipo visEqui;
	private Equipo equipo = new Equipo();
	
	public ControladorEquipo(ModeloEquipo modEqui, VistaEquipo visEqui){
		this.modEqui = modEqui;
		this.visEqui = visEqui;
		this.visEqui.tabla.setModel(modEqui.tablaCatEquipo());
		ActionListener(this);
	}
	

	public void actionPerformed(ActionEvent evento) {
	
		if(evento.getSource().equals(visEqui.btnNuevo)){
			
			equipo.setNoInventario(String.valueOf(visEqui.textinventario.getText()));
			equipo.setTipo(String.valueOf(visEqui.texttipo.getText()));
			equipo.setNoSerie(String.valueOf(visEqui.textserie.getText()));
			equipo.setMarca(String.valueOf(visEqui.textmarca.getText()));
			equipo.setModelo(String.valueOf(visEqui.textmodelo.getText()));
			
			if (modEqui.agregarEquipo(equipo) == 1) {
				JOptionPane.showMessageDialog(null, "Se agrego el Qeuipo con exito");
				
				visEqui.textinventario.setText("");
				visEqui.texttipo.setText("");
				visEqui.textserie.setText("");
				visEqui.textmarca.setText("");
				visEqui.textmodelo.setText("");
				visEqui.tabla.setModel(modEqui.tablaCatEquipo());	
			}
			
		}
		//TERMMINA EL BOTON DE AGREGAR
		
		if(evento.getSource().equals(visEqui.btnEditar)) {
			
			
			int filas = visEqui.tabla.getSelectedRow();
			
			if (filas > -1) {
				
				String valTab = String.valueOf(visEqui.tabla.getValueAt(filas, 0));
				int valCon = Integer.parseInt(valTab);
				
				String datos [] = modEqui.consultaDatos(valCon);
				
				visEqui.textinventario.setText(datos[0]);
				visEqui.texttipo.setText(datos[1]);
				visEqui.textserie.setText(datos[2]);
				visEqui.textmarca.setText(datos[3]);
				visEqui.textmodelo.setText(datos[4]);
				//visEqui.textcodigodepa.setText(datos[5]);
				
			}
		}//BOTON DE EDITAR
		
		if(evento.getSource().equals(visEqui.btnEliminar)){
			
			int filas = visEqui.tabla.getSelectedRow();
			
			if (filas > -1) {
				
				String valTab = String.valueOf(visEqui.tabla.getValueAt(filas, 0));
				int valCon = Integer.parseInt(valTab);
				
				modEqui.eliminarEquipo(valCon);
				visEqui.tabla.setModel(modEqui.tablaCatEquipo());
				
			}
		}
		
	}
	
	private void ActionListener(ControladorEquipo atiendePress) {
		
		visEqui.btnNuevo.addActionListener(atiendePress);
		visEqui.btnEditar.addActionListener(atiendePress);
		visEqui.btnEliminar.addActionListener(atiendePress);
		
	}


	//este es el que vamos a usar
	public void mouseClicked(MouseEvent clickMause) {
		
		
		
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
