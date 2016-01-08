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
	// 所有的内容肯定保存在一个集合之中，因为一个集合可以直接向文件中保存
	// 此集合的内容最好由文件读取进来，因为文件本身中要保存对象，
	// 但是此程序牵扯到第一次运行的情况
	private Set<Person> allPerson;
	private FileOperate fo = null;
	public static String fileName = null;

	// 在构造方法中为其实例化
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
		// 就是插入操作
		// 在原有的基础上进行增加操作
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
		// 如果要删除之前必须先进行查找操作
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
		// 无论怎样更新，里面的id是不能改变的
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
			// 进行更新操作
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
					// id匹配成功，则取出此对象
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
			// 按姓名进行模糊查询
			Person p = iter.next();
			if (p.getName().indexOf(keyWord) != -1) {
				// 查到内容向search集合中存放
				search.add(p);
			}
		}
		return search;
	}
}
