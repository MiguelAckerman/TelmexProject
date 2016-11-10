package Vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AltaSolucionCatalogo extends JFrame{
    
    public JFrame ventana;
    public JTextArea ta;
    public JLabel nosolucion, descripcion;
    public JPanel panel, panelTabla;
    public JScrollPane scrll;
    public JTable tabla;
    public JButton btnEditar, btnEliminar, btnNuevo;
    private JTextField textFalla;
    private JTextField textSolucion;
    
    public AltaSolucionCatalogo(){
        
        
        ventana     = new JFrame();
        nosolucion  = new JLabel("No. Solucion");
        descripcion = new JLabel("Descripci\u00F3n");
        
        
        panel       = new JPanel();
        panelTabla  = new JPanel();
        tabla       = new JTable();
        
        scrll       = new JScrollPane(tabla);
        
        btnEditar   = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnNuevo    = new JButton("Nuevo");
        
        ventana.getContentPane().setLayout(null);
        ventana.setSize(640, 465);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventana.setTitle("Catalogo de Solución");
        
        panel.setLayout(null);
        panel.setBounds(15, 172, 480, 100);
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Catalogo de Solución", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        
        nosolucion.setBounds(10, 20, 67, 30);
        panel.add(nosolucion);
        
        descripcion.setBounds(206, 20, 61, 30);
        panel.add(descripcion);
        
        ventana.getContentPane().add(panel);
        
        
        ta = new JTextArea();
        ta.setBounds(265,23,205,66);
        panel.add(ta);
        ta.setColumns(10);
        
        textSolucion = new JTextField();
        textSolucion.setBounds(87, 25, 94, 20);
        panel.add(textSolucion);
        textSolucion.setColumns(10);
        //TERMINA PANEL DE SOLUCIÓN
        
        tabla.setModel(new DefaultTableModel
                (
                        new Object[][]
                            {
                                {null,null,null,null}
                            },
                            new String[]
                            {
                                "No. Solucion","descripcion"
                            }
                    ));
        scrll.setBounds(10,20,480,120);
        
        panelTabla.setLayout(null);
        panelTabla.setBounds(15, 11, 500, 150);
        panelTabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Catalogo de Solución", TitledBorder.CENTER, TitledBorder.TOP, null, null));
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