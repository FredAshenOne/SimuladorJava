package main;

public class Procesos {
	
	
	
	 private String name;
	    private int quantum;
	    private int prioridad;
	    private int id;
	    
	    public Procesos (String name, int quantum,int prioridad, int id) {
	    	this.name = name;
	    	this.quantum = quantum;
	    	this.prioridad = prioridad;
	    	this.id = id;
	    };

	    public void setQuantum(int nuevoQuantum){
	        quantum = nuevoQuantum;
	    }
	    public int getQuantum(){
	        return quantum;
	    }

	    public void setName(String nuevoName){
	        name = nuevoName;
	    }

	    public String getName(){
	        return name;
	    }

	    public void setPrioridad(int nuevaPrioridad){
	        prioridad = nuevaPrioridad;
	    }

	    public int getPrioridad(){
	        return prioridad;
	    }

	    public void setId(int nuevoid) {
	        id = nuevoid;
	    }

	    public int getId() {
	        return id;
	    }

}
