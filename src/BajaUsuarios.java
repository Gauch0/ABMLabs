import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

import collections.Documento_Usuarios;
import laboratorio.ControllerUsuario;
import tablesModel.TableModelUsuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private TableModelUsuario model;
	private ControllerUsuario controllerUsuario;
	private JButton btn_Eliminar;
	private JButton btn_Cancelar;
	private Documento_Usuarios doc_Usuarios;
	private int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaUsuarios frame = new BajaUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public BajaUsuarios() {
		inicializarVentana();
		inicializarEventos();
	}
	
	public void inicializarEventos() {
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>0	) {
					row = table.getSelectedRow();
				}
			}
		});
		
		btn_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controllerUsuario.eliminarUsuario(row);
				
				dispose();
				BajaUsuarios nuevaVentana = new BajaUsuarios();
				nuevaVentana.setVisible(true);
			}
		});	
		
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Laboratorio nuevaVentanaLaboratorio	= new Laboratorio();
				nuevaVentanaLaboratorio.setVisible(true);
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public void inicializarVentana() {
		setTitle("Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BajaUsuarios.class.getResource("/resources/Logo lab IOO.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar usuario:");
		lblEliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setForeground(new Color(128, 128, 128));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("");
		
		btn_Eliminar = new JButton("Eliminar");

		btn_Eliminar.setBackground(new Color(128, 128, 128));
		btn_Eliminar.setForeground(new Color(255, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEliminarUsuario)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNombreDeUsuario)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE))
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btn_Eliminar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(21)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEliminarUsuario)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(37))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_Eliminar)
								.addComponent(btn_Cancelar))
							.addGap(33))))
		);
		doc_Usuarios = new Documento_Usuarios();
		model = new TableModelUsuario(doc_Usuarios);
		table = new JTable(model);

		controllerUsuario = new ControllerUsuario();
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
