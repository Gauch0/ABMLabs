import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;

import collections.Documento_Usuarios;
import laboratorio.ControllerUsuario;
import tablesModel.TableModelUsuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarUsuarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_Nombre;
	private JTextField textField_Dni;
	private JTextField textField_FechaNac;
	private JTextField textField_Email;
	private JTextField textField_Domicilio;
	private JButton	btn_Aceptar;
	private JButton btn_Cancelar;
	private JTable table;
	Documento_Usuarios doc_Usuarios;
	private TableModelUsuario model;
	private int row;
	private ControllerUsuario controllerUsuario;
	private JTextField textField_Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuarios frame = new ModificarUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ModificarUsuarios() {
		inicializarVentana();
		inicializarEventos();
	}
	
	public void inicializarEventos() {

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>1) {
					row = table.getSelectedRow();
					textField_Dni.setText(Integer.toString(controllerUsuario.getUsuario(row).getDni()));
					textField_Domicilio.setText(controllerUsuario.getUsuario(row).getDomicilio());
					textField_Email.setText(controllerUsuario.getUsuario(row).getEmail());
					textField_FechaNac.setText(controllerUsuario.getUsuario(row).getFechaNac());
					textField_Nombre.setText(controllerUsuario.getUsuario(row).getNombre());
					
				}
			}
		});
		
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerUsuario.modificarUsuario(textField_Nombre.getText()
						,textField_Id.getText()
						,textField_Domicilio.getText()
						,textField_Email.getText()
						,textField_FechaNac.getText()
						,Integer.parseInt(textField_Dni.getText())
						,row
						);
				
				dispose();
				ModificarUsuarios nuevaVentana = new ModificarUsuarios();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarUsuarios.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblModificarUsuario = new JLabel("Modificar Usuario");
		
		JLabel lblNombreUsuario = new JLabel("Nombre usuario :");
		lblNombreUsuario.setForeground(new Color(128, 128, 128));

		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(128, 128, 128));
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(128, 128, 128));
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setForeground(new Color(128, 128, 128));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(128, 128, 128));
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setForeground(new Color(128, 128, 128));
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		
		textField_Dni = new JTextField();
		textField_Dni.setColumns(10);
		
		textField_FechaNac = new JTextField();
		textField_FechaNac.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		
		textField_Domicilio = new JTextField();
		textField_Domicilio.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");

		btn_Aceptar.setForeground(new Color(255, 255, 255));
		btn_Aceptar.setBackground(new Color(128, 128, 128));
		
		btn_Cancelar = new JButton("Cancelar");

		btn_Cancelar.setForeground(new Color(255, 255, 255));
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblId = new JLabel("ID:");
		
		textField_Id = new JTextField();
		textField_Id.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Aceptar, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_Nombre))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_Dni)))
									.addGap(49)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDomicilio, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblModificarUsuario)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNombreUsuario)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_FechaNac, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
									.addGap(25)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblId)
									.addGap(18)
									.addComponent(textField_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_Domicilio, 288, 288, 288)
										.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
									.addGap(49)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModificarUsuario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreUsuario)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(textField_Dni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Domicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDomicilio))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeNacimiento)
						.addComponent(textField_FechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId)
						.addComponent(textField_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Cancelar)
						.addComponent(btn_Aceptar))
					.addContainerGap())
		);

		doc_Usuarios = new Documento_Usuarios();
		controllerUsuario = new ControllerUsuario();
		model = new TableModelUsuario(doc_Usuarios);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
