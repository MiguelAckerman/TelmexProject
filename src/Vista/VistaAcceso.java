package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VistaAcceso extends JFrame {

	private JFrame ventana;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	public JTextField usuarioTxt;
	public JPasswordField contraPfld;
	public JButton entrarBtn;

		public VistaAcceso() {
			
			ventana = new JFrame();
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setBounds(100, 100, 356, 152);
			ventana.getContentPane().setLayout(null);
			ventana.setLocationRelativeTo(null);
			//ventana.getContentPane().setLayout(null);
			
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(6, 31, 61, 16);
			ventana.getContentPane().add(lblUsuario);
			
			usuarioTxt = new JTextField();
			usuarioTxt.setBounds(88, 26, 130, 26);
			ventana.getContentPane().add(usuarioTxt);
			usuarioTxt.setColumns(10);
			
			lblContrasea = new JLabel("Contraseña");
			lblContrasea.setBounds(6, 75, 80, 16);
			ventana.getContentPane().add(lblContrasea);
			
			contraPfld = new JPasswordField();
			contraPfld.setBounds(88, 70, 130, 26);
			ventana.getContentPane().add(contraPfld);
			
			entrarBtn = new JButton("Entrar");
			entrarBtn.setBounds(230, 26, 117, 70);
			ventana.getContentPane().add(entrarBtn);
			
			
		
			ventana.setVisible(true);
	}
}
