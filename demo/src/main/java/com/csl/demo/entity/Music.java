package com.csl.demo.entity;

import javax.persistence.*;

@Entity
public class Music {
	@Id
	private String id;
	private String name;
	private String Singer;
	
	public Music() {
		super();
	}

	public Music(String id,String name, String singer) {
		super();
		this.id = id;
		this.name = name;
		Singer = singer;
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

	public String getSinger() {
		return Singer;
	}

	public void setSinger(String singer) {
		Singer = singer;
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", Singer=" + Singer + "]";
	}
}
