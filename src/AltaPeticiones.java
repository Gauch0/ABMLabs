import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collections.Documento_Sucursales;
import laboratorio.ControllerPeticion;
import laboratorio.ControllerSucursal;
import laboratorio.Sucursal;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.List;
import javax.swing.DefaultComboBoxModel;

public class AltaPeticiones extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nombre;
	private JTextField textField_ObraSocial;
	private JTextField textField_FechaCarga;
	private JTextField textField_PracticasAsociadas;
	private JTextField textField_FechaEntrega;
	private JButton btn_Aceptar;
	private JButton btn_Cancelar;
	private ControllerPeticion controllerPeticion;
	private Documento_Sucursales doc_Sucursales;
	private JLabel lblSucursal;
	private int cantidadDeSucursales;
	private JComboBox<String> comboBox;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPeticiones frame = new AltaPeticiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AltaPeticiones() {
		inicializarVentana();
		inicializarEventos();
	}
	
	public void inicializarEventos() {
		
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controllerPeticion.crearPeticion(textField_Nombre.getText()
						,textField_ObraSocial.getText()
						, textField_FechaCarga.getText()
						, textField_PracticasAsociadas.getText()
						, textField_FechaEntrega.getText()
						,comboBox.getSelectedItem().toString());
				
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaPeticiones.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Peticiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		controllerPeticion = new ControllerPeticion();
		doc_Sucursales = new Documento_Sucursales();
		
		JLabel lblCrearPeticion = new JLabel("Crear peticion:");
		lblCrearPeticion.setForeground(new Color(128, 128, 128));
		lblCrearPeticion.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNombrePaciente = new JLabel("Nombre paciente:");
		lblNombrePaciente.setBackground(new Color(255, 255, 255));
		lblNombrePaciente.setForeground(new Color(128, 128, 128));
		
		JLabel lblObraSocial = new JLabel("Obra social:");
		lblObraSocial.setForeground(new Color(128, 128, 128));
		
		JLabel lblFechaDeCarga = new JLabel("Fecha de carga:");
		lblFechaDeCarga.setForeground(new Color(128, 128, 128));
		
		JLabel lblPracticasAsociadas = new JLabel("Practicas asociadas:");
		lblPracticasAsociadas.setForeground(new Color(128, 128, 128));
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega:");
		lblFechaDeEntrega.setForeground(new Color(128, 128, 128));
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		
		textField_ObraSocial = new JTextField();
		textField_ObraSocial.setColumns(10);
		
		textField_FechaCarga = new JTextField();
		textField_FechaCarga.setColumns(10);
		
		textField_PracticasAsociadas = new JTextField();
		textField_PracticasAsociadas.setColumns(10);
		
		textField_FechaEntrega = new JTextField();
		textField_FechaEntrega.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");

		btn_Aceptar.setForeground(new Color(255, 255, 255));
		btn_Aceptar.setBackground(new Color(128, 128, 128));
		
		btn_Cancelar = new JButton("Cancelar");

		btn_Cancelar.setForeground(Color.WHITE);
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		
		lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setForeground(Color.GRAY);
		
		
		// PARA Saber en que sucursal se hizo
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setForeground(new Color(128, 128, 128));
		ArrayList<Sucursal> sucursales = doc_Sucursales.getSucursalesList();
		cantidadDeSucursales = sucursales.size();
		String[] nombreSucursales = new String[cantidadDeSucursales] ; 
		for(int i = 0;i<sucursales.size();i++) {
			nombreSucursales[i]= sucursales.get(i).getDireccion();
		}
	
		
		comboBox.setModel(new DefaultComboBoxModel(nombreSucursales));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCrearPeticion)
								.addComponent(lblObraSocial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblFechaDeCarga, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblFechaDeEntrega, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPracticasAsociadas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNombrePaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_PracticasAsociadas, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_FechaEntrega, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_ObraSocial, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_FechaCarga, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSucursal, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_Aceptar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCrearPeticion)
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombrePaciente)
								.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblObraSocial)
								.addComponent(textField_ObraSocial, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaDeCarga)
								.addComponent(textField_FechaCarga, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPracticasAsociadas)
								.addComponent(textField_PracticasAsociadas, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaDeEntrega)
								.addComponent(textField_FechaEntrega, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btn_Aceptar))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSucursal)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Cancelar))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
