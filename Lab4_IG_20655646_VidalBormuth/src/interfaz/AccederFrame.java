package interfaz;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccederFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordUser;
	private JTextField textNameUser;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccederFrame frame = new AccederFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JPasswordField getPasswordUser() {
		return passwordUser;
	}

	public JTextField getTextNameUser() {
		return textNameUser;
	}

	public void setPasswordUser(JPasswordField passwordUser) {
		this.passwordUser = passwordUser;
	}

	public void setTextNameUser(JTextField textNameUser) {
		this.textNameUser = textNameUser;
	}

	/**
	 * Create the frame.
	 */
	public AccederFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltituloIS = new JLabel("Acceso de usuario:");
		lbltituloIS.setHorizontalAlignment(SwingConstants.CENTER);
		lbltituloIS.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltituloIS.setBounds(73, 11, 292, 41);
		contentPane.add(lbltituloIS);
		
		
		JLabel lblNomUser = new JLabel("Usuario");
		lblNomUser.setBounds(142, 58, 60, 24);
		lblNomUser.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNomUser);

		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setBounds(142, 107, 89, 24);
		lblPass.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblPass);

		passwordUser = new JPasswordField();
		passwordUser.setToolTipText("");
		passwordUser.setDropMode(DropMode.INSERT);
		passwordUser.setBounds(142, 134, 165, 20);
		contentPane.add(passwordUser);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.AccederControl.eventoBtnIngresar();
			}
		});
		btnIngresar.setBounds(143, 170, 166, 23);
		contentPane.add(btnIngresar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.AccederControl.eventoBtnVolver();
			}
		});
		btnVolver.setBounds(143, 204, 164, 23);
		contentPane.add(btnVolver);
		
		textNameUser = new JTextField();
		textNameUser.setBounds(142, 81, 165, 20);
		contentPane.add(textNameUser);
		textNameUser.setColumns(10);
		
		


	}
}


