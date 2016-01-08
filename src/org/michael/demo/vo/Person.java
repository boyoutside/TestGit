package org.michael.demo.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Person implements Comparable<Object>, Serializable {
	// 定义各公共属性
	private String id;
	private String name;
	private int age;

	public Person(String id, String name, int age) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
