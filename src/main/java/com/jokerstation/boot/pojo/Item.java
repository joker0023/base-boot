package com.jokerstation.boot.pojo;

import java.io.Serializable;

//import javax.persistence.Id;

public class Item implements Serializable {

	private static final long serialVersionUID = 8318025688310322727L;

//	@Id
	private Long id;
	
	private String name;
	
	private Integer count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
