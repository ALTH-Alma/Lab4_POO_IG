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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class SesionIniciadaFrame extends JFrame {

	private JPanel contentPane;
	private JTable tablePreguntasStack;
	private JLabel lblTitulo;

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SesionIniciadaFrame frame = new SesionIniciadaFrame();
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
	public SesionIniciadaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Bienvenido a StackOverflow!!");
		lblTitulo.setBounds(85, 32, 1178, 73);
		lblTitulo.setToolTipText("");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblTitulo.setBackground(Color.BLACK);
		contentPane.add(lblTitulo);
		
		JButton btnIniSesion = new JButton("Cerrar sesión");
		btnIniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.SesionIniciadaControl.eventoBtnCerrarSesion();
			}
		});
		
		btnIniSesion.setBounds(85, 144, 133, 35);
		btnIniSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIniSesion.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnIniSesion.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(btnIniSesion);
		
		JButton btnRegistro = new JButton("Hacer una pregunta");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.SesionIniciadaControl.eventoBtnHacerPregunta();
			}
		});
		btnRegistro.setBounds(85, 190, 238, 35);
		btnRegistro.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistro.setBackground(SystemColor.desktop);
		contentPane.add(btnRegistro);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane_1.setBounds(85, 236, 866, 205);
		contentPane.add(scrollPane_1);
		
		tablePreguntasStack = new JTable();
		tablePreguntasStack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Pendiente
			}
		});
		
		tablePreguntasStack.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tablePreguntasStack);
		tablePreguntasStack.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePreguntasStack.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tablePreguntasStack.setToolTipText("");
		tablePreguntasStack.setSurrendersFocusOnKeystroke(true);
		tablePreguntasStack.setModel(new DefaultTableModel(
			new Object[][] {
				{"Hola", null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Preguntas", "Usuario", "Respuestas", "Fecha de publicaci\u00F3n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePreguntasStack.getColumnModel().getColumn(0).setPreferredWidth(296);
		tablePreguntasStack.getColumnModel().getColumn(1).setPreferredWidth(115);
		tablePreguntasStack.getColumnModel().getColumn(2).setPreferredWidth(72);
		tablePreguntasStack.getColumnModel().getColumn(3).setPreferredWidth(115);
	}

}
