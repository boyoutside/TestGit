package org.michael.demo.dao;

import java.util.Set;

import org.michael.demo.vo.Person;

public interface PersonDAO {
	/**
	 * �������ݵĲ���
	 * 
	 * @param person
	 *            �������һ����Ա��Ϣ
	 * @return �����ɹ�������ʾ
	 * @throws Exception
	 *             ����д�����Ѵ����׸����ô�����
	 */
	public boolean doCreate(Person person) throws Exception;

	/**
	 * �������ݲ���
	 * 
	 * @param person
	 *            ���µľ�����Ϣ
	 * @return ���³ɹ�������ʾ
	 * @throws Exception
	 *             ����д�����Ѵ����׳�
	 */
	public boolean doUpdate(Person person) throws Exception;

	/**
	 * ��idɾ����Ϣ
	 * 
	 * @param id
	 *            ��Ա�ı��
	 * @return ɾ��������ʾ
	 * @throws Exception
	 *             ����д������ڵ��ô�����
	 */
	public boolean doDelete(String id) throws Exception;

	/**
	 * ��Ϊ��ѯ�Ƕ��������Ҫ����Set����
	 * 
	 * @return ȫ���Ĳ�ѯ�����һ��Set�а����˶��Person����
	 * @throws Exception
	 */
	public Set<Person> findAll() throws Exception;

	/**
	 * ��id���в�ѯ
	 * 
	 * @param id
	 *            ��Ա�ı��
	 * @return �������Ա��Ϣ
	 * @throws Exception
	 */
	public Person findById(String id) throws Exception;

	/**
	 * ���ؼ��ֽ��в�ѯ
	 * 
	 * @param keyWord
	 *            ����Ĺؼ���
	 * @return ����һ����Ϣ
	 * @throws Exception
	 */
	public Set<Person> findByLike(String keyWord) throws Exception;
}
