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
	
	
	
	public JButton getBtnEnviarRespuesta() {
		return btnEnviarRespuesta;
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JTable getTableRespuestas() {
		return tableRespuestas;
	}
	
	public JComboBox getComboBoxEtiquetasPregunta() {
		return comboBoxEtiquetasPregunta;
	}

	public JTextArea getTextAreaRespuesta() {
		return textAreaRespuesta;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public JLabel getLblVotosFavor() {
		return lblVotosFavor;
	}

	public JLabel getLblVotosContra() {
		return lblVotosContra;
	}

	public JLabel getLblPregunta() {
		return lblPregunta;
	}

	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

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
			public void mouseClicked(MouseEvent e) {
		        Point point = e.getPoint(); 
		        int row = tableRespuestas.rowAtPoint(point); 
		        int idRespuesta = Integer.parseInt(String.valueOf(tableRespuestas.getValueAt(row,0))); 
		    	controlador.PreguntaControl.eventoClickRespuestaTable(idRespuesta);
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
				controlador.PreguntaControl.eventoBtnVolverPregunta();
			}
		});
		btnVolver2.setBounds(583, 509, 130, 33);
		contentPane.add(btnVolver2);
		
		btnEnviarRespuesta = new JButton("Enviar respuesta");
		btnEnviarRespuesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.PreguntaControl.eventoBtnEnviarRespuesta();
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
				controlador.PreguntaControl.eventoBtnRecompensa();
			}
		});
		btnNewButton.setBounds(577, 197, 136, 23);
		contentPane.add(btnNewButton);
		
		comboBoxEtiquetasPregunta = new JComboBox();
		comboBoxEtiquetasPregunta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controlador.PreguntaControl.eventoMostrarContenidoEtiquetaPregunta();
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
