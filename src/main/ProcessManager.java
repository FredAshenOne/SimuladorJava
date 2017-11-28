package main;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ProcessManager {	
	
	

	JList listp = new JList();
	
    int id = 1;
    public int len;

    Scanner ask = new Scanner(System.in);
    List<Procesos> processList = Collections.synchronizedList(new ArrayList<Procesos>());
    Iterator<Procesos> listIterator = processList.iterator();
    
//agregar un nuevo proceso a la lista 

    public void addProcess(Procesos procesos) {
            processList.add(procesos);
           
    }
    
    

    
    public List<Procesos> getProcessList(){
    	getLen(processList);
    	List<Procesos> vector = new Vector<>();
    	for (Procesos proceso : processList) {
    		vector.add(proceso);
    	}
    	return vector;
    }

    ListCellRenderer<? super Procesos> getCellRender(){

        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                Procesos proceso = (Procesos) value;
                return super.getListCellRendererComponent(list,
                		proceso.getName()+ "/n Quantum:"+proceso.getQuantum()+"/n Prioridad: "+proceso.getPrioridad()+
                		"/n Id: "+proceso.getId(),index, isSelected, cellHasFocus);

            }
        };
    }
    
    public int getLen(List<Procesos> proces) {
    	return proces.size(); 
    }
 
    public void listPrinter(List<Procesos> processList){
        Iterator<Procesos> itr = processList.iterator();
        while(itr.hasNext()){
            Procesos element = itr.next();
            System.out.println(element.getName()+" "+ element.getQuantum()+ " " + element.getPrioridad());
        }
    }
            
    
    
}
