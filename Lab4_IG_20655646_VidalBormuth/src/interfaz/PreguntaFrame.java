package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;


/**
 * Clase que representa la vista de la ventana que permite visualizar una pregunta del stack. 
 * @author Alma
 *
 */
public class PreguntaFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableRespuestas;
	private JLabel lblPregunta;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JLabel lblAutor;
	private JTextArea textAreaRespuesta;
	private JLabel lblEstado;
	private JLabel lblVotosFavor;
	private JLabel lblVotosContra;
	private JComboBox comboBoxEtiquetasPregunta;
	private JButton btnEnviarRespuesta;
	
	
	/**
	 * Metodo de obtención para obtener la tabla que mostrara el listado de respuestas de la pregunta.
	 * @return tabla para respuestas de pregunta.
	 */
	public JTable getTableRespuestas() {
		return tableRespuestas;
	}

	/**
	 * Metodo de obtención para obtener el combobox que almacenara las etiquetas de la pregunta.
	 * @return combobox de etiquetas.
	 */
	public JComboBox getComboBoxEtiquetasPregunta() {
		return comboBoxEtiquetasPregunta;
	}
	
	/**
	 * Metodo de obtención para obtener la respuesta que se ingresara en el JTextArea.
	 * @return respuesta.
	 */
	public JTextArea getTextAreaRespuesta() {
		return textAreaRespuesta;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra el estado de la pregunta.
	 * @return estado pregunta.
	 */
	public JLabel getLblEstado() {
		return lblEstado;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra los votos a favor de la pregunta.
	 * @return votos a favor de la pregunta.
	 */
	public JLabel getLblVotosFavor() {
		return lblVotosFavor;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra los votos en contra de la pregunta.
	 * @return votos en contra de la pregunta.
	 */
	public JLabel getLblVotosContra() {
		return lblVotosContra;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra el titulo de la pregunta.
	 * @return titulo de la pregunta.
	 */
	public JLabel getLblPregunta() {
		return lblPregunta;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra la descripcion de la pregunta.
	 * @return descripcion de la pregunta.
	 */	
	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra la fecha de publicación de la pregunta.
	 * @return fecha de publicacion de la pregunta.
	 */
	public JLabel getLblFecha() {
		return lblFecha;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra el nombre del autor de la pregunta.
	 * @return autor pregunta.
	 */
	public JLabel getLblAutor() {
		return lblAutor;
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreguntaFrame frame = new PreguntaFrame();
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
	public PreguntaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPregunta = new JLabel("Pregunta");
		lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPregunta.setBounds(39, 34, 263, 31);
		contentPane.add(lblPregunta);
		
		lblDescripcion = new JLabel("Descripcion....");
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(39, 125, 674, 53);
		contentPane.add(lblDescripcion);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(39, 76, 148, 31);
		contentPane.add(lblFecha);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(39, 101, 263, 23);
		contentPane.add(lblAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 229, 674, 101);
		contentPane.add(scrollPane);
		
		tableRespuestas = new JTable();
		tableRespuestas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Event Handler para controlar el click sobre preguntas en la tabla de respuestas. Permite llevar al evento para visualizar una respuesta. 
		        Point point = e.getPoint(); //Se optiene la columna de la tabal que se presiona.
		        int row = tableRespuestas.rowAtPoint(point); 
		        int idRespuesta = Integer.parseInt(String.valueOf(tableRespuestas.getValueAt(row,0))); //De la columna se obtiene el id de la respuesta.
		    	controlador.PreguntaControl.eventoClickRespuestaTable(idRespuesta);//Controla evento.
			}
		});
		scrollPane.setViewportView(tableRespuestas);
		tableRespuestas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Respuestas", "Usuario", "Fecha de publicaci\u00F3n"
			}
		));
		tableRespuestas.getColumnModel().getColumn(0).setPreferredWidth(55);
		
		JLabel lblNewLabel_4 = new JLabel("Tu respuesta");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(39, 351, 130, 23);
		contentPane.add(lblNewLabel_4);
		
		JButton btnVolver2 = new JButton("Volver");
		btnVolver2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.PreguntaControl.eventoBtnVolverPregunta(); //Event Handler para controlar el click del boton volver. Permite llevar al evento para salir de la pregunta. 
			}
		});
		btnVolver2.setBounds(583, 509, 130, 33);
		contentPane.add(btnVolver2);
		
		btnEnviarRespuesta = new JButton("Enviar respuesta");
		btnEnviarRespuesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.PreguntaControl.eventoBtnEnviarRespuesta(); //Event Handler para controlar el click del boton enviar respuesta. Permite llevar al evento para agregar una nueva respuesta a una pregunta. 
			}
		});
		btnEnviarRespuesta.setBounds(39, 507, 185, 36);
		contentPane.add(btnEnviarRespuesta);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 379, 674, 62);
		contentPane.add(scrollPane_1);
		
		textAreaRespuesta = new JTextArea();
		scrollPane_1.setViewportView(textAreaRespuesta);
		
		JLabel lblNewLabel = new JLabel("Votos a Favor:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(38, 199, 118, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Votos en contra:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(166, 199, 118, 19);
		contentPane.add(lblNewLabel_1);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(39, 11, 172, 19);
		contentPane.add(lblEstado);
		
		lblVotosFavor = new JLabel("NVF");
		lblVotosFavor.setBounds(123, 201, 46, 14);
		contentPane.add(lblVotosFavor);
		
		lblVotosContra = new JLabel("NVC");
		lblVotosContra.setBounds(262, 201, 46, 14);
		contentPane.add(lblVotosContra);
		
		JButton btnNewButton = new JButton("Recompensa");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.PreguntaControl.eventoBtnRecompensa(); //Event Handler para controlar el click del boton recompensa. Permite llevar al evento para visualizar y ofrecer una recompensa.
			}
		});
		btnNewButton.setBounds(577, 197, 136, 23);
		contentPane.add(btnNewButton);
		
		comboBoxEtiquetasPregunta = new JComboBox();
		comboBoxEtiquetasPregunta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controlador.PreguntaControl.eventoMostrarContenidoEtiquetaPregunta(); //Event Handler para controlar el click sobre la combobox. Permite llevar al evento para la descripcion de la etiqueta seleccionada. 
			}
		});
		comboBoxEtiquetasPregunta.setBounds(392, 196, 148, 22);
		contentPane.add(comboBoxEtiquetasPregunta);
		
		JLabel lblNewLabel_6 = new JLabel("Etiquetas:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(318, 201, 98, 14);
		contentPane.add(lblNewLabel_6);
	}
}
