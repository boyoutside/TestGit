package org.michael.demo.vo;

public class Worker extends Person {
	private static final long serialVersionUID = 1L;
	private float salary;

	public Worker(String id, String name, int age, float salary) {
		super(id, name, age);
		this.setSalary(salary);
	}

	public int compareTo(Object arg0) {
		Worker w = (Worker) arg0;
		if (this.salary < w.salary) {
			return 1;
		} else if (this.salary > w.salary) {
			return -1;
		} else {
			if (super.getAge() < w.getAge()) {
				return -1;
			} else if (super.getAge() > w.getAge()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public String toString() {
		return this.getId() + "\t" + this.getName() + "\t" + this.getAge()
				+ "\t" + this.salary;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}
