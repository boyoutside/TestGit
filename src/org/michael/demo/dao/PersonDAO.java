package org.michael.demo.dao;

import java.util.Set;

import org.michael.demo.vo.Person;

public interface PersonDAO {
	/**
	 * 插入数据的操作
	 * 
	 * @param person
	 *            插入的是一个人员信息
	 * @return 操作成功与否的提示
	 * @throws Exception
	 *             如果有错误，则把错误抛给调用处处理
	 */
	public boolean doCreate(Person person) throws Exception;

	/**
	 * 更新数据操作
	 * 
	 * @param person
	 *            更新的具体信息
	 * @return 更新成功与否的提示
	 * @throws Exception
	 *             如果有错误，则把错误抛出
	 */
	public boolean doUpdate(Person person) throws Exception;

	/**
	 * 按id删除信息
	 * 
	 * @param id
	 *            人员的编号
	 * @return 删除与否的提示
	 * @throws Exception
	 *             如果有错误，则在调用处处理
	 */
	public boolean doDelete(String id) throws Exception;

	/**
	 * 因为查询是多个，所以要返回Set集合
	 * 
	 * @return 全部的查询结果，一个Set中包含了多个Person对象
	 * @throws Exception
	 */
	public Set<Person> findAll() throws Exception;

	/**
	 * 按id进行查询
	 * 
	 * @param id
	 *            人员的编号
	 * @return 具体的人员信息
	 * @throws Exception
	 */
	public Person findById(String id) throws Exception;

	/**
	 * 按关键字进行查询
	 * 
	 * @param keyWord
	 *            输入的关键字
	 * @return 返回一组信息
	 * @throws Exception
	 */
	public Set<Person> findByLike(String keyWord) throws Exception;
}
