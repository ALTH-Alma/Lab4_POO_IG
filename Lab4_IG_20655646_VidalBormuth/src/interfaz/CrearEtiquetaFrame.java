package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que representa la vista de la ventana que permite crear una nueva etiqueta en stack. 
 * @author Alma
 *
 */
public class CrearEtiquetaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNEtiqueta;
	private JTextArea textAreaDEtiqueta;

	/**
	 * Metodo de obtención para obtener el nombre de la etiqueta ingresado en JTextField.
	 * @return el nombre de la etiqueta.
	 */
	public JTextField getTextFieldNEtiqueta() {
		return textFieldNEtiqueta;
	}

	/**
	 * Metodo de obtención para obtener la descripcion de la etiqueta ingresado en JTextArea.
	 * @return descripcion de la etiqueta.
	 */
	public JTextArea getTextAreaDEtiqueta() {
		return textAreaDEtiqueta;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearEtiquetaFrame frame = new CrearEtiquetaFrame();
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
	public CrearEtiquetaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear nueva etiqueta");
		lblNewLabel.setBounds(32, 11, 218, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(59, 52, 50, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		textFieldNEtiqueta = new JTextField();
		textFieldNEtiqueta.setBounds(119, 50, 260, 20);
		contentPane.add(textFieldNEtiqueta);
		textFieldNEtiqueta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripción:");
		lblNewLabel_2.setBounds(39, 77, 70, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JButton btnCrearEtiqueta = new JButton("Crear etiqueta");
		btnCrearEtiqueta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.CrearEtiquetaControl.eventoBtnCrearEtiqueta(); //Event Handler para controlar el click del boton crear etiqueta. Permite llevar al evento para crear una nueva etiqueta en el stack. 
			}
		});
		btnCrearEtiqueta.setBounds(119, 239, 131, 23);
		contentPane.add(btnCrearEtiqueta);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.CrearEtiquetaControl.eventoBtnCancel(); //Event Handler para controlar el click del boton cancelar. Permite llevar al evento para salir de la ventana para crear etiqueta. 
			}
		});
		btnCancel.setBounds(263, 239, 116, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 81, 260, 131);
		contentPane.add(scrollPane);
		
		textAreaDEtiqueta = new JTextArea();
		scrollPane.setViewportView(textAreaDEtiqueta);
	}

}
