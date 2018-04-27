package com.work.test;

import org.junit.jupiter.api.Test;

import com.work.dao.impl.PersonDAOImpl;
import com.work.nativies.Party;
import com.work.nativies.Person;
import com.work.nativies.PersonAllMessage;

class PersonDAOImplTest {
	PersonDAOImpl pDAO = new PersonDAOImpl();

	@Test
	void testSave() {
		Person newPerson = new Person();
		newPerson.setName("一点红");
		newPerson.setGend("男");
		pDAO.save(newPerson);
		Party party = new Party();
		party.setPartyName("修理所");
		pDAO.save(party);
	}

	@Test
	void test1() {
		PersonAllMessage personAllMessage = pDAO.getPersonByID(1L);
		System.out.println(personAllMessage.toString());
	}
}
