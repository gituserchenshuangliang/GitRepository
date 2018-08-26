package csl.demo.dao;
public class App {
	private String id;
	private String name;
	private int some;

	public App(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public int getSome() {
		return some;
	}

	public void setSome(int some) {
		this.some = some;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", name=" + name + ", some=" + some + "]";
	}
	
}
