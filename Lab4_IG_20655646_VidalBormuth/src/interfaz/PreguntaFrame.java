package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PreguntaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldRespuesta;
	private JLabel lblPregunta;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JLabel lblAutor;

	
	public JTextField getTextFieldRespuesta() {
		return textFieldRespuesta;
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
		setBounds(100, 100, 816, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPregunta = new JLabel("Pregunta");
		lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPregunta.setBounds(39, 34, 263, 31);
		contentPane.add(lblPregunta);
		
		lblDescripcion = new JLabel("Descripcion....");
		lblDescripcion.setBounds(39, 118, 142, 31);
		contentPane.add(lblDescripcion);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(39, 76, 148, 31);
		contentPane.add(lblFecha);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(39, 101, 263, 23);
		contentPane.add(lblAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 200, 674, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Respuestas", "Usuario", "Fecha de publicación"
			}
		));
		
		JLabel lblNewLabel_4 = new JLabel("Tu respuesta");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(39, 351, 130, 23);
		contentPane.add(lblNewLabel_4);
		
		textFieldRespuesta = new JTextField();
		textFieldRespuesta.setBounds(39, 373, 674, 53);
		contentPane.add(textFieldRespuesta);
		textFieldRespuesta.setColumns(20);
		
		JButton btnVolver2 = new JButton("Volver");
		btnVolver2.setBounds(600, 38, 113, 31);
		contentPane.add(btnVolver2);
		
		JButton btnEnviarRespuesta = new JButton("Enviar respuesta");
		btnEnviarRespuesta.setBounds(39, 437, 113, 36);
		contentPane.add(btnEnviarRespuesta);
	}
}
