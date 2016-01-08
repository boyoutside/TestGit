package org.michael.demo.factory;

import org.michael.demo.dao.PersonDAO;
import org.michael.demo.proxy.PersonDAOProxyFile;

public class DAOFactory {
	public static PersonDAO getPersonDAOInstance() {
		return null;
	}

	public static PersonDAO getPersonDAOInstance(String path) {
		return (PersonDAO) new PersonDAOProxyFile(path);
	}
}
