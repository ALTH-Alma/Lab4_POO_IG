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
	private JTextField txtIngresarNombreDe;
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
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(142, 58, 60, 24);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(142, 107, 89, 24);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtIngresarNombreDe = new JTextField();
		txtIngresarNombreDe.setForeground(Color.BLACK);
		txtIngresarNombreDe.setText("");
		txtIngresarNombreDe.setBounds(142, 81, 164, 20);
		frame.getContentPane().add(txtIngresarNombreDe);
		txtIngresarNombreDe.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setDropMode(DropMode.INSERT);
		passwordField.setBounds(142, 134, 165, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(143, 170, 166, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Acceso de usuario:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(73, 11, 292, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(143, 204, 164, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
