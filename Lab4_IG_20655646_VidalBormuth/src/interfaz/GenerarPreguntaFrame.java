package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GenerarPreguntaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTPregunta;
	private JComboBox comboBoxEtiquetas;
	private JTextArea textAreaContenidoR;

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldTPregunta() {
		return textFieldTPregunta;
	}

	public JComboBox getComboBoxEtiquetas() {
		return comboBoxEtiquetas;
	}

	public JTextArea getTextAreaContenidoR() {
		return textAreaContenidoR;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarPreguntaFrame frame = new GenerarPreguntaFrame();
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
	public GenerarPreguntaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crea una nueva pregunta");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 32, 267, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo de la pregunta:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 93, 147, 32);
		contentPane.add(lblNewLabel_1);
		
		textFieldTPregunta = new JTextField();
		textFieldTPregunta.setBounds(175, 99, 477, 25);
		contentPane.add(textFieldTPregunta);
		textFieldTPregunta.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("Contenido pregunta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 136, 147, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Etiquetas:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(30, 347, 72, 25);
		contentPane.add(lblNewLabel_3);
		
		comboBoxEtiquetas = new JComboBox();
		comboBoxEtiquetas.setModel(new DefaultComboBoxModel(new String[] {"Alma", "Sami", "Ingrid"}));
		comboBoxEtiquetas.setBounds(30, 379, 179, 25);
		contentPane.add(comboBoxEtiquetas);
		
		JButton btnAddEtiqueta = new JButton("Agregar etiqueta");
		btnAddEtiqueta.setBounds(219, 379, 203, 25);
		contentPane.add(btnAddEtiqueta);
		
		JButton btnCrearEtiqueta = new JButton("Crear nueva etiqueta");
		btnCrearEtiqueta.setBounds(432, 379, 220, 25);
		contentPane.add(btnCrearEtiqueta);
		
		JButton btnEnviarPregunta = new JButton("Enviar pregunta");
		btnEnviarPregunta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.GenerarPreguntaControl.eventoBtnEnviarPregunta();
			}
		});
		btnEnviarPregunta.setBounds(30, 467, 191, 50);
		contentPane.add(btnEnviarPregunta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.GenerarPreguntaControl.eventoBtnCancelar();
			}
		});
		btnCancelar.setBounds(461, 467, 191, 50);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 136, 477, 166);
		contentPane.add(scrollPane);
		
		textAreaContenidoR = new JTextArea();
		scrollPane.setViewportView(textAreaContenidoR);
		textAreaContenidoR.setBackground(Color.WHITE);
		textAreaContenidoR.setWrapStyleWord(true);
		textAreaContenidoR.setLineWrap(true);
		textAreaContenidoR.setColumns(30);
	}
}
