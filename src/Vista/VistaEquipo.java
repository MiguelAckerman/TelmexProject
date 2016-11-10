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
public class VistaEquipo extends JFrame{
    
    public JFrame ventana;
    public JLabel noinventario,noserie, tipo, marca, modelo;
    public JPanel panel, panelTabla;
    public JScrollPane scrll;
    public JTable tabla;
    public JButton btnEditar, btnEliminar, btnNuevo;
    public JTextField textinventario;
    public JTextField textserie;
    public JTextField textmodelo;
    public JTextField textmarca;
    public JTextField texttipo;
    
    public VistaEquipo(){
        
        
        ventana        = new JFrame();
        noinventario   = new JLabel("No. Inventario");
        noserie        = new JLabel("No. Serie");
        tipo           = new JLabel("Tipo");
        marca          = new JLabel("Marca");
        modelo         = new JLabel("Modelo");
        
        panel       = new JPanel();
        panelTabla  = new JPanel();
        tabla       = new JTable();
        
        scrll       = new JScrollPane(tabla);
        
        btnEditar   = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnNuevo    = new JButton("Nuevo");
        
        ventana.getContentPane().setLayout(null);
        ventana.setSize(640, 366);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventana.setTitle("Equipo");
        
        panel.setLayout(null);
        panel.setBounds(5, 172, 500, 139);
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro Equipo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        
        noinventario.setBounds(10, 20, 73, 30);
        panel.add(noinventario);
        
        noserie.setBounds(196, 20, 54, 30);
        panel.add(noserie);
        
        tipo.setBounds(368, 20, 29, 30);
        panel.add(tipo);
        
        marca.setBounds(196, 68, 37, 30);
        panel.add(marca);
        
        modelo.setBounds(10, 68, 54, 30);
        panel.add(modelo);
        
        ventana.getContentPane().add(panel);
        
        textinventario = new JTextField();
        textinventario.setBounds(84, 25, 102, 20);
        panel.add(textinventario);
        textinventario.setColumns(10);
        
        textserie = new JTextField();
        textserie.setBounds(250, 25, 108, 20);
        panel.add(textserie);
        textserie.setColumns(10);
        
        textmodelo = new JTextField();
        textmodelo.setBounds(51, 73, 116, 20);
        panel.add(textmodelo);
        textmodelo.setColumns(10);
        
        textmarca = new JTextField();
        textmarca.setText("");
        textmarca.setBounds(243, 73, 115, 20);
        panel.add(textmarca);
        textmarca.setColumns(10);
        
        texttipo = new JTextField();
        texttipo.setText("");
        texttipo.setBounds(390, 25, 86, 20);
        panel.add(texttipo);
        texttipo.setColumns(10);
        //TERMINA PANEL DE EQUIPO
        
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
        scrll.setBounds(10,20,480,120);
        
        panelTabla.setLayout(null);
        panelTabla.setBounds(5, 11, 500, 150);
        panelTabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busq	ueda de Equipo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
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