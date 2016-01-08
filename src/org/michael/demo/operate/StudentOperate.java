package org.michael.demo.operate;

import java.util.Iterator;

import org.michael.demo.dao.PersonDAO;
import org.michael.demo.util.InputData;
import org.michael.demo.util.TimeStamp;
import org.michael.demo.vo.Person;
import org.michael.demo.vo.Student;
import org.michael.demo.factory.*;

public class StudentOperate implements PersonOperate {
	private PersonDAO dao = null;
	private InputData input = null;

	public StudentOperate() {
		this.dao = DAOFactory.getPersonDAOInstance("student.ser");
		this.input = new InputData();
	}

	public void add() {
		String id = new TimeStamp("s").getTimeStampRandom();
		System.out.print("输入学生姓名：");
		String name = this.input.getString();
		System.out.print("输入学生年龄：");
		int age = this.input.getInt();
		System.out.print("输入学生成绩：");
		float score = this.input.getFloat();
		Student s = new Student(id, name, age, score);
		try {
			this.dao.doCreate(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		String id = null;
		System.out.print("请输入要删除的学生ID：");
		id = input.getString();
		try {
			this.dao.doDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		// 更新之前需要先查询出来
		String id = null;
		System.out.print("请输入要修改的学生ID：");
		id = input.getString();
		Student s = null;
		try {
			s = (Student) this.dao.findById(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("输入学生姓名（原姓名：" + s.getName() + "）：");
		String name = this.input.getString();
		System.out.print("输入学生年龄（原年龄：" + s.getAge() + "）：");
		int age = this.input.getInt();
		System.out.print("输入学生成绩（原成绩：" + s.getScore() + "）：");
		float score = this.input.getFloat();
		s.setName(name);
		s.setAge(age);
		s.setScore(score);
		try {
			this.dao.doUpdate(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findAll() {
		Iterator<Person> iter = null;
		try {
			iter = this.dao.findAll().iterator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ID\t\t\t姓名\t年龄\t成绩");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

	public void findByLike() {
		String keyWord = null;
		System.out.print("请输入查询关键字：");
		keyWord = this.input.getString();
		Iterator<Person> iter = null;
		try {
			iter = this.dao.findByLike(keyWord).iterator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ID\t\t\t姓名\t年龄\t成绩");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
