package com.work.dao.impl;

import java.util.List;

import com.work.dao.IPersonDAO;
import com.work.hander.impl.BeanHandler;
import com.work.hander.impl.BeanListHandler;
import com.work.hibernate.HibernateMock;
import com.work.nativies.Person;
import com.work.nativies.PersonAllMessage;

import util.DruidUtil;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public PersonAllMessage getPersonByID(Long id) {
		String sql ="SELECT\r\n" + 
				"person.id,\r\n" + 
				"person.name,\r\n" + 
				"person.birthday,\r\n" + 
				"person.militaryTime,\r\n" + 
				"person.gend,\r\n" + 
				"person.partyTime,\r\n" + 
				"person.remark,\r\n" + 
				"party.partyname,\r\n" + 
				"address.province,\r\n" + 
				"address.city,\r\n" + 
				"address.country,\r\n" + 
				"rank.rankname\r\n" + 
				"FROM\r\n" + 
				"address ,\r\n" + 
				"party ,\r\n" + 
				"person ,\r\n" + 
				"rank\r\n" + 
				"WHERE\r\n" + 
				"person.id_rank = rank.id_rank AND\r\n" + 
				"person.id_address = address.id_address AND\r\n" + 
				"person.id_party = party.id_party AND\r\n" + 
				"party.id = ?\r\n"; 
		PersonAllMessage personAllMessage = DruidUtil.query(sql, new BeanHandler<PersonAllMessage>(PersonAllMessage.class),id);
		return personAllMessage;
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
