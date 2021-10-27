import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import laboratorio.*;

public class AltaSucursales extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NumeroSucursal;
	private JTextField textField_Direccion;
	private JTextField textField_ResponsableTecnico;
	private JButton btn_Aceptar; 
	private JButton btn_Cancelar; 
	private ControllerSucursal controllerSuc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaSucursales frame = new AltaSucursales();
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
	
	public AltaSucursales() {
		inicializarVentana();
		inicializarEventos();
	}
	
	public void inicializarEventos() {

		btn_Aceptar.addActionListener(new ActionListener() {    // agrega sucursal a array del controlador nuevo declarado
			public void actionPerformed(ActionEvent arg0) {
				controllerSuc.crearSucursal(Integer.parseInt(textField_NumeroSucursal.getText()),textField_Direccion.getText(),textField_ResponsableTecnico.getText());					
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
	public void inicializarVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaSucursales.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Sucursal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Alta sucursal");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_3 = new JLabel("Responsable tecnico:");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));

		
		textField_NumeroSucursal = new JTextField();
		
		textField_NumeroSucursal.setColumns(10);
		
		textField_Direccion = new JTextField();
		textField_Direccion.setColumns(10);
		
		textField_ResponsableTecnico = new JTextField();
		textField_ResponsableTecnico.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");

		btn_Aceptar.setForeground(new Color(255, 255, 255));
		btn_Aceptar.setBackground(new Color(128, 128, 128));
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_Direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_NumeroSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_ResponsableTecnico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Aceptar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Cancelar)))
					.addContainerGap(200, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_NumeroSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_Direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_ResponsableTecnico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Aceptar)
						.addComponent(btn_Cancelar))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);

		controllerSuc = new ControllerSucursal();
	}

}
