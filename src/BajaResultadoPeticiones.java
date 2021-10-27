
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collections.Documento_ResultadoPeticiones;
import laboratorio.ControllerResultadoPeticiones;
import laboratorio.ResultadoPeticion;
import tablesModel.TableModelResultadoPeticiones;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BajaResultadoPeticiones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Documento_ResultadoPeticiones doc_ResultadoPeticiones;
	private TableModelResultadoPeticiones model;
	private JButton btn_Aceptar;
	private JButton btn_Cancelar;
	private ControllerResultadoPeticiones controllerResultadoPeticiones;
	private int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaResultadoPeticiones frame = new BajaResultadoPeticiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BajaResultadoPeticiones() {
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
		
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerResultadoPeticiones.eliminarResultadoPeticion(row);
				dispose();
				BajaResultadoPeticiones nuevaVentanaBajaResultadoPeticiones = new BajaResultadoPeticiones();
				nuevaVentanaBajaResultadoPeticiones.setVisible(true);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(BajaResultadoPeticiones.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Peticiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Peticion");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btn_Aceptar = new JButton("Aceptar");

		btn_Aceptar.setBackground(new Color(128, 128, 128));
		btn_Aceptar.setForeground(new Color(255, 255, 255));
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setBackground(new Color(128, 128, 128));
		btn_Cancelar.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("Resultado peticion a dar de baja");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_2 = new JLabel("La peticion sera dada de baja");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(12)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(btn_Aceptar)
							.addGap(13)
							.addComponent(btn_Cancelar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_Aceptar, Alignment.TRAILING)
						.addComponent(btn_Cancelar, Alignment.TRAILING))
					.addGap(7))
		);
		
		controllerResultadoPeticiones = new ControllerResultadoPeticiones();
		doc_ResultadoPeticiones = new Documento_ResultadoPeticiones();
		model = new TableModelResultadoPeticiones(doc_ResultadoPeticiones);
		table = new JTable(model);

		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
