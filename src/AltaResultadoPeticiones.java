import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;

import laboratorio.ControllerResultadoPeticiones;
import laboratorio.ResultadoPeticion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaResultadoPeticiones extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Diagnostico;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_FechaNac;
	private JTextField textField_ObraSocial;
	private JButton btn_Aceptar;
	private JButton btn_Cancelar;
	private JCheckBox checkbox_ValorCritico;
	private ControllerResultadoPeticiones controllerResultadoPeticiones;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaResultadoPeticiones frame = new AltaResultadoPeticiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AltaResultadoPeticiones() {
		inicializarVentana();
		inicializarEventos();
	}

	public void inicializarEventos() {
		
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadoPeticion nuevoResultadoPeticion = new ResultadoPeticion();
				nuevoResultadoPeticion.setNombre(textField_Nombre.getText());
				nuevoResultadoPeticion.setApellido(textField_Apellido.getText());
				nuevoResultadoPeticion.setObraSocial(textField_ObraSocial.getText());
				nuevoResultadoPeticion.setDiagnostico(textField_Diagnostico.getText());
				if(checkbox_ValorCritico.isSelected()) {
					nuevoResultadoPeticion.setValorCritico(true);
				}
				else {
					nuevoResultadoPeticion.setValorCritico(false);
				}
				
				controllerResultadoPeticiones.crearResultadoPeticiones(nuevoResultadoPeticion);
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
	/**
	 * Create the frame.
	 */
	public void inicializarVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaResultadoPeticiones.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Resultado de peticiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 360);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_3 = new JLabel("Fecha nac.");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		
		textField_Diagnostico = new JTextField();
		textField_Diagnostico.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Diagnostico");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		
		textField_FechaNac = new JTextField();
		textField_FechaNac.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Obra Social");
		lblNewLabel_6.setForeground(new Color(128, 128, 128));
		
		textField_ObraSocial = new JTextField();
		textField_ObraSocial.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");

		btn_Aceptar.setBackground(new Color(128, 128, 128));
		btn_Aceptar.setForeground(new Color(255, 255, 255));
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		
		checkbox_ValorCritico = new JCheckBox("Valor critico");
		checkbox_ValorCritico.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(checkbox_ValorCritico, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(53)
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_FechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_Apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_ObraSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(157))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_Diagnostico, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
							.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addContainerGap(439, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Aceptar)
							.addGap(18)
							.addComponent(btn_Cancelar)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_FechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_Apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_ObraSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_Diagnostico, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(checkbox_ValorCritico)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Aceptar)
						.addComponent(btn_Cancelar))
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
		
		controllerResultadoPeticiones = new ControllerResultadoPeticiones();
	}
}
