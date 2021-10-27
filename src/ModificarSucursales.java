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
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import collections.Documento_Sucursales;
import laboratorio.ControllerSucursal;
import laboratorio.Sucursal;
import tablesModel.TableModelSucursal;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarSucursales extends JFrame {

	private JPanel contentPane;
	private JTextField textField_BuscarSucursal;
	private JTextField textField_Direccion;
	private JTextField textField_Tecnico;
	private JTable table_Sucursales;
	private JButton btn_Aceptar;
	private JButton btn_Cancelar;
	private Documento_Sucursales doc_Sucursales;
	private TableModelSucursal model;
	private JTextField textField_Numero;
	private int row;
	private ControllerSucursal controllerSucursal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarSucursales frame = new ModificarSucursales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ModificarSucursales() {
		inicializarVentana();
		inicializarEventos();
	}
	
	public void inicializarEventos(){
		
		table_Sucursales.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>1) {
					row = table_Sucursales.getSelectedRow();
					Sucursal aux = controllerSucursal.leerSucursal(row);
					textField_Direccion.setText(aux.getDireccion());
					textField_Tecnico.setText(aux.getTecnico());
					textField_Numero.setText(Integer.toString(aux.getNumero()));
					
				}
			}
		});

		btn_Aceptar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent o) {
				controllerSucursal.modificarSucursal(Integer.parseInt(textField_Numero.getText())
						, textField_Direccion.getText()
						, textField_Tecnico.getText()
						, row);
				
				dispose();
				ModificarSucursales nuevaVentana = new ModificarSucursales();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarSucursales.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Sucursal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 538);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Modificacion sucursal");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Buscar sucursal:");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		textField_BuscarSucursal = new JTextField();
		textField_BuscarSucursal.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		
		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		
		textField_Direccion = new JTextField();
		textField_Direccion.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");
		
		

		btn_Aceptar.setBackground(new Color(128, 128, 128));
		btn_Aceptar.setForeground(new Color(255, 255, 255));
		
		btn_Cancelar = new JButton("Cancelar");

		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Responsable tecnico:");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		
		textField_Tecnico = new JTextField();
		textField_Tecnico.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNumero = new JLabel("Numero:");
		
		textField_Numero = new JTextField();
		textField_Numero.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(btn_Aceptar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(507, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_BuscarSucursal, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(96))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_Direccion)
								.addComponent(textField_Tecnico, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
							.addGap(148)
							.addComponent(lblNumero)
							.addGap(18)
							.addComponent(textField_Numero, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(91, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_BuscarSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_Direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumero)
						.addComponent(textField_Numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_Tecnico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Aceptar)
						.addComponent(btn_Cancelar))
					.addContainerGap())
		);
		
		
		doc_Sucursales = new Documento_Sucursales();
		model = new TableModelSucursal(doc_Sucursales);
		table_Sucursales = new JTable(model);
		controllerSucursal = new ControllerSucursal();
		model.refresh();
		scrollPane.setViewportView(table_Sucursales);
		contentPane.setLayout(gl_contentPane);
	}
}
