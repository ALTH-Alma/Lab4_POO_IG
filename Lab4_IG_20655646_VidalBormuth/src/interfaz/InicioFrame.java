package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class InicioFrame extends JFrame {

	private JPanel contentPane;
	private static AccederFrame acceder = new AccederFrame();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioFrame frame = new InicioFrame();
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
	public InicioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("Bienvenido a StackOverflow!!");
		lblTitulo.setBounds(0, 29, 1178, 73);
		lblTitulo.setToolTipText("");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblTitulo.setBackground(Color.BLACK);
		contentPane.add(lblTitulo);
		
		JButton btnIniSesion = new JButton("Iniciar sesión");
		btnIniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acceder.setVisible(true);
			}
		});
		
		btnIniSesion.setBounds(10, 113, 164, 48);
		btnIniSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIniSesion.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnIniSesion.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(btnIniSesion);
		
		JButton btnRegistro = new JButton("Registarse");
		btnRegistro.setBounds(10, 172, 164, 48);
		btnRegistro.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistro.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(btnRegistro);
	}

}
