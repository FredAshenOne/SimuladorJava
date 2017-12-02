package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JRadioButton;


import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

public class Ventana extends JFrame implements ActionListener{
	DefaultListModel<Procesos> model = new DefaultListModel<>();
	ProcessManager processman = new ProcessManager();
	private JPanel contentPane;
	private JTextField name;
	private JTextField quantum;
	private JTextField prior;
	private ButtonGroup botones = new ButtonGroup();
	int id = 0;
	int p = 1;
	JButton btnIniciar;
	JButton btnNuevaSimulacion;

	MyThread tread;
	JList<Procesos> lista;	// Create the frame.
	private JLabel progName;

	public Ventana() {
		
		setTitle("Simulador de Procesos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel NuevoProc = new JPanel();
		NuevoProc.setBounds(10, 11, 205, 152);
		contentPane.add(NuevoProc);
		NuevoProc.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 37, 14);
		NuevoProc.add(lblNombre);
		
		name = new JTextField();
		name.setBounds(57, 8, 100, 20);
		NuevoProc.add(name);
		name.setColumns(10);

		JLabel lblDuracion = new JLabel("Duracion ");
		lblDuracion.setBounds(10, 36, 46, 14);
		NuevoProc.add(lblDuracion);

		quantum = new JTextField();
		quantum.setBounds(57, 33, 100, 20);
		NuevoProc.add(quantum);
		quantum.setColumns(10);

		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setBounds(10, 61, 46, 14);
		NuevoProc.add(lblPrioridad);

		prior = new JTextField();
		prior.setBounds(57, 58, 100, 20);
		NuevoProc.add(prior);
		prior.setColumns(10);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(576, 409, 89, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);

		JPanel Selector = new JPanel();
		Selector.setBounds(10, 174, 157, 93);
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
		
		rdbtnFifo.addActionListener(this);
		rdbtnLifo.addActionListener(this);
		rdbtnSjf.addActionListener(this);
		rdbtnPrioridad.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 11, 432, 202);
		contentPane.add(scrollPane);
		
		lista = new JList<>(model);
		scrollPane.setViewportView(lista);
		lista.setCellRenderer(processman.getCellRender());
		JPanel goContainer = new JPanel();
		goContainer.setBounds(10, 268, 141,87);
		contentPane.add(goContainer);
		goContainer.setLayout(null);
		


		JButton btnAgregar = new JButton("Agregar Proceso");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Procesos proceso = new Procesos(name.getText(), Integer.parseInt(quantum.getText()),
						Integer.parseInt(prior.getText()), id,"En Espera");
				model.addElement(proceso);
				id++;
				name.setText("");
				quantum.setText("");
				prior.setText("");
				lista.setModel(model);
				

			}
		});
		btnAgregar.setBounds(35, 86, 133, 23);
		NuevoProc.add(btnAgregar);
		
		JButton btnR = new JButton("R\r\n");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("Proceso"+p);
				p++;
				
			}
		});
		btnR.setBounds(162, 7, 22, 23);
		NuevoProc.add(btnR);
		
		JButton buttonr1 = new JButton("R\r\n");
		buttonr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantum.setText(Integer.toString((int)(Math.random()*100)+1));
				
			}
		});
		buttonr1.setBounds(162, 32, 22, 23);
		NuevoProc.add(buttonr1);
		
		JButton buttonr2 = new JButton("R\r\n");
		buttonr2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prior.setText(Integer.toString((int)(Math.random()*100)+1));
			}
		});
		buttonr2.setBounds(162, 57, 22, 23);
		NuevoProc.add(buttonr2);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(225, 253, 432, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 11, 432, 19);
		panel.add(progressBar);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.setSelectedIndex(0);
				btnIniciar.setEnabled(false);
				btnAgregar.setEnabled(false);
				tread = new MyThread(model,progressBar,progName,lista,btnNuevaSimulacion);
				lista.setSelectedIndex(1);
			}
		});
		btnIniciar.setBounds(31, 11, 74, 71);
		goContainer.add(btnIniciar);
		
		btnNuevaSimulacion = new JButton("Nueva Simulacion");
		btnNuevaSimulacion.setEnabled(false);
		btnNuevaSimulacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregar.setEnabled(true);
				btnIniciar.setEnabled(true);
				btnNuevaSimulacion.setEnabled(false);
				model.removeAllElements();
				lista = new JList<>(model);
				
				
			}
		});
		btnNuevaSimulacion.setBounds(35, 118, 133, 23);
		NuevoProc.add(btnNuevaSimulacion);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(401, 224, 245, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("En Progreso:");
		lblNewLabel.setBounds(0, 0, 76, 23);
		panel_1.add(lblNewLabel);
		
		progName = new JLabel();
		progName.setBounds(72, 0, 173, 22);
		panel_1.add(progName);
		
		
	}

	@Override	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "FIFO":
			processman.fifoOrdering(model);

			lista = new JList<> (model);
			break;
		case "LIFO":
			processman.lifoOrdering(model);

			lista = new JList<> (model);
			 break;
		case "SJF":
			processman.sjfOrdering(model);
			lista = new JList<> (model);
			break;
		case "Prioridad":
			processman.priorOrdering(model);
			lista = new JList<> (model);
			break;
		
				 
		}
	}
}
