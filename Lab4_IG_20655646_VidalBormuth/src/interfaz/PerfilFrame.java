package interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Clase que representa la vista de la ventana que permite vizualizar el perfil del usuario activo en el stack. 
 * @author Alma
 *
 */
public class PerfilFrame extends JFrame {

	private JPanel contentPane;
	private JTable tablePreguntasUser;
	private JLabel lblUserName;
	private JLabel lblReputacionUser;

	/**
	 * Metodo de obtención para obtener la tabla que mostrara el listado de preguntas pertenecientes al usuario activo.
	 * @return tabla para preguntas usuario.
	 */
	public JTable getTablePreguntasUser() {
		return tablePreguntasUser;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que mostrara el nombre del usuario activo.
	 * @return JLabel de nombre.
	 */
	public JLabel getLblUserName() {
		return lblUserName;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que mostrara la reputación del usuario activo.
	 * @return JLabel de reputación.
	 */
	public JLabel getLblReputacionUser() {
		return lblReputacionUser;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilFrame frame = new PerfilFrame();
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
	public PerfilFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUserName = new JLabel("Nombre usuario");
		lblUserName.setBackground(SystemColor.activeCaption);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(38, 32, 674, 36);
		contentPane.add(lblUserName);
		
		lblReputacionUser = new JLabel("Reputacion---");
		lblReputacionUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReputacionUser.setBounds(180, 82, 118, 22);
		contentPane.add(lblReputacionUser);
		
		JLabel lblNewLabel_2 = new JLabel("Puntos de reputacion:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(38, 83, 144, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mis preguntas:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(38, 112, 144, 22);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane_1.setBounds(38, 145, 674, 219);
		contentPane.add(scrollPane_1);
		
		tablePreguntasUser = new JTable();
		tablePreguntasUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Event Handler para controlar el click sobre preguntas en la tabla de preguntas. Permite llevar al evento para visualizar la pregunta. 
				//Se optiene la columna de la tabal que se presiona.
		        Point point = e.getPoint(); 
		        int row = tablePreguntasUser.rowAtPoint(point); 
		        int idPregunta = Integer.parseInt(String.valueOf(tablePreguntasUser.getValueAt(row,0))); //De la columna se obtiene el id de la pregunta.
		    	controlador.PerfilControl.eventoClickPreguntaTableUser(idPregunta, true); //Controla evento.
			}
		});

		tablePreguntasUser.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tablePreguntasUser);
		tablePreguntasUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePreguntasUser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tablePreguntasUser.setToolTipText("");
		tablePreguntasUser.setSurrendersFocusOnKeystroke(true);
		tablePreguntasUser.setModel(new DefaultTableModel(
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
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.PerfilControl.eventoBtnVolverP();  //Event Handler para controlar el click del boton Volver. Permite llevar al evento para salir del perfil del usuario activo. 
			}
		});
		btnNewButton.setBounds(601, 389, 111, 30);
		contentPane.add(btnNewButton);
	
		tablePreguntasUser.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePreguntasUser.getColumnModel().getColumn(1).setPreferredWidth(296);
		tablePreguntasUser.getColumnModel().getColumn(2).setPreferredWidth(115);
		tablePreguntasUser.getColumnModel().getColumn(3).setPreferredWidth(72);
		tablePreguntasUser.getColumnModel().getColumn(4).setPreferredWidth(115);
	}
}
