package Vista;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaEquipo {

	public JFrame Ventana;
	public JPanel panelTabla;
    public JScrollPane scrll;
    public JTable tabla;
    
    private JLabel lblNoInventario;
    private JLabel lblNoSerie;
    private JLabel lblModelo;
    public JTextField noInventarioTxt;
    public JTextField noSerieTxt;
    public JTextField modeloTxt;
    public JComboBox tipoCbx;
    public JComboBox marcaCbx;
    public JButton agregarBtn;
    public JButton cancelarBtn;
    public JButton editarBtn;
    public JButton aceptarBtn;
    public JTextField marcaTxt;
    public JTextField tipoTxt;
    public JLabel lblTipo;
    public JLabel lblMarca;
    
	
	public VistaEquipo() {
		
        panelTabla  = new JPanel();
        tabla       = new JTable();
        scrll       = new JScrollPane(tabla);
		
        String tipo [] = {
        	"Teclado",
        	"Mause",
        	"Monitor",
        	"CPU",
        	"Cableado",
        };
        
        String marca [] = {
        	"HP",
        	"SONY",
        	"Lenovo",
        	"Logitech",
        };
        
		Ventana = new JFrame();
		Ventana.setBounds(100, 100, 666, 424);
		Ventana.setLocationRelativeTo(null);
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventana.getContentPane().setLayout(null);
		Ventana.setResizable(false);
		
		tabla.setModel(new DefaultTableModel
                (
                        new Object[][]
                            {
                                {null,null,null,null}
                            },
                            new String[]
                            {
                                "No. Inventario","No. Serie","Tipo","Marca","Modelo"
                            }
                    ));
        scrll.setBounds(6,24,643,120);
        
        panelTabla.setLayout(null);
        panelTabla.setBounds(5, 11, 655, 150);
        panelTabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipo", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panelTabla.add(scrll);
        Ventana.getContentPane().add(panelTabla);
        
        lblNoInventario = new JLabel("No. inventario");
        lblNoInventario.setBounds(5, 185, 100, 16);
        Ventana.getContentPane().add(lblNoInventario);
        
        noInventarioTxt = new JTextField();
        noInventarioTxt.setEditable(false);
        noInventarioTxt.setBounds(117, 180, 130, 26);
        Ventana.getContentPane().add(noInventarioTxt);
        
        lblNoSerie = new JLabel("No. Serie");
        lblNoSerie.setBounds(274, 185, 61, 16);
        Ventana.getContentPane().add(lblNoSerie);
        
        noSerieTxt = new JTextField();
        noSerieTxt.setEditable(false);
        noSerieTxt.setBounds(347, 180, 130, 26);
        Ventana.getContentPane().add(noSerieTxt);
        
        tipoCbx = new JComboBox(tipo);
        tipoCbx.setBounds(499, 181, 161, 27);
        tipoCbx.setVisible(false);
        Ventana.getContentPane().add(tipoCbx);
        
        lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(6, 228, 61, 16);
        Ventana.getContentPane().add(lblModelo);
        
        modeloTxt = new JTextField();
        modeloTxt.setEditable(false);
        modeloTxt.setBounds(117, 223, 130, 26);
        Ventana.getContentPane().add(modeloTxt);
        
        marcaCbx = new JComboBox(marca);
        marcaCbx.setBounds(274, 224, 161, 27);
        marcaCbx.setVisible(false);
        Ventana.getContentPane().add(marcaCbx);
        
        agregarBtn = new JButton("Agregar");
        agregarBtn.setBounds(543, 296, 117, 29);
        Ventana.getContentPane().add(agregarBtn);
        
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.setBounds(5, 296, 117, 29);
        Ventana.getContentPane().add(cancelarBtn);
        
        editarBtn = new JButton("Editar");
        editarBtn.setBounds(414, 296, 117, 29);
        Ventana.getContentPane().add(editarBtn);
        
        aceptarBtn = new JButton("Aceptar");
        aceptarBtn.setBounds(285, 296, 117, 29);
        aceptarBtn.setVisible(false);
        Ventana.getContentPane().add(aceptarBtn);
        
        marcaTxt = new JTextField();
        marcaTxt.setEditable(false);
        marcaTxt.setVisible(true);
        marcaTxt.setBounds(347, 223, 130, 26);
        Ventana.getContentPane().add(marcaTxt);
        marcaTxt.setColumns(10);
        
        tipoTxt = new JTextField();
        tipoTxt.setEditable(false);
        tipoTxt.setVisible(true);
        tipoTxt.setBounds(530, 180, 130, 26);
        Ventana.getContentPane().add(tipoTxt);
        tipoTxt.setColumns(10);
        
        lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(489, 185, 61, 16);
        lblTipo.setVisible(true);
        Ventana.getContentPane().add(lblTipo);
        
        lblMarca = new JLabel("Marca");
        lblMarca.setBounds(274, 228, 61, 16);
        lblMarca.setVisible(true);
        Ventana.getContentPane().add(lblMarca);
        
		
		Ventana.setVisible(true);
	}
}
