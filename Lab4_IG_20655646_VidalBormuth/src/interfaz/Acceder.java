package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import java.awt.Color;

public class Acceder {

	private JFrame frame;
	private JTextField txtInUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceder window = new Acceder();
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
	public Acceder() {
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
		
		JLabel lblNomUser = new JLabel("Usuario");
		lblNomUser.setBounds(142, 58, 60, 24);
		lblNomUser.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblNomUser);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setBounds(142, 107, 89, 24);
		lblPass.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblPass);
		
		txtInUserName = new JTextField();
		txtInUserName.setForeground(Color.BLACK);
		txtInUserName.setText("");
		txtInUserName.setBounds(142, 81, 164, 20);
		frame.getContentPane().add(txtInUserName);
		txtInUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setDropMode(DropMode.INSERT);
		passwordField.setBounds(142, 134, 165, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngresar.setBounds(143, 170, 166, 23);
		frame.getContentPane().add(btnIngresar);
		
		JLabel lbltituloIS = new JLabel("Acceso de usuario:");
		lbltituloIS.setHorizontalAlignment(SwingConstants.CENTER);
		lbltituloIS.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltituloIS.setBounds(73, 11, 292, 41);
		frame.getContentPane().add(lbltituloIS);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setBounds(143, 204, 164, 23);
		frame.getContentPane().add(btnVolver);
	}
}
