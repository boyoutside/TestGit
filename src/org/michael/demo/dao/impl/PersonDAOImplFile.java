package org.michael.demo.dao.impl;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.michael.demo.dao.PersonDAO;
import org.michael.demo.io.FileOperate;
import org.michael.demo.vo.Person;
import org.michael.demo.vo.Student;
import org.michael.demo.vo.Worker;

public class PersonDAOImplFile implements PersonDAO {
	// ���е����ݿ϶�������һ������֮�У���Ϊһ�����Ͽ���ֱ�����ļ��б���
	// �˼��ϵ�����������ļ���ȡ��������Ϊ�ļ�������Ҫ�������
	// ���Ǵ˳���ǣ������һ�����е����
	private Set<Person> allPerson;
	private FileOperate fo = null;
	public static String fileName = null;

	// �ڹ��췽����Ϊ��ʵ����
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PersonDAOImplFile() {
		this.fo = new FileOperate(fileName);
		try {
			this.allPerson = (Set) fo.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean doCreate(Person person) throws Exception {
		// ���ǲ������
		// ��ԭ�еĻ����Ͻ������Ӳ���
		boolean flag = false;
		try {
			this.allPerson.add(person);
			this.fo.save(this.allPerson);
			flag = true;
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean doDelete(String id) throws Exception {
		boolean flag = false;
		// ���Ҫɾ��֮ǰ�����Ƚ��в��Ҳ���
		try {
			this.allPerson.remove(this.findById(id));
			this.fo.save(this.allPerson);
			flag = true;
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean doUpdate(Person person) throws Exception {
		// �����������£������id�ǲ��ܸı��
		boolean flag = false;
		try {
			Person p = this.findById(person.getId());
			if (person instanceof Student) {
				Student oldO = (Student) p;
				Student newO = (Student) person;
				oldO.setId(newO.getId());
				oldO.setName(newO.getName());
				oldO.setAge(newO.getAge());
				oldO.setScore(newO.getScore());
			}
			if (person instanceof Worker) {
				Worker oldO = (Worker) p;
				Worker newO = (Worker) person;
				oldO.setId(newO.getId());
				oldO.setName(newO.getName());
				oldO.setAge(newO.getAge());
				oldO.setSalary(newO.getSalary());
			}
			// ���и��²���
			this.allPerson.add(p);
			this.fo.save(this.allPerson);
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public Set<Person> findAll() throws Exception {
		return this.allPerson;
	}

	public Person findById(String id) throws Exception {
		Person per = null;
		try {
			Iterator<Person> iter = this.allPerson.iterator();
			while (iter.hasNext()) {
				Person p = iter.next();
				if (p.getId().equals(id)) {
					// idƥ��ɹ�����ȡ���˶���
					per = p;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return per;
	}

	public Set<Person> findByLike(String keyWord) throws Exception {
		Set<Person> search = new TreeSet<Person>();
		Iterator<Person> iter = this.allPerson.iterator();
		while (iter.hasNext()) {
			// ����������ģ����ѯ
			Person p = iter.next();
			if (p.getName().indexOf(keyWord) != -1) {
				// �鵽������search�����д��
				search.add(p);
			}
		}
		return search;
	}
}
