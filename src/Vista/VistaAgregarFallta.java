package Vista;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaAgregarFallta extends JFrame {
	
	public JFrame ventana;
	public JTextField codigoFld;
	public JTextField descripcionFld;
	public JButton agregarBtn;
	
	public VistaAgregarFallta() {
		
		ventana = new JFrame();
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(100, 100, 587, 378);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		ventana.getContentPane().add(lblCodigo);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 36, 79, 14);
		ventana.getContentPane().add(lblDescripcin);
		
		codigoFld = new JTextField();
		codigoFld.setBounds(66, 8, 151, 20);
		ventana.getContentPane().add(codigoFld);
		codigoFld.setColumns(10);
		
		descripcionFld = new JTextField();
		descripcionFld.setBounds(66, 33, 151, 20);
		ventana.getContentPane().add(descripcionFld);
		descripcionFld.setColumns(10);
		
		agregarBtn = new JButton("Agregar");
		agregarBtn.setBounds(65, 61, 89, 23);
		ventana.getContentPane().add(agregarBtn);
		
		ventana.setVisible(true);
	}
}
