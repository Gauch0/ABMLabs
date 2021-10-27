import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;

import collections.Documento_Peticiones;
import laboratorio.ControllerPeticion;
import laboratorio.Peticion;
import tablesModel.TableModelPeticion;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarPeticiones extends JFrame {

	private JPanel Peticiones;
	private JTextField textField;
	private JTextField textField_NombrePaciente;
	private JTextField textField_ObraSocial;
	private JTextField textField_FechaCarga;
	private JTextField textField_PracticasAsociadas;
	private JTextField textField_FechaEntrega;
	private JTable table;
	private Documento_Peticiones doc_Peticiones;
	private TableModelPeticion model;
	private int row;
	private ControllerPeticion controllerPeticion;
	private JButton btn_Aceptar;
	private JButton btn_Cancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarPeticiones frame = new ModificarPeticiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ModificarPeticiones() {
		inicializarVentana();
		inicializarEventos();
	}

	public void inicializarEventos() {

		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>1) {
					row = table.getSelectedRow();
					Peticion aux = controllerPeticion.leerPeticion(row);
					textField_NombrePaciente.setText(aux.getNombre());
					textField_ObraSocial.setText(aux.getObraSocial());
					textField_FechaCarga.setText(aux.getFechaCarga());
					textField_PracticasAsociadas.setText(aux.getPracticasAsociadas());
					textField_FechaEntrega.setText(aux.getFechaEntrega());
				}
			}
		});
		
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controllerPeticion.modificarPeticion(textField_NombrePaciente.getText()
						,textField_ObraSocial.getText()
						,textField_FechaCarga.getText()
						,textField_PracticasAsociadas.getText()
						,textField_FechaEntrega.getText()
						,row);
				
				dispose();
				ModificarPeticiones nuevaVentana = new ModificarPeticiones();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarPeticiones.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Peticiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 481);
		Peticiones = new JPanel();
		Peticiones.setBackground(new Color(255, 255, 255));
		Peticiones.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Peticiones);
		setLocationRelativeTo(null);
		
		JLabel lblPeticiones = new JLabel("Modificar Peticiones");
		lblPeticiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblBuscarPorId = new JLabel("Buscar por id del paciente:");
		lblBuscarPorId.setForeground(new Color(128, 128, 128));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");


		btn_Aceptar.setForeground(new Color(255, 255, 255));
		btn_Aceptar.setBackground(new Color(128, 128, 128));
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		
		JLabel lblNewLabel = new JLabel("Nombre de paciente:");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		
		JLabel lblObraSocial = new JLabel("Obra social:");
		lblObraSocial.setForeground(new Color(128, 128, 128));
		
		JLabel lblFechaDeCarga = new JLabel("Fecha de carga:");
		lblFechaDeCarga.setForeground(new Color(128, 128, 128));
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega:");
		lblFechaDeEntrega.setForeground(new Color(128, 128, 128));
		
		textField_NombrePaciente = new JTextField();
		textField_NombrePaciente.setColumns(10);
		
		textField_ObraSocial = new JTextField();
		textField_ObraSocial.setColumns(10);
		
		textField_FechaCarga = new JTextField();
		textField_FechaCarga.setColumns(10);
		
		textField_PracticasAsociadas = new JTextField();
		textField_PracticasAsociadas.setColumns(10);
		
		textField_FechaEntrega = new JTextField();
		textField_FechaEntrega.setColumns(10);
		
		JLabel lblPracticasAsociadas = new JLabel("Practicas asociadas:");
		lblPracticasAsociadas.setForeground(Color.GRAY);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_Peticiones = new GroupLayout(Peticiones);
		gl_Peticiones.setHorizontalGroup(
			gl_Peticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Peticiones.createSequentialGroup()
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Peticiones.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPeticiones)
								.addGroup(gl_Peticiones.createSequentialGroup()
									.addComponent(lblBuscarPorId)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Peticiones.createSequentialGroup()
									.addComponent(btn_Aceptar)
									.addGap(18)
									.addComponent(btn_Cancelar))))
						.addGroup(gl_Peticiones.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblObraSocial, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFechaDeCarga, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_ObraSocial, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(textField_FechaCarga, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(textField_NombrePaciente, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
							.addGap(35)
							.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblFechaDeEntrega, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPracticasAsociadas, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_FechaEntrega)
								.addComponent(textField_PracticasAsociadas, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Peticiones.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Peticiones.setVerticalGroup(
			gl_Peticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Peticiones.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPeticiones)
					.addGap(18)
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscarPorId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_NombrePaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_PracticasAsociadas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPracticasAsociadas))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblObraSocial)
						.addComponent(textField_ObraSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_FechaEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeEntrega))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeCarga)
						.addComponent(textField_FechaCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Aceptar)
						.addComponent(btn_Cancelar))
					.addContainerGap())
		);
		
		doc_Peticiones = new Documento_Peticiones();
		model = new TableModelPeticion(doc_Peticiones);
		controllerPeticion = new ControllerPeticion();
		table = new JTable(model);

		
		scrollPane.setViewportView(table);
		Peticiones.setLayout(gl_Peticiones);
		
	}
	
	public void cerrarVentana() {
		this.dispose();
	}
}
