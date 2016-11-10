package Vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VistaDetalleCLiente extends JFrame{
    
    public JFrame ventana;
    public JLabel noexp, nombre, puesto, ciudad, departamento;
    public JPanel panel, panelTabla;
    public JScrollPane scrll;
    public JTable tabla;
    public JButton btnEditar, btnEliminar, btnNuevo;
    private JTextField textexp;
    private JTextField textnombre;
    private JTextField textpuesto;
    private JTextField textciudad;
    private JTextField textdepartamento;
    
    public VistaDetalleCLiente(){
        
        
        ventana      = new JFrame();
        
        noexp        = new JLabel("No. Expediente");
        nombre       = new JLabel("Nombre");
        puesto       = new JLabel("Puesto");
        ciudad       = new JLabel("Ciudad");
        departamento = new JLabel("departamento");
        
        panel       = new JPanel();
        panelTabla  = new JPanel();
        tabla       = new JTable();
        
        scrll       = new JScrollPane(tabla);
        
        btnEditar   = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnNuevo    = new JButton("Nuevo");
        
        ventana.getContentPane().setLayout(null);
        ventana.setSize(640, 372);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventana.setTitle("Detalle Trabajador");
        
        panel.setLayout(null);
        panel.setBounds(10, 181, 500, 151);
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda Trabajador", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        
        noexp.setBounds(10, 20, 81, 30);
        panel.add(noexp);
        
        nombre.setBounds(203, 20, 100, 30);
        panel.add(nombre);
        
        puesto.setBounds(10, 78, 44, 30);
        panel.add(puesto);
        
        ciudad.setBounds(203, 78, 44, 30);
        panel.add(ciudad);
        
        departamento.setBounds(10, 119, 100, 30);
        panel.add(departamento);
        
        
        ventana.getContentPane().add(panel);
        
        textexp = new JTextField();
        textexp.setBounds(87, 25, 106, 20);
        panel.add(textexp);
        textexp.setColumns(10);
        
        textnombre = new JTextField();
        textnombre.setText("");
        textnombre.setBounds(249, 25, 208, 20);
        panel.add(textnombre);
        textnombre.setColumns(10);
        
        textpuesto = new JTextField();
        textpuesto.setBounds(48, 83, 145, 20);
        panel.add(textpuesto);
        textpuesto.setColumns(10);
        
        textciudad = new JTextField();
        textciudad.setBounds(249, 83, 134, 20);
        panel.add(textciudad);
        textciudad.setColumns(10);
        
        textdepartamento = new JTextField();
        textdepartamento.setBounds(97, 124, 194, 20);
        panel.add(textdepartamento);
        textdepartamento.setColumns(10);
        //TERMINA PANEL DE DETALLE CLIENTE
        
        tabla.setModel(new DefaultTableModel
                (
                        new Object[][]
                            {
                                {null,null,null,null}
                            },
                            new String[]
                            {
                                "No. exp","Nombre","puesto","ciudad","departamento"
                            }
                    ));
        scrll.setBounds(10,20,480,120);
        
        panelTabla.setLayout(null);
        panelTabla.setBounds(10, 20, 500, 150);
        panelTabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Regristro Trabajador", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        panelTabla.add(scrll);
        ventana.getContentPane().add(panelTabla);
        
        btnEditar.setBounds(520, 140, 100, 30);
        ventana.getContentPane().add(btnEditar);
        
        btnEliminar.setBounds(520, 190, 100, 30);
        ventana.getContentPane().add(btnEliminar);
        
        btnNuevo.setBounds(520, 240, 100, 30);
        ventana.getContentPane().add(btnNuevo);
        
        ventana.setVisible(true);
    }

}
