package subVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collections.Documento_Sucursales;
import laboratorio.ControllerPeticion;
import tablesModel.TableModelSucursal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SucursalDerivada extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	private JTable table;
	private TableModelSucursal model;
	private Documento_Sucursales doc_Sucursales;
	private JButton btn_Aceptar;
	private ControllerPeticion controllerPeticion;
	private String sucursalDestino;
	private int row;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SucursalDerivada frame = new SucursalDerivada(String);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SucursalDerivada(String nombreSucursalEliminada) { 				//NOMBRE DE SUCURSAL ELIMINADA< FALTA PASAR TODAS LAS PETICIONES
													
		inicializarVentana();
		inicializarEventos(nombreSucursalEliminada);
		
	}

	public void inicializarEventos(String nombreSucursalEliminada) {
		
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerPeticion.cambiarSucursal(nombreSucursalEliminada,sucursalDestino);
				System.out.println("Mostrar " +sucursalDestino);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>0) {
					row = table.getSelectedRow();
					sucursalDestino = doc_Sucursales.getSucursalesList().get(row).getDireccion();
				}
			}
		});
		
	}
	/**
	 * Create the frame.
	 */
	public void inicializarVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SucursalDerivada.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Sucursales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblADondeDesea = new JLabel("A donde desea derivar las peticiones de la sucursal?");
		lblADondeDesea.setForeground(new Color(128, 128, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btn_Aceptar = new JButton("Aceptar");

		btn_Aceptar.setBackground(new Color(128, 128, 128));
		btn_Aceptar.setForeground(new Color(255, 255, 255));
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblADondeDesea)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(btn_Aceptar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblADondeDesea)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Aceptar)
						.addComponent(btn_Cancelar))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		controllerPeticion = new ControllerPeticion();
		doc_Sucursales = new Documento_Sucursales();
		model = new TableModelSucursal(doc_Sucursales);
		table = new JTable(model);


		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
