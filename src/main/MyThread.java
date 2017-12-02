package main;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MyThread implements Runnable{

	Thread t;
	DefaultListModel<Procesos> list;
	JProgressBar pb;
	Procesos temp;
	JLabel txt;
	JList<Procesos> lista;
	JButton start,add,newSim;
	public MyThread(DefaultListModel<Procesos> dflm, JProgressBar jpb,JLabel tx,JList<Procesos> lis,JButton ns) {
		t = new Thread(this,"Hilo 1");
		t.start();
		pb = jpb;
		list = dflm;
		txt = tx;
		lista = lis;
		newSim = ns;
		
	}
	
	public void run() {
			try {
				for (int i=0; i <= list.size()-1; i++) {
					list.get(i).setStatus("En Proceso");
					lista.setSelectedIndex(i);
					lista = new JList<>(list);
					txt.setText("  "+list.getElementAt(i).getName());
					pb.setMaximum(list.get(i).getQuantum());

					while(pb.getValue() < pb.getMaximum()) {
						
						pb.setValue(pb.getValue()+1);
						Thread.sleep(1000);
					}
					lista.removeAll();
					Thread.sleep(1000);

					pb.setValue(0);
					list.get(i).setStatus("Terminado");
					lista.setSelectedIndex(i);
					lista = new JList<>(list);
					txt.setText(" ");
				}Thread.sleep(1000);
				txt.setText(" ");
				newSim.setEnabled(true);
			}catch(InterruptedException e) {}
			
			
		}
		
		
	}

