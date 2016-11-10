package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Equipo {

	public JFrame Ventana;

	public Equipo() {
		
		Ventana = new JFrame();
		Ventana.setBounds(100, 100, 450, 300);
		Ventana.setLocationRelativeTo(null);
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Ventana.setVisible(true);
	}

}
