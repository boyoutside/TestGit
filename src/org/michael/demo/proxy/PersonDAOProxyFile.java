package org.michael.demo.proxy;

import java.util.Set;

import org.michael.demo.dao.PersonDAO;
import org.michael.demo.dao.impl.PersonDAOImplFile;
import org.michael.demo.vo.Person;

public class PersonDAOProxyFile {
	private PersonDAO dao = null;

	public PersonDAOProxyFile(String fileName) {
		PersonDAOImplFile.fileName = fileName;
		this.dao = new PersonDAOImplFile();
	}

	public boolean doCreate(Person person) throws Exception {
		return this.dao.doCreate(person);
	}

	public boolean doDelete(String id) throws Exception {
		return this.dao.doDelete(id);
	}

	public boolean doUpdate(Person person) throws Exception {
		return this.dao.doUpdate(person);
	}

	public Set<Person> findAll() throws Exception {
		return this.dao.findAll();
	}

	public Person findById(String id) throws Exception {
		return this.dao.findById(id);
	}

	public Set<Person> findByLike(String keyWord) throws Exception {
		return this.dao.findByLike(keyWord);
	}

}
