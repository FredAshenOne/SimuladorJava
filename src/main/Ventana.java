package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class Ventana extends JFrame {
	DefaultListModel<Procesos> model = new DefaultListModel<>();
	ProcessManager processman = new ProcessManager();
	private JPanel contentPane;
	private JTextField name;
	private JTextField quantum;
	private JTextField prior;
	private ButtonGroup botones = new ButtonGroup();
	int id = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setTitle("Simulador de Procesos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NuevoProc = new JPanel();
		NuevoProc.setBounds(10, 11, 157, 122);
		contentPane.add(NuevoProc);
		NuevoProc.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 37, 14);
		NuevoProc.add(lblNombre);
		model.addElement(new Procesos("fred",12,12,12));
		
		name = new JTextField();
		name.setBounds(57, 8, 86, 20);
		NuevoProc.add(name);
		name.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion ");
		lblDuracion.setBounds(10, 36, 46, 14);
		NuevoProc.add(lblDuracion);
		
		quantum = new JTextField();
		quantum.setBounds(57, 33, 86, 20);
		NuevoProc.add(quantum);
		quantum.setColumns(10);
		
		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setBounds(10, 61, 46, 14);
		NuevoProc.add(lblPrioridad);
		
		prior = new JTextField();
		prior.setBounds(57, 58, 86, 20);
		NuevoProc.add(prior);
		prior.setColumns(10);
		
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(576, 409, 89, 23);
		contentPane.add(btnSalir);
		
		JPanel Selector = new JPanel();
		Selector.setBounds(10, 133, 157, 93);
		contentPane.add(Selector);
		Selector.setLayout(null);
		
		JRadioButton rdbtnFifo = new JRadioButton("FIFO");
		rdbtnFifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnFifo.setBounds(6, 11, 61, 23);
		Selector.add(rdbtnFifo);
		
		JRadioButton rdbtnLifo = new JRadioButton("LIFO");
		rdbtnLifo.setBounds(6, 31, 61, 23);
		Selector.add(rdbtnLifo);
		
		JRadioButton rdbtnSjf = new JRadioButton("SJF");
		rdbtnSjf.setBounds(6, 51, 61, 23);
		Selector.add(rdbtnSjf);
		
		JRadioButton rdbtnPrioridad = new JRadioButton("Prioridad");
		rdbtnPrioridad.setBounds(6, 70, 77, 23);
		Selector.add(rdbtnPrioridad);
		botones.add(rdbtnLifo);
		botones.add(rdbtnFifo);
		botones.add(rdbtnSjf);
		botones.add(rdbtnPrioridad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 195, 141, 139);
		contentPane.add(scrollPane);

		
		JList<Procesos> lista = new JList<Procesos>(model);
		lista.setBounds(130, 165, -123, -160);
		scrollPane.add(lista);
		lista.setVisible(true);

		JPanel goContainer = new JPanel();
		goContainer.setBounds(20, 237, 141, 87);
		contentPane.add(goContainer);
		goContainer.setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(31, 11, 74, 71);
		goContainer.add(btnIniciar);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(model.getElementAt(0).getName());
			}
		});

		JButton btnAgregar = new JButton("Agregar Proceso");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Procesos proceso = new Procesos(name.getText(),Integer.parseInt(quantum.getText()),Integer.parseInt(prior.getText()),id);
				model.addElement(proceso);
				id++;
				name.setText("");
				quantum.setText("");
				prior.setText("");
				lista.setModel(model);
			}
		});
		btnAgregar.setBounds(10, 86, 133, 23);
		NuevoProc.add(btnAgregar);
		

		
	}
}

