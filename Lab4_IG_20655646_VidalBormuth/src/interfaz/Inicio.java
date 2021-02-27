package interfaz;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("StackOverflow");
		frame.getContentPane().setForeground(UIManager.getColor("InternalFrame.borderColor"));
		frame.setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.setFont(new Font("Dialog", Font.PLAIN, 36));
		frame.setBounds(100, 100, 1194, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a StackOverflow!!");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 62));
		lblNewLabel.setBackground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnNewButton.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Registarse");
		btnNewButton_1.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frame.getContentPane().add(btnNewButton_1, BorderLayout.CENTER);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.WHITE);
		layeredPane.setBorder(new CompoundBorder());
		layeredPane.setBackground(Color.WHITE);
		frame.getContentPane().add(layeredPane, BorderLayout.SOUTH);
		layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.X_AXIS));
		
		
	}

}
