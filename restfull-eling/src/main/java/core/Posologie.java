package main.java.core;

public class Posologie {

	public Integer id;
	public String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Posologie(Integer id, String name) {
		super();
		this.id = id;
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
