package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que representa la vista de la ventana que permite visualizar y entregar una recompensa. 
 * @author Alma
 *
 */
public class RecompensaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPtsRecompensaOfrecida;
	private JLabel lblRecompensa;

	/**
	 * Metodo de obtención para obtener el monto de la recompensa que es ingresada en el JTextField.
	 * @return monto recompensa.
	 */
	public JTextField getTextFieldPtsRecompensaOfrecida() {
		return textFieldPtsRecompensaOfrecida;
	}

	/**
	 * Metodo de obtención para obtener el JLabel que mostrara la recompensa de una pregunta Monto.
	 * @return Jlabel para mostrar recompensa.
	 */
	public JLabel getLblRecompensa() {
		return lblRecompensa;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecompensaFrame frame = new RecompensaFrame();
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
	public RecompensaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRecompensa = new JLabel("No existe recompensa en esta pregunta");
		lblRecompensa.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecompensa.setToolTipText("");
		lblRecompensa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRecompensa.setBackground(SystemColor.activeCaption);
		lblRecompensa.setBounds(25, 11, 360, 31);
		contentPane.add(lblRecompensa);
		
		JLabel lblNewLabel_1 = new JLabel("Si desea agregar una recompensa introduzca los puntos ofrecidos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(25, 53, 399, 20);
		contentPane.add(lblNewLabel_1);
		
		textFieldPtsRecompensaOfrecida = new JTextField();
		textFieldPtsRecompensaOfrecida.setBounds(25, 84, 112, 20);
		contentPane.add(textFieldPtsRecompensaOfrecida);
		textFieldPtsRecompensaOfrecida.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("pts.");
		lblNewLabel_2.setBounds(147, 87, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnRecompensa = new JButton("Ofrecer recompensa");
		btnRecompensa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.RecompensaControl.eventoBtnOfrecerRecompensa();  //Event Handler para controlar el click del boton ofrecer recompensa. Permite llevar al evento para ofrecer una recompensa por una pregunta. 
			}
		});
		btnRecompensa.setBounds(25, 140, 190, 23);
		contentPane.add(btnRecompensa);
		
		JButton btnVolverRecompensa = new JButton("Cerrar");
		btnVolverRecompensa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.RecompensaControl.eventoBtnVolverR();  //Event Handler para controlar el click del boton volver (cerrar). Permite llevar al evento para salir del evento para ofrecer una recompensa. 
			}
		});
		btnVolverRecompensa.setBounds(282, 140, 103, 23);
		contentPane.add(btnVolverRecompensa);
	}
}
