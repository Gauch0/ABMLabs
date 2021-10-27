package subVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collections.Documento_ResultadoPeticiones;
import tablesModel.TableModelResultadoPeticiones;
import tablesModel.TableModelResultadoPeticionesValorCritico;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultadoPeticionesCritico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Documento_ResultadoPeticiones doc_ResultadoPeticiones;
	private TableModelResultadoPeticionesValorCritico model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadoPeticionesCritico frame = new ResultadoPeticionesCritico();
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
	public ResultadoPeticionesCritico() {
		setTitle("Peticiones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ResultadoPeticionesCritico.class.getResource("/resources/Logo lab IOO.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Resultado de peticiones en valor critico:");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 128, 128));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(541, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addContainerGap())
		);
		
		doc_ResultadoPeticiones = new Documento_ResultadoPeticiones();
		model = new TableModelResultadoPeticionesValorCritico(doc_ResultadoPeticiones);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
