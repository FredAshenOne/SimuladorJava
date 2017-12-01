package main;

public class Procesos {

	private String name;
	private int quantum;
	private int prioridad;
	private int id;
	private String status;

	public Procesos(String name, int quantum, int prioridad, int id,String status) {
		this.name = name;
		this.quantum = quantum;
		this.prioridad = prioridad;
		this.id = id;
		this.status = status;
	};

	public void setQuantum(int nuevoQuantum) {
		quantum = nuevoQuantum;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setName(String nuevoName) {
		name = nuevoName;
	}

	public String getName() {
		return name;
	}

	public void setPrioridad(int nuevaPrioridad) {
		prioridad = nuevaPrioridad;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setId(int nuevoid) {
		id = nuevoid;
	}

	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
