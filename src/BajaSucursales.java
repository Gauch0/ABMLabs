import java.awt.BorderLayout;
import tablesModel.*;
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
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

import collections.Documento_Sucursales;
import laboratorio.ControllerSucursal;
import subVentanas.SucursalDerivada;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaSucursales extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private TableModelSucursal model;
	private Documento_Sucursales doc_Sucursales;
	private int row;
	private JButton btn_Eliminar;
	private ControllerSucursal controllerSucursal;
	private JButton btn_Cancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaSucursales frame = new BajaSucursales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public BajaSucursales()	{
		inicializarVentana();
		inicializarEventos();
	}
	
	public void inicializarEventos() {
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>0) {
					row = table.getSelectedRow();
				}
			}
		});
		
		btn_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombreSucursalEliminada = controllerSucursal.leerSucursal(row).getDireccion();
				controllerSucursal.eliminarSucursal(row);
				SucursalDerivada derivarSucursalVentana = new SucursalDerivada(nombreSucursalEliminada);
				derivarSucursalVentana.setVisible(true);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(BajaSucursales.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Sucursales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Sucursal: ");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("La sucursal sera dado de baja");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		btn_Eliminar = new JButton("Eliminar");
		
		btn_Eliminar.setBackground(new Color(128, 128, 128));
		btn_Eliminar.setForeground(new Color(255, 255, 255));
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		
		JLabel lblEliminarSucursales = new JLabel("Eliminar Sucursales");
		lblEliminarSucursales.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
									.addGap(109))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(btn_Eliminar)
							.addGap(18)
							.addComponent(btn_Cancelar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEliminarSucursales))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEliminarSucursales)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Eliminar)
						.addComponent(btn_Cancelar))
					.addContainerGap())
		);
		
		doc_Sucursales = new Documento_Sucursales();
		model = new TableModelSucursal(doc_Sucursales);
		table = new JTable(model);
		controllerSucursal = new ControllerSucursal();
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
