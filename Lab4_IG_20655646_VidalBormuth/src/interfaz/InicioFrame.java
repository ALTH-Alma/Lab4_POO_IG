package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.LineBorder;


/**
 * Clase que representa la vista de la ventana que permite dar inicio al sistema de StackOverflow.. 
 * @author Alma
 *
 */
public class InicioFrame extends JFrame {
	
	private JPanel contentPane;
	private JTable tablePreguntasStack;
	

	/**
	 * Metodo de obtención para obtener la tabla que mostrara el listado de preguntas del stack.
	 * @return tabla para preguntas stack.
	 */
	public JTable getTablePreguntasStack() {
		return tablePreguntasStack;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioFrame frame = new InicioFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("Bienvenido a StackOverflow!!");
		lblTitulo.setBounds(85, 32, 1178, 73);
		lblTitulo.setToolTipText("");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblTitulo.setBackground(Color.BLACK);
		contentPane.add(lblTitulo);
		
		JButton btnIniSesion = new JButton("Iniciar sesion");
		btnIniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.InicioControl.eventoBtnIngresar(); //Event Handler para controlar el click del boton Iniciar sesión. Permite llevar al evento para ingresar al stack. Ventana de inicio sesion. 
			}
		});
		
		btnIniSesion.setBounds(85, 144, 133, 35);
		btnIniSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIniSesion.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnIniSesion.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(btnIniSesion);
		
		JButton btnRegistro = new JButton("Registarse");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.InicioControl.eventoBtnRegistrarse(); //Event Handler para controlar el click del boton Registrarse. Permite llevar al evento para registrarse en el stack. Ventana de Registrarse.
			}
		});
		btnRegistro.setBounds(85, 190, 133, 35);
		btnRegistro.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistro.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(btnRegistro);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane_1.setBounds(85, 239, 882, 219);
		contentPane.add(scrollPane_1);
		
		tablePreguntasStack = new JTable();
		tablePreguntasStack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {//Event Handler para controlar el click sobre preguntas en la tabla de preguntas. Permite llevar al evento para visualizar la pregunta. 
				//Se optiene la columna de la tabal que se presiona.
		        Point point = e.getPoint(); 
		        int row = tablePreguntasStack.rowAtPoint(point); 
		        int idPregunta = Integer.parseInt(String.valueOf(tablePreguntasStack.getValueAt(row,0))); //De la columna se obtiene el id de la pregunta.
		    	controlador.InicioControl.eventoClickPreguntaTable(idPregunta, false); //Controla evento.

			}
		});
		tablePreguntasStack.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tablePreguntasStack);
		tablePreguntasStack.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePreguntasStack.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tablePreguntasStack.setToolTipText("");
		tablePreguntasStack.setSurrendersFocusOnKeystroke(true);
		tablePreguntasStack.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Preguntas", "Usuario", "Respuestas", "Fecha de publicacion"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePreguntasStack.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePreguntasStack.getColumnModel().getColumn(1).setPreferredWidth(296);
		tablePreguntasStack.getColumnModel().getColumn(2).setPreferredWidth(115);
		tablePreguntasStack.getColumnModel().getColumn(3).setPreferredWidth(72);
		tablePreguntasStack.getColumnModel().getColumn(4).setPreferredWidth(115);
	}
}
