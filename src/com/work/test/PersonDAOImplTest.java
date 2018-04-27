package com.work.test;


import org.junit.jupiter.api.Test;

import com.work.dao.impl.PersonDAOImpl;
import com.work.nativies.Party;
import com.work.nativies.Person;

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
	void testGetPersonByID() {
		Person person = pDAO.getPersonByID(1L);
		System.out.println(person.toString());
	}
}
