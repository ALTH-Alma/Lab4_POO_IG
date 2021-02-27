package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Registrarse {

	private JFrame frame;
	private JTextField textFieldNewPass;
	private JTextField textFieldNewUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse window = new Registrarse();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrarse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("StackOverflow");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTituloR = new JLabel("Registro de usuario:");
		lblTituloR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloR.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloR.setBounds(77, 11, 292, 41);
		frame.getContentPane().add(lblTituloR);
		
		
		JLabel lblNomNU = new JLabel("Nombre de usuario");
		lblNomNU.setBounds(142, 58, 111, 24);
		lblNomNU.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblNomNU);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setBounds(142, 107, 89, 24);
		lblPass.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblPass);
		
		textFieldNewPass = new JTextField();
		textFieldNewPass.setBounds(142, 130, 166, 20);
		frame.getContentPane().add(textFieldNewPass);
		textFieldNewPass.setColumns(10);
		
		textFieldNewUserName = new JTextField();
		textFieldNewUserName.setBounds(142, 82, 166, 20);
		frame.getContentPane().add(textFieldNewUserName);
		textFieldNewUserName.setColumns(10);
		
		JButton btnRegister = new JButton("Registrarse");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(143, 170, 166, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnVolver1 = new JButton("Volver");
		btnVolver1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver1.setBounds(143, 204, 164, 23);
		frame.getContentPane().add(btnVolver1);
		

	}

}
