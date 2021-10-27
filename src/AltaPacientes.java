import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import dto.PacienteDTO;
import dto.PacienteDTO;
import accion.AccionResultado;
import collections.PacienteCollection;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaPacientes{

	private JFrame frmAltaPaciente;
	private JTextField txtDni;
	private JTextField txtNombreCompleto;
	private JTextField txtDomicilio;
	private JTextField txtMail;
	private JTextField txtEdad;
	private JComboBox comboboxsexo;
	private PacienteDTO paciente = new PacienteDTO();
	private int idPaciente = 0;
	private PacienteCollection m = new PacienteCollection();
	private AccionResultado accionResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPacientes window = new AltaPacientes();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		  frmAltaPaciente.setVisible(true);
		
	}

	/**
	 * Create the application.
	 * @param frame 
	 */
	public AltaPacientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaPaciente = new JFrame();
		frmAltaPaciente.setIconImage(Toolkit.getDefaultToolkit().getImage(AltaPacientes.class.getResource("/resources/Logo lab IOO.jpg")));
		frmAltaPaciente.getContentPane().setBackground(new Color(255, 255, 255));
		frmAltaPaciente.setTitle("Paciente");
		frmAltaPaciente.setBounds(100, 100, 450, 258);
		frmAltaPaciente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre completo:");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_2 = new JLabel("Domicilio:");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mail:");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo:");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		
		JComboBox comboboxsexo = new JComboBox();
		comboboxsexo.setModel(new DefaultComboBoxModel(new String[] {"", "Femenino", "Masculino"}));
		
		JLabel lblNewLabel_5 = new JLabel("Edad:");
		lblNewLabel_5.setForeground(new Color(128, 128, 128));
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Paciente:");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		//guardo nuevo paciente
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarPaciente();
				accionResultado = AccionResultado.OK;
				m.grabar();
				frmAltaPaciente.dispose();

				
			
				
			}
			public PacienteDTO getPaciente() {
				return paciente;
			}
			private void agregarPaciente() {
				// TODO Auto-generated method stub
				paciente.setID(idPaciente++);
				paciente.setNombre(txtNombreCompleto.getText());
				paciente.setDNI(txtDni.getText());
				paciente.setDomicilio(txtDomicilio.getText());
				paciente.setEdad(txtEdad.getText());
				paciente.setMail(txtMail.getText());
				paciente.setSexo((String)comboboxsexo.getSelectedItem());
				
				//guardo el paciente en el archivo de texto
				



			}


		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionResultado = AccionResultado.CANCELL;
				frmAltaPaciente.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		GroupLayout groupLayout = new GroupLayout(frmAltaPaciente.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNombreCompleto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboboxsexo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_5))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_6)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_6)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNombreCompleto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_5)
							.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboboxsexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		frmAltaPaciente.getContentPane().setLayout(groupLayout);
	}
	public AccionResultado getAccionResultado() {
		return accionResultado;
	}
	public PacienteDTO getPaciente() {
		return paciente;
	}
	private void llenarFormulario(){
		txtDni.setText(paciente.getDNI());
		txtNombreCompleto.setText(paciente.getNombre());
		txtMail.setText(paciente.getMail());
		txtEdad.setText(paciente.getEdad());
		txtDomicilio.setText(paciente.getDomicilio());
	}
	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
		llenarFormulario();
	}

	public void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		frmAltaPaciente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	

	
}
