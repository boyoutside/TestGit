package org.michael.demo.vo;

public class Student extends Person {
	private static final long serialVersionUID = 1L;
	private float score;

	public Student(String id, String name, int age, float score) {
		super(id, name, age);
		this.setScore(score);
	}

	public int compareTo(Object arg0) {
		Student s = (Student) arg0;
		if (this.score < s.score) {
			return 1;
		} else if (this.score > s.score) {
			return -1;
		} else {
			if (super.getAge() < s.getAge()) {
				return -1;
			} else if (super.getAge() > s.getAge()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public String toString() {
		return this.getId() + "\t" + this.getName() + "\t" + this.getAge()
				+ "\t" + this.score;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}
