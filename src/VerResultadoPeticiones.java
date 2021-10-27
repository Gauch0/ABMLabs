import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collections.Documento_ResultadoPeticiones;
import subVentanas.ResultadoPeticionesCritico;
import tablesModel.TableModelResultadoPeticiones;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerResultadoPeticiones extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Documento_ResultadoPeticiones doc_ResultadoPeticiones;
	private TableModelResultadoPeticiones model;
	private JButton btnVerSoloResultados; 
	private JButton btn_Volver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerResultadoPeticiones frame = new VerResultadoPeticiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VerResultadoPeticiones() {
		inicializarVentana();
		inicializarEventos();
	}
	
	public void inicializarEventos() {
		
		btnVerSoloResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ResultadoPeticionesCritico ventanaResultadosCritico = new ResultadoPeticionesCritico();
				ventanaResultadosCritico.setVisible(true);
			}
		});
		
		btn_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		
	}
	/**
	 * Create the frame.
	 */
	public void inicializarVentana() {
		setTitle("Resultado peticiones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerResultadoPeticiones.class.getResource("/resources/Logo lab IOO.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		btn_Volver = new JButton("Volver");
		btn_Volver.setForeground(new Color(255, 255, 255));
		btn_Volver.setBackground(new Color(128, 128, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnVerSoloResultados = new JButton("Ver solo resultados de peticiones criticos");
		btnVerSoloResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnVerSoloResultados.setForeground(Color.WHITE);
		btnVerSoloResultados.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnVerSoloResultados)
							.addPreferredGap(ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
							.addComponent(btn_Volver)
							.addGap(44))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(12, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Volver)
						.addComponent(btnVerSoloResultados))
					.addContainerGap())
		);
		
		doc_ResultadoPeticiones = new Documento_ResultadoPeticiones();
		model = new TableModelResultadoPeticiones(doc_ResultadoPeticiones);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
