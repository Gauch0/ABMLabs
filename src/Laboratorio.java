import laboratorio.*;
import subVentanas.ResultadoPeticionesCritico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Laboratorio extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnPeticiones;
	private JMenu mnPracticas;
	private JMenu mnPeticiones_1;
	private JMenu mnResultados;
	private JMenu mnActuales;
	private JMenuItem item_PeticionesResultadosAgregar;
	private JMenuItem item_PeticionesResultadosEliminar;
	private JMenuItem item_PeticionesResultadosModificar;
	private JMenuItem Item_PeticionesActualesAgregar;
	private JMenuItem Item_PeticionesActualesEliminar;
	private JMenuItem Item_PeticionesActualesModificar;
	private JMenuItem item_AgregarPractica;
	private JMenuItem item_EliminarPractica;
	private JMenuItem item_ModificarPractica;
	private JMenuItem item_AgregarSucursal;
	private JMenuItem item_EliminarSucursal;
	private JMenuItem item_ModificarSucursal;
	private JMenuItem item_AgregarPaciente;
	private JMenuItem item_EliminarPaciente;
	private JMenuItem item_ModificarPaciente;
	private JLabel lblNewLabel;
	private JMenu mnUsuarios;
	private JMenuItem item_AgregarUsuarios;
	private JMenuItem item_EliminarUsuarios;
	private JMenuItem item_ModificarUsuarios;
	private JMenuItem item_VerPeticiones;
	private JMenuItem mntmVerPracticas;
	private JMenuItem mntmVerSucursales;
	private JMenuItem mntmVerPacientes;
	private JMenuItem mntmVerUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laboratorio frame = new Laboratorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 * @return 
	 */
	
	public Laboratorio() {
		initializeWindow();
		initializeEvents();
	}
	
	private void initializeEvents() {
		Item_PeticionesActualesAgregar.addActionListener(new ActionListener() {    	//ALTAS PETICIONES
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltaPeticiones ventanaAltaPeticiones = new AltaPeticiones();
				ventanaAltaPeticiones.setVisible(true);
			}
		});
		Item_PeticionesActualesEliminar.addActionListener(new ActionListener() {	//BAJA PETICIONES
			public void actionPerformed(ActionEvent e) {
				dispose();
				BajaPeticiones ventanaBajaPeticiones = new BajaPeticiones();
				ventanaBajaPeticiones.setVisible(true);
			}
		});
		Item_PeticionesActualesModificar.addActionListener(new ActionListener() {	//MODIFICAR PETICIONES
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarPeticiones ventanaModificarPeticiones = new ModificarPeticiones();
				ventanaModificarPeticiones.setVisible(true);
			}
		});
		
		item_PeticionesResultadosAgregar.addActionListener(new ActionListener() {		//PETICIONES RESULTADOS
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltaResultadoPeticiones ventanaAltaResultadoPeticiones = new AltaResultadoPeticiones();
				ventanaAltaResultadoPeticiones.setVisible(true);
			}
		});
		
		item_PeticionesResultadosEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BajaResultadoPeticiones ventanaBajaResultadoPeticiones = new BajaResultadoPeticiones();
				ventanaBajaResultadoPeticiones.setVisible(true);
			}
		});

		item_PeticionesResultadosModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarResultadoPeticiones ventanaModificarResultadoPeticiones = new ModificarResultadoPeticiones();
				ventanaModificarResultadoPeticiones.setVisible(true);
			}
		});
		
		item_AgregarPaciente.addActionListener(new ActionListener() {						//PACIENTES
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltaPacientes ventanaAltaPacientes = new AltaPacientes();

			}
		});
		
		item_EliminarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BajaPacientes ventanaBajaPacientes = new BajaPacientes();
				ventanaBajaPacientes.setVisible(true);
			}
		});
		
		item_ModificarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarPacientes ventanaModificarPacientes = new ModificarPacientes();
				ventanaModificarPacientes.setVisible(true);
			}
		});
		
		item_AgregarSucursal.addActionListener(new ActionListener() {						//SUCURSALES
			public void actionPerformed(ActionEvent e) {
				dispose();
				AltaSucursales ventanaAltaSucursales = new AltaSucursales();
				ventanaAltaSucursales.setVisible(true);
			}
		});

		item_EliminarSucursal.addActionListener(new ActionListener() {						
			public void actionPerformed(ActionEvent e) {
				dispose();
				BajaSucursales ventanaBajaSucursales = new BajaSucursales();
				ventanaBajaSucursales.setVisible(true);
			}
		});

		item_ModificarSucursal.addActionListener(new ActionListener() {						
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarSucursales ventanaModificarSucursales = new ModificarSucursales();
				ventanaModificarSucursales.setVisible(true);
			}
		});

		item_AgregarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AltaUsuarios ventanaAltaUsuarios = new AltaUsuarios();
				ventanaAltaUsuarios.setVisible(true);
			}
		});

		item_EliminarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				BajaUsuarios ventanaBajaUsuarios = new BajaUsuarios();
				ventanaBajaUsuarios.setVisible(true);
			}
		});
		
		item_ModificarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarUsuarios ventanaModificarUsuarios = new ModificarUsuarios();
				ventanaModificarUsuarios.setVisible(true);
			}
		});
		
		item_VerPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerResultadoPeticiones ventanaResultadoPeticiones= new VerResultadoPeticiones();
				ventanaResultadoPeticiones.setVisible(true);
			}
		});
		
		mntmVerSucursales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerSucursales ventanaSucursales = new VerSucursales();
				ventanaSucursales.setVisible(true);
			}
		});
		
		mntmVerUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerUsuarios ventanaUsuarios = new VerUsuarios();
				ventanaUsuarios.setVisible(true);
			}
		});
		
//		item_AgregarPractica.addActionListener(new ActionListener() {						//PRACTICAS
//			public void actionPerformed(ActionEvent e) {
//				AltaPractica ventanaAltaPractica = new AltaPractica();
//				ventanaAltaPractica.setVisible(true);
//			}
//		});
//
//		item_EliminarPractica.addActionListener(new ActionListener() {						
//			public void actionPerformed(ActionEvent e) {
//				EliminarPractica ventanaEliminarPractica = new EliminarPractica();
//				ventanaEliminarPractica.setVisible(true);
//			}
//		});
//
//		item_ModificarPractica.addActionListener(new ActionListener() {						
//			public void actionPerformed(ActionEvent e) {
//				ModificarPractica ventanaModificarPractica = new ModificarPractica();
//				ventanaModificarPractica.setVisible(true);
//			}
//		});
//
//		
		
	}
	
	private void initializeWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Laboratorio.class.getResource("/resources/Logo lab IOO.jpg")));
		setTitle("Laboratorio");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 389);
		setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		menuBar.setToolTipText("");
		menuBar.setEnabled(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(192, 192, 192));

		setJMenuBar(menuBar);
		
		
		mnNewMenu = new JMenu("Pacientes");
		mnNewMenu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.setForeground(new Color(0, 128, 0));
		menuBar.add(mnNewMenu);
		
		item_AgregarPaciente = new JMenuItem("Agregar paciente");
		item_AgregarPaciente.setForeground(new Color(0, 128, 0));
		item_AgregarPaciente.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_AgregarPaciente.setBackground(new Color(211, 211, 211));
		mnNewMenu.add(item_AgregarPaciente);
		
		item_EliminarPaciente = new JMenuItem("Eliminar paciente");
		item_EliminarPaciente.setForeground(new Color(0, 128, 0));
		item_EliminarPaciente.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_EliminarPaciente.setBackground(new Color(211, 211, 211));
		mnNewMenu.add(item_EliminarPaciente);
		
		item_ModificarPaciente = new JMenuItem("Modificar paciente");
		item_ModificarPaciente.setForeground(new Color(0, 128, 0));
		item_ModificarPaciente.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_ModificarPaciente.setBackground(new Color(211, 211, 211));
		mnNewMenu.add(item_ModificarPaciente);
		
		mntmVerPacientes = new JMenuItem("Ver pacientes");
		mntmVerPacientes.setForeground(new Color(0, 128, 0));
		mntmVerPacientes.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmVerPacientes.setBackground(new Color(211, 211, 211));
		mnNewMenu.add(mntmVerPacientes);
		
		mnPeticiones = new JMenu("Sucursales");
		mnPeticiones.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnPeticiones.setForeground(new Color(0, 128, 0));
		menuBar.add(mnPeticiones);
		
		item_AgregarSucursal = new JMenuItem("Agregar sucursal");
		item_AgregarSucursal.setForeground(new Color(0, 128, 0));
		item_AgregarSucursal.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_AgregarSucursal.setBackground(new Color(211, 211, 211));
		mnPeticiones.add(item_AgregarSucursal);
		
		item_EliminarSucursal = new JMenuItem("Eliminar sucursal");
		item_EliminarSucursal.setForeground(new Color(0, 128, 0));
		item_EliminarSucursal.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_EliminarSucursal.setBackground(new Color(211, 211, 211));
		mnPeticiones.add(item_EliminarSucursal);
		
		item_ModificarSucursal = new JMenuItem("Modificar sucursal");
		item_ModificarSucursal.setForeground(new Color(0, 128, 0));
		item_ModificarSucursal.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_ModificarSucursal.setBackground(new Color(211, 211, 211));
		mnPeticiones.add(item_ModificarSucursal);
		
		mntmVerSucursales = new JMenuItem("Ver sucursales");

		mntmVerSucursales.setForeground(new Color(0, 128, 0));
		mntmVerSucursales.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmVerSucursales.setBackground(new Color(211, 211, 211));
		mnPeticiones.add(mntmVerSucursales);
		
		mnPracticas = new JMenu("Practicas");
		mnPracticas.setForeground(new Color(0, 128, 0));
		mnPracticas.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		menuBar.add(mnPracticas);
		
		item_AgregarPractica = new JMenuItem("Agregar practica");
		item_AgregarPractica.setForeground(new Color(0, 128, 0));
		item_AgregarPractica.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_AgregarPractica.setBackground(new Color(211, 211, 211));
		mnPracticas.add(item_AgregarPractica);
		
		item_EliminarPractica = new JMenuItem("Eliminar practica");
		item_EliminarPractica.setForeground(new Color(0, 128, 0));
		item_EliminarPractica.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_EliminarPractica.setBackground(new Color(211, 211, 211));
		mnPracticas.add(item_EliminarPractica);
		
		item_ModificarPractica = new JMenuItem("Modificar practica");
		item_ModificarPractica.setForeground(new Color(0, 128, 0));
		item_ModificarPractica.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_ModificarPractica.setBackground(new Color(211, 211, 211));
		mnPracticas.add(item_ModificarPractica);
		
		mntmVerPracticas = new JMenuItem("Ver practicas");
		mntmVerPracticas.setForeground(new Color(0, 128, 0));
		mntmVerPracticas.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmVerPracticas.setBackground(new Color(211, 211, 211));
		mnPracticas.add(mntmVerPracticas);
		
		mnPeticiones_1 = new JMenu("Peticiones");
		mnPeticiones_1.setForeground(new Color(0, 128, 0));
		mnPeticiones_1.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		menuBar.add(mnPeticiones_1);
		
		mnActuales = new JMenu("Actuales");
		mnActuales.setBackground(new Color(192, 192, 192));
		mnActuales.setForeground(new Color(0, 128, 0));
		mnActuales.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnPeticiones_1.add(mnActuales);
		
		Item_PeticionesActualesAgregar = new JMenuItem("Agregar...");

		Item_PeticionesActualesAgregar.setForeground(new Color(0, 128, 0));
		Item_PeticionesActualesAgregar.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		Item_PeticionesActualesAgregar.setBackground(new Color(211, 211, 211));
		mnActuales.add(Item_PeticionesActualesAgregar);
		
		Item_PeticionesActualesEliminar = new JMenuItem("Eliminar...");

		Item_PeticionesActualesEliminar.setForeground(new Color(0, 128, 0));
		Item_PeticionesActualesEliminar.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		Item_PeticionesActualesEliminar.setBackground(new Color(211, 211, 211));
		mnActuales.add(Item_PeticionesActualesEliminar);
		
		Item_PeticionesActualesModificar = new JMenuItem("Modificar...");

		Item_PeticionesActualesModificar.setForeground(new Color(0, 128, 0));
		Item_PeticionesActualesModificar.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		Item_PeticionesActualesModificar.setBackground(new Color(211, 211, 211));
		mnActuales.add(Item_PeticionesActualesModificar);
		
		mnResultados = new JMenu("Resultados");
		mnResultados.setBackground(new Color(192, 192, 192));
		mnResultados.setForeground(new Color(0, 128, 0));
		mnResultados.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnPeticiones_1.add(mnResultados);
		
		item_PeticionesResultadosAgregar = new JMenuItem("Agregar...");

		item_PeticionesResultadosAgregar.setForeground(new Color(0, 128, 0));
		mnResultados.add(item_PeticionesResultadosAgregar);
		item_PeticionesResultadosAgregar.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_PeticionesResultadosAgregar.setBackground(new Color(211, 211, 211));
		
		item_PeticionesResultadosEliminar = new JMenuItem("Eliminar...");

		item_PeticionesResultadosEliminar.setForeground(new Color(0, 128, 0));
		item_PeticionesResultadosEliminar.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_PeticionesResultadosEliminar.setBackground(new Color(211, 211, 211));
		mnResultados.add(item_PeticionesResultadosEliminar);
		
		item_PeticionesResultadosModificar = new JMenuItem("Modificar...");
		item_PeticionesResultadosModificar.setForeground(new Color(0, 128, 0));
		item_PeticionesResultadosModificar.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_PeticionesResultadosModificar.setBackground(new Color(211, 211, 211));
		mnResultados.add(item_PeticionesResultadosModificar);
		
		item_VerPeticiones = new JMenuItem("Ver peticiones");
		mnPeticiones_1.add(item_VerPeticiones);
		
				item_VerPeticiones.setForeground(new Color(0, 128, 0));
				item_VerPeticiones.setFont(new Font("Segoe UI", Font.ITALIC, 12));
				item_VerPeticiones.setBackground(new Color(211, 211, 211));
		
		mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setForeground(new Color(0, 128, 0));
		mnUsuarios.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		menuBar.add(mnUsuarios);
		
		item_AgregarUsuarios = new JMenuItem("Agregar usuarios");

		item_AgregarUsuarios.setForeground(new Color(0, 128, 0));
		item_AgregarUsuarios.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_AgregarUsuarios.setBackground(new Color(211, 211, 211));
		mnUsuarios.add(item_AgregarUsuarios);
		
		item_EliminarUsuarios = new JMenuItem("Eliminar usuarios");
		item_EliminarUsuarios.setForeground(new Color(0, 128, 0));
		item_EliminarUsuarios.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_EliminarUsuarios.setBackground(new Color(211, 211, 211));
		mnUsuarios.add(item_EliminarUsuarios);
		
		item_ModificarUsuarios = new JMenuItem("Modificar usuarios");
		item_ModificarUsuarios.setForeground(new Color(0, 128, 0));
		item_ModificarUsuarios.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		item_ModificarUsuarios.setBackground(new Color(211, 211, 211));
		mnUsuarios.add(item_ModificarUsuarios);
		
		mntmVerUsuarios = new JMenuItem("Ver usuarios");

		mntmVerUsuarios.setForeground(new Color(0, 128, 0));
		mntmVerUsuarios.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmVerUsuarios.setBackground(new Color(211, 211, 211));
		mnUsuarios.add(mntmVerUsuarios);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(Laboratorio.class.getResource("/resources/Logo lab IOO.jpg")));
		contentPane.add(lblNewLabel);
		
	}

	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
