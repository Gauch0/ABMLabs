import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import laboratorio.ControllerUsuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Id;
	private JTextField textField_Email;
	private JTextField textField_Nombre;
	private JTextField textField_Domicilio;
	private JTextField textField_Dni;
	private JTextField textField_FechaNac;
	private JButton btn_Aceptar;
	private JButton btn_Cancelar;
	private ControllerUsuario controllerUsuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuarios frame = new AltaUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AltaUsuarios() {
		inicializarVista();
		inicializarEventos();
	}
	
	/**
	 * Create the frame.
	 */
	
	public void inicializarEventos(){
		
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controllerUsuario = new ControllerUsuario();
				controllerUsuario.crearUsuario(textField_Id.getText()
						,Integer.parseInt(textField_Dni.getText())
						, textField_Nombre.getText()
						, textField_Email.getText()
						, textField_Domicilio.getText()
						, textField_FechaNac.getText());
				
				dispose();
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
	
	public void inicializarVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaUsuarios.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Alta usuario");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Id de usuario:");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_2 = new JLabel("Nombre completo:");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		
		textField_Id = new JTextField();
		textField_Id.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("e-mail:");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Domicilio:");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		
		textField_Domicilio = new JTextField();
		textField_Domicilio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DNI:");
		lblNewLabel_5.setForeground(new Color(128, 128, 128));
		
		textField_Dni = new JTextField();
		textField_Dni.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_6.setForeground(new Color(128, 128, 128));
		
		textField_FechaNac = new JTextField();
		textField_FechaNac.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");

		btn_Aceptar.setBackground(new Color(128, 128, 128));
		btn_Aceptar.setForeground(new Color(255, 255, 255));
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(btn_Aceptar)
							.addGap(18)
							.addComponent(btn_Cancelar))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addGap(18)
									.addComponent(textField_Dni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_Domicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_FechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(331, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Domicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_Dni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_FechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Cancelar)
						.addComponent(btn_Aceptar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
