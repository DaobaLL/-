package com.work.dao.impl;

import java.util.List;

import com.work.dao.IPersonDAO;
import com.work.hander.impl.BeanHandler;
import com.work.hander.impl.BeanListHandler;
import com.work.hibernate.HibernateMock;
import com.work.nativies.Person;

import util.DruidUtil;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public Person getPersonByID(Long id) {
		String sql ="SELECT * FROM person WHERE id= 1" ;
		Person person = DruidUtil.query(sql, new BeanHandler<Person>(Person.class));
		return person;
	}

	@Override
	public void save(Object object) {
		try {
			HibernateMock.save(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
