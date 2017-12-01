package main;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ProcessManager {

	List<Procesos> processList;
	Iterator<Procesos> listIterator;
	Timer t;

	public ProcessManager() {
		processList = Collections.synchronizedList(new ArrayList<Procesos>());
		listIterator = processList.iterator();
		
	}

	// agregar un nuevo proceso a la lista

	public void addProcess(Procesos procesos) {
		processList.add(procesos);

	}

	ListCellRenderer<? super Procesos> getCellRender() {

		return new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Procesos proceso = (Procesos) value;
				return super.getListCellRendererComponent(list,
						"-Nombre: " + proceso.getName() + "  -Quantum: " + proceso.getQuantum() + "  -Prioridad: "
								+ proceso.getPrioridad() + "  -Id: " + proceso.getId()+"   -Status:  "+proceso.getStatus(),
						index, isSelected, cellHasFocus);

			}
		};
	}

	public void fifoOrdering(DefaultListModel<Procesos> lista) {
		for (int i = 0; i < lista.size()-1; i++) {
			for (int j = 0; j < lista.size()-1; j++) {
				if (lista.get(j).getId() > lista.get(j + 1).getId()) {
					Procesos temp = lista.get(j);
					lista.set(j, lista.get(j+1));
					lista.set(j+1,temp);
					
				}
			}
		}

	}

	public void lifoOrdering(DefaultListModel<Procesos> lista) {
		for (int i = 0; i < lista.size()-1; i++) {
			for (int j = 0; j < lista.size()-1; j++) {
				if (lista.get(j).getId() < lista.get(j + 1).getId()) {
					Procesos temp = lista.get(j);
					lista.set(j, lista.get(j+1));
					lista.set(j+1,temp);
				}
			}
		}
	}

	public void sjfOrdering(DefaultListModel<Procesos> lista) {
		for (int i = 0; i < lista.size()-1; i++) {
			for (int j = 0; j < lista.size()-1; j++) {
				if (lista.get(j).getQuantum() > lista.get(j + 1).getQuantum()) {
					Procesos temp = lista.get(j);
					Procesos pos2 = lista.get(j + 1);
					lista.set(j, pos2);
					lista.set(j+1,temp);
				}
			}
			
		}

	}

	public void priorOrdering(DefaultListModel<Procesos> lista) {
		for (int i = 0; i < lista.size()-1; i++) {
			for (int j = 0; j < lista.size()-1; j++) {
				if (lista.get(j).getPrioridad() > lista.get(j + 1).getPrioridad()) {
					Procesos temp = lista.get(j);
					Procesos pos2 = lista.get(j + 1);
					lista.set(j, pos2);
					lista.set(j+1,temp);
				}
			}
		}

	}
		
	
	

}
