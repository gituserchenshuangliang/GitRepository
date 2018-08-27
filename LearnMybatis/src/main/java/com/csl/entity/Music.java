package com.csl.entity;

public class Music {
	private int id;
	private String name;
	private String dir;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public Music(String name, String dir) {
		super();
		this.name = name;
		this.dir = dir;
	}
}
