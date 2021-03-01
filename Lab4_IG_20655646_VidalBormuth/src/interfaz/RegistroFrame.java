package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNewPass;
	private JTextField textFieldNewUserName;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFrame frame = new RegistroFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public JTextField getTextFieldNewPass() {
		return textFieldNewPass;
	}

	public JTextField getTextFieldNewUserName() {
		return textFieldNewUserName;
	}

	public void setTextFieldNewPass(JTextField textFieldNewPass) {
		this.textFieldNewPass = textFieldNewPass;
	}

	public void setTextFieldNewUserName(JTextField textFieldNewUserName) {
		this.textFieldNewUserName = textFieldNewUserName;
	}


	/**
	 * Create the frame.
	 */
	public RegistroFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTituloR = new JLabel("Registro de usuario:");
		lblTituloR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloR.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTituloR.setBounds(77, 11, 292, 41);
		contentPane.add(lblTituloR);
		
		
		JLabel lblNomNU = new JLabel("Nombre de usuario");
		lblNomNU.setBounds(142, 58, 111, 24);
		lblNomNU.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNomNU);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setBounds(142, 107, 89, 24);
		lblPass.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblPass);
		
		textFieldNewPass = new JTextField();
		textFieldNewPass.setBounds(142, 130, 166, 20);
		contentPane.add(textFieldNewPass);
		textFieldNewPass.setColumns(10);
		
		textFieldNewUserName = new JTextField();
		textFieldNewUserName.setBounds(142, 82, 166, 20);
		contentPane.add(textFieldNewUserName);
		textFieldNewUserName.setColumns(10);
		
		JButton btnRegister = new JButton("Registrarse");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.RegisterControl.eventoBtnRegister();
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(143, 170, 166, 23);
		contentPane.add(btnRegister);
		
		JButton btnVolver1 = new JButton("Volver");
		btnVolver1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.RegisterControl.eventoBtnVolver();
			}
		});
		btnVolver1.setBounds(142, 203, 166, 23);
		contentPane.add(btnVolver1);
	}
}
