package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Clase que representa la vista de la ventana que permite visualizar una respuesta. 
 * @author Alma
 *
 */
public class RespuestaFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblEstado;
	private JLabel lblVotosFavor;
	private JLabel lblVotosContra;
	private JLabel lblFecha;
	private JLabel lblAutor;
	private JLabel lblRespuesta;
	private JScrollPane scrollPane;
	private JButton btnAceptar;

	/**
	 * Metodo de obtención para obtener el boton aceptar de la ventana.
	 * @return boton aceptar.
	 */
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra la respuesta.
	 * @return respuesta.
	 */
	public JLabel getLblRespuesta() {
		return lblRespuesta;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra el estado de la respuesta.
	 * @return estado respuesta.
	 */
	public JLabel getLblEstado() {
		return lblEstado;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra los votos a favor de la respuesta.
	 * @return votos a favor de la respuesta.
	 */
	public JLabel getLblVotosFavor() {
		return lblVotosFavor;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra los votos en contra de la respuesta.
	 * @return votos en contra de la respuesta.
	 */
	public JLabel getLblVotosContra() {
		return lblVotosContra;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra la fecha de publicación de la respuesta.
	 * @return fecha de publicacion de la respuesta.
	 */
	public JLabel getLblFecha() {
		return lblFecha;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que tendra el nombre del autor de la respuesta.
	 * @return autor respuesta.
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
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptar = new JButton("Aceptar Respuesta");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.RespuestaControl.eventoBtnAceptar();  //Event Handler para controlar el click del boton aceptar. Permite llevar al evento para aceptar una respuesta de una pregunta.
			}
		});
		btnAceptar.setBackground(SystemColor.desktop);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setBounds(557, 215, 183, 35);
		contentPane.add(btnAceptar);
		
		JButton btnVolverR = new JButton("Cerrar");
		btnVolverR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.RespuestaControl.eventoBtnVolverR(); //Event Handler para controlar el click del boton cerrar. Permite llevar al evento para salir de la respuesta. 
			}
		});
		btnVolverR.setBounds(581, 267, 159, 35);
		contentPane.add(btnVolverR);
		
		JLabel lblNewLabel_2 = new JLabel("Votos a Favor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(39, 215, 118, 19);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("Votos en contra:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(39, 231, 118, 19);
		contentPane.add(lblNewLabel_1);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(39, 11, 172, 19);
		contentPane.add(lblEstado);
		
		lblVotosFavor = new JLabel("NVF");
		lblVotosFavor.setBounds(128, 217, 46, 14);
		contentPane.add(lblVotosFavor);
		
		lblVotosContra = new JLabel("NVC");
		lblVotosContra.setBounds(138, 223, 97, 35);
		contentPane.add(lblVotosContra);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(39, 150, 148, 31);
		contentPane.add(lblFecha);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(39, 179, 263, 23);
		contentPane.add(lblAutor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 41, 701, 98);
		contentPane.add(scrollPane);
		
		lblRespuesta = new JLabel("New label");
		scrollPane.setViewportView(lblRespuesta);
		lblRespuesta.setBackground(SystemColor.activeCaption);
		lblRespuesta.setVerticalAlignment(SwingConstants.TOP);
	}
}
