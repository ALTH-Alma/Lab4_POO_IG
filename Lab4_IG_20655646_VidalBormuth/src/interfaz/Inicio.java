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
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Inicio {

	private JFrame frame;
	private JTable table;

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
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Bienvenido a StackOverflow!!");
		lblTitulo.setBounds(0, 29, 1178, 73);
		lblTitulo.setToolTipText("");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblTitulo.setBackground(Color.BLACK);
		frame.getContentPane().add(lblTitulo);
		
		JButton btnIniSesion = new JButton("Iniciar sesión");
		btnIniSesion.setBounds(10, 113, 164, 48);
		btnIniSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIniSesion.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnIniSesion.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frame.getContentPane().add(btnIniSesion);
		
		JButton btnRegistro = new JButton("Registarse");
		btnRegistro.setBounds(10, 183, 164, 48);
		btnRegistro.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistro.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frame.getContentPane().add(btnRegistro);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(285, 113, 520, 56);
		frame.getContentPane().add(table);
		
		JList list_1 = new JList();
		list_1.setBounds(524, 194, -124, -41);
		frame.getContentPane().add(list_1);
		
		
	}
}
