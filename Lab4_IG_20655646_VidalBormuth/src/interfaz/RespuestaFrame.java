package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

public class RespuestaFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblEstado;
	private JLabel lblVotosFavor;
	private JLabel lblVotosContra;
	private JLabel lblFecha;
	private JLabel lblAutor;
	private JLabel lblRespuesta;



	public JLabel getLblRespuesta() {
		return lblRespuesta;
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
					RespuestaFrame frame = new RespuestaFrame();
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
	public RespuestaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Aceptar Respuesta");
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(39, 267, 183, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(581, 267, 159, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Votos a Favor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(39, 215, 118, 19);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("Votos en contra:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(184, 215, 118, 19);
		contentPane.add(lblNewLabel_1);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(39, 11, 172, 19);
		contentPane.add(lblEstado);
		
		lblVotosFavor = new JLabel("NVF");
		lblVotosFavor.setBounds(128, 217, 46, 14);
		contentPane.add(lblVotosFavor);
		
		lblVotosContra = new JLabel("NVC");
		lblVotosContra.setBounds(286, 217, 46, 14);
		contentPane.add(lblVotosContra);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(39, 150, 148, 31);
		contentPane.add(lblFecha);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(39, 179, 263, 23);
		contentPane.add(lblAutor);
		
		lblRespuesta = new JLabel("New label");
		lblRespuesta.setBackground(SystemColor.activeCaption);
		lblRespuesta.setVerticalAlignment(SwingConstants.TOP);
		lblRespuesta.setBounds(39, 41, 701, 98);
		contentPane.add(lblRespuesta);
	}
}
