package org.michael.demo.operate;

import java.util.Iterator;

import org.michael.demo.dao.PersonDAO;
import org.michael.demo.factory.DAOFactory;
import org.michael.demo.util.InputData;
import org.michael.demo.util.TimeStamp;
import org.michael.demo.vo.Person;
import org.michael.demo.vo.Worker;

public class WorkerOperate {
	private PersonDAO dao = null;
	private InputData input = null;

	public WorkerOperate() {
		this.dao = DAOFactory.getPersonDAOInstance("worker.ser");
		this.input = new InputData();
	}

	public void add() {
		String id = new TimeStamp("w").getTimeStampRandom();
		System.out.print("���빤��������");
		String name = this.input.getString();
		System.out.print("���빤�����䣺");
		int age = this.input.getInt();
		System.out.print("���빤�˹��ʣ�");
		float salary = this.input.getFloat();
		Worker w = new Worker(id, name, age, salary);
		try {
			this.dao.doCreate(w);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		String id = null;
		System.out.print("������Ҫɾ���Ĺ���ID��");
		id = input.getString();
		try {
			this.dao.doDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		// ����֮ǰ��Ҫ�Ȳ�ѯ����
		String id = null;
		System.out.print("������Ҫ�޸ĵĹ���ID��");
		id = input.getString();
		Worker w = null;
		try {
			w = (Worker) this.dao.findById(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("���빤��������ԭ������" + w.getName() + "����");
		String name = this.input.getString();
		System.out.print("���빤�����䣨ԭ���䣺" + w.getAge() + "����");
		int age = this.input.getInt();
		System.out.print("���빤�˹��ʣ�ԭ���ʣ�" + w.getSalary() + "����");
		float salary = this.input.getFloat();
		w.setName(name);
		w.setAge(age);
		w.setSalary(salary);
		try {
			this.dao.doUpdate(w);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findAll() {
		Iterator<Person> iter = null;
		try {
			iter = this.dao.findAll().iterator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ID\t\t\t����\t����\t����");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

	public void findByLike() {
		String keyWord = null;
		System.out.print("�������ѯ�ؼ��֣�");
		keyWord = this.input.getString();
		Iterator<Person> iter = null;
		try {
			iter = this.dao.findByLike(keyWord).iterator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ID\t\t\t����\t����\t����");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
