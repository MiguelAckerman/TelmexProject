package Vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class VistaPersonal extends JFrame {

	public JFrame ventana;
	private JPanel tablaJPnl;
	private JLabel lblExpediente;
	private JLabel lblArea;
	private JLabel lblCodigoDepto;
	private JLabel lblNombre;
	private JLabel lblAPaterno;
	private JLabel lblAMaterno;
	public JTextField expedienteTxt;
	public JTextField areaTxt;
	public JTextField codDepTxt;
	public JTextField nomTxt;
	public JTextField apTxt;
	public JTextField amTxt;
	public JButton editarBtn;
	public JButton agregarBtn;
	public JButton eliminarBtn;
	public JButton aceptarBtn;
	public JButton cancelarBtn;
	public JScrollPane scrollPane;
	public JTable tablaCliente;
	
	
	

	public VistaPersonal() {

		
		ventana = new JFrame();
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 666, 424);
		ventana.getContentPane().setLayout(null);
		
		tablaJPnl = new JPanel();
		tablaJPnl.setBorder(new TitledBorder(null, "Personal", TitledBorder.LEFT, TitledBorder.TOP, null, Color.DARK_GRAY));
		tablaJPnl.setLayout(null);
		tablaJPnl.setBounds(6, 6, 654, 187);
		ventana.getContentPane().add(tablaJPnl);
		
		tablaCliente = new JTable();
		tablaCliente.setModel(new DefaultTableModel
				(
						new Object[][]
							{
								{null,null,null,null}
							},
							new String[]
							{
								"Expediente","Nombre","Area"
							}
					));
		
		
		scrollPane = new JScrollPane(tablaCliente);
		scrollPane.setBounds(6, 28, 642, 153);
		tablaJPnl.add(scrollPane);
		
		
		
		ventana.getContentPane().setLayout(null);
		
		lblExpediente = new JLabel("Expediente");
		lblExpediente.setBounds(6, 229, 97, 16);
		ventana.getContentPane().add(lblExpediente);
		
		lblArea = new JLabel("Area");
		lblArea.setBounds(238, 229, 61, 16);
		ventana.getContentPane().add(lblArea);
		
		lblCodigoDepto = new JLabel("Codigo Depto");
		lblCodigoDepto.setBounds(432, 229, 97, 16);
		ventana.getContentPane().add(lblCodigoDepto);
		
		expedienteTxt = new JTextField();
		expedienteTxt.setEditable(false);
		expedienteTxt.setBounds(87, 224, 130, 26);
		ventana.getContentPane().add(expedienteTxt);
		expedienteTxt.setColumns(10);
		
		areaTxt = new JTextField();
		areaTxt.setEditable(false);
		areaTxt.setBounds(274, 224, 130, 26);
		ventana.getContentPane().add(areaTxt);
		areaTxt.setColumns(10);
		
		codDepTxt = new JTextField();
		codDepTxt.setEditable(false);
		codDepTxt.setBounds(530, 224, 105, 26);
		ventana.getContentPane().add(codDepTxt);
		codDepTxt.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(6, 292, 61, 16);
		ventana.getContentPane().add(lblNombre);
		
		lblAPaterno = new JLabel("A. Paterno");
		lblAPaterno.setBounds(219, 292, 78, 16);
		ventana.getContentPane().add(lblAPaterno);
		
		lblAMaterno = new JLabel("A. Materno");
		lblAMaterno.setBounds(433, 292, 96, 16);
		ventana.getContentPane().add(lblAMaterno);
		
		nomTxt = new JTextField();
		nomTxt.setEditable(false);
		nomTxt.setColumns(10);
		nomTxt.setBounds(65, 287, 130, 26);
		ventana.getContentPane().add(nomTxt);
		
		apTxt = new JTextField();
		apTxt.setEditable(false);
		apTxt.setColumns(10);
		apTxt.setBounds(291, 287, 130, 26);
		ventana.getContentPane().add(apTxt);
		
		amTxt = new JTextField();
		amTxt.setEditable(false);
		amTxt.setColumns(10);
		amTxt.setBounds(505, 287, 130, 26);
		ventana.getContentPane().add(amTxt);
		
		editarBtn = new JButton("Editar");
		editarBtn.setBounds(428, 355, 117, 29);
		ventana.getContentPane().add(editarBtn);
		
		agregarBtn = new JButton("Agregar");
		agregarBtn.setBounds(543, 355, 117, 29);
		ventana.getContentPane().add(agregarBtn);
		
		eliminarBtn = new JButton("Eliminar");
		eliminarBtn.setBounds(6, 355, 117, 29);
		ventana.getContentPane().add(eliminarBtn);
		
		aceptarBtn = new JButton("Aceptar");
		aceptarBtn.setBackground(Color.GRAY);
		aceptarBtn.setBounds(314, 355, 117, 29);
		aceptarBtn.setVisible(false);
		ventana.getContentPane().add(aceptarBtn);
		
		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.setBackground(Color.GRAY);
		cancelarBtn.setBounds(201, 355, 117, 29);
		cancelarBtn.setVisible(false);
		ventana.getContentPane().add(cancelarBtn);
		
		ventana.setVisible(true);
		
		
	}
}
