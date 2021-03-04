package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PerfilFrame extends JFrame {

	private JPanel contentPane;
	private JTable tablePreguntasUser;
	private JLabel lblUserName;
	private JLabel lblReputacionUser;

	public JTable getTablePreguntasUser() {
		return tablePreguntasUser;
	}

	public JLabel getLblUserName() {
		return lblUserName;
	}

	public JLabel getLblReputacionUser() {
		return lblReputacionUser;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilFrame frame = new PerfilFrame();
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
	public PerfilFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUserName = new JLabel("Nombre usuario");
		lblUserName.setBackground(SystemColor.activeCaption);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(38, 32, 674, 36);
		contentPane.add(lblUserName);
		
		lblReputacionUser = new JLabel("Reputacion---");
		lblReputacionUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReputacionUser.setBounds(180, 82, 118, 22);
		contentPane.add(lblReputacionUser);
		
		JLabel lblNewLabel_2 = new JLabel("Puntos de reputación:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(38, 83, 144, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mis preguntas:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(38, 112, 144, 22);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane_1.setBounds(38, 145, 674, 219);
		contentPane.add(scrollPane_1);
		
		tablePreguntasUser = new JTable();
		tablePreguntasUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        Point point = e.getPoint(); 
		        int row = tablePreguntasUser.rowAtPoint(point); 
		        int idPregunta = Integer.parseInt(String.valueOf(tablePreguntasUser.getValueAt(row,0))); 
		    	controlador.PerfilControl.eventoClickPreguntaTableUser(idPregunta, true);
			}
		});

		tablePreguntasUser.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tablePreguntasUser);
		tablePreguntasUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePreguntasUser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		tablePreguntasUser.setToolTipText("");
		tablePreguntasUser.setSurrendersFocusOnKeystroke(true);
		tablePreguntasUser.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Preguntas", "Usuario", "Respuestas", "Fecha de publicaci\u00F3n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.PerfilControl.eventoBtnVolverP();
			}
		});
		btnNewButton.setBounds(601, 389, 111, 30);
		contentPane.add(btnNewButton);
	
		tablePreguntasUser.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablePreguntasUser.getColumnModel().getColumn(1).setPreferredWidth(296);
		tablePreguntasUser.getColumnModel().getColumn(2).setPreferredWidth(115);
		tablePreguntasUser.getColumnModel().getColumn(3).setPreferredWidth(72);
		tablePreguntasUser.getColumnModel().getColumn(4).setPreferredWidth(115);
	}
}