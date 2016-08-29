package Vista;


import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PruebaUno extends JFrame {

	public JFrame ventana;
	private JTextField unoTfld;

	public PruebaUno() {
		
		ventana = new JFrame();
		unoTfld = new JTextField();
		JLabel lblUno = new JLabel("uno");
		
		lblUno.setBounds(10, 11, 46, 14);
		ventana.add(lblUno);
		
		
		unoTfld.setBounds(66, 8, 132, 20);
		ventana.add(unoTfld);
		unoTfld.setColumns(10);
		
		
		
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 450, 300);
		
		
		
		ventana.setVisible(true);
	}
}
