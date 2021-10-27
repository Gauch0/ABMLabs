import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import collections.Documento_Peticiones;
import laboratorio.ControllerPeticion;
import tablesModel.TableModelPeticion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BajaPeticiones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btn_EliminarPeticion;
	private JButton btn_Cancelar;
	private Documento_Peticiones doc_Peticiones;
	private TableModelPeticion model;
	private int row;
	private ControllerPeticion controllerPeticion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaPeticiones frame = new BajaPeticiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BajaPeticiones() {
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
		
		btn_EliminarPeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controllerPeticion.eliminarPeticion(row);
				dispose();
				BajaPeticiones nuevaVentana = new BajaPeticiones();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(BajaPeticiones.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Peticiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar peticion:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de paciente:");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		
		btn_EliminarPeticion = new JButton("Eliminar ");

		btn_EliminarPeticion.setBackground(new Color(128, 128, 128));
		btn_EliminarPeticion.setForeground(new Color(255, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(421, Short.MAX_VALUE)
					.addComponent(btn_EliminarPeticion, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 645, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_EliminarPeticion)
						.addComponent(btn_Cancelar))
					.addContainerGap())
		);
		
		doc_Peticiones = new Documento_Peticiones();
		model = new TableModelPeticion(doc_Peticiones);
		table = new JTable(model);
		controllerPeticion = new ControllerPeticion();

		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
